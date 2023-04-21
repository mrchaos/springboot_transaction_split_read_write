package cherry.cworld.awsproxyrds.config.datasource;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ReplicationRoutingConfiguration {

    @Autowired
    MasterDetails masterDetails;

    @Autowired
    SlaveDetails slaveDetails;

    @Primary
    @Bean
    public DataSource dataSource() {
        return new LazyConnectionDataSourceProxy(replicationDataSource());
    }

    @Bean
    public DataSource replicationDataSource() {
        Map<Object, Object> targetDataSources = new HashMap<>();
        DataSource masterDataSource = masterDataSource();
        DataSource slaveDataSource = slaveDataSource();
        targetDataSources.put(ReplicationType.WRITE, masterDataSource);
        targetDataSources.put(ReplicationType.READ, slaveDataSource);

        ReplicationDataSourceRouter clientRoutingDatasource = new ReplicationDataSourceRouter();
        clientRoutingDatasource.setTargetDataSources(targetDataSources);
        clientRoutingDatasource.setDefaultTargetDataSource(masterDataSource);
        return clientRoutingDatasource;
    }

    @Bean
    public DataSource masterDataSource() {
        SimpleDriverDataSource ds = new SimpleDriverDataSource();

        ds.setDriverClass(org.postgresql.Driver.class);
        ds.setUrl(masterDetails.getUrl());
        ds.setUsername(masterDetails.getUsername());
        ds.setPassword(masterDetails.getPassword());
        return ds;
    }

    @Bean
    public DataSource slaveDataSource() {
        SimpleDriverDataSource ds = new SimpleDriverDataSource();

        ds.setDriverClass(org.postgresql.Driver.class);
        ds.setUrl(slaveDetails.getUrl());
        ds.setUsername(slaveDetails.getUsername());
        ds.setPassword(slaveDetails.getPassword());
        return ds;
    }

}
