package cherry.cworld.awsproxyrds.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ReplicationDataSourceRouter extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        boolean isReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
        if (isReadOnly) {
            log.info("!!!!!!!!!!!!!!!!!! READ !!!!!!!!!!!!!!!!!!!!");
            return ReplicationType.READ;
        }
        log.info("!!!!!!!!!!!!!!!!!! WRITE !!!!!!!!!!!!!!!!!!!!");
        return ReplicationType.WRITE;
    }    
}