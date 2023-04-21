# Read / Write Transaction 분리
 - springboot에서 Read / Write Transaction 분리하여 데이터소스에 접근
 - springboot에 있는 HikariCP를 사용하지 않고 외부 Pool(예 AWS RDS Proxy)에 직접연결 하기 위해 HikariCP를 disable
    . spring.datasource.type=org.springframework.jdbc.datasource.SimpleDriverDataSource
    . datasource로 SimpleDriverDataSource를 사용
    '''
    public DataSource masterDataSource() {
        SimpleDriverDataSource ds = new SimpleDriverDataSource();

        ds.setDriverClass(org.postgresql.Driver.class);
        ds.setUrl(masterDetails.getUrl());
        ds.setUsername(masterDetails.getUsername());
        ds.setPassword(masterDetails.getPassword());
        return ds;
    }  
    '''
    . application.properties 파일에서 username, password, url등은 필요 맞게 수정하여 사용
    '''
    #master
    spring.datasource.master.url=jdbc:postgresql://{Reader/Writer End Pointer}/{DBName}
    spring.datasource.master.username={User Name}
    spring.datasource.master.password={User Password}
    spring.datasource.master.driver-class-name=org.postgresql.Driver

    #slave
    spring.datasource.slave.url=jdbc:postgresql://{Reader End Pointer}/{DBName}
    spring.datasource.slave.username={Usre Name}
    spring.datasource.slave.password={User Password}
    spring.datasource.slave.driver-class-name=org.postgresql.Driver    
    '''

 - service 파일 참조
 '''
  @Transactional(readOnly = true)
  @Service
  public class UserService  {
      @Autowired
      private UserMapper mapper;
      
      // Master datasource에 connect
      public List<User> selectUsers(HashMap<Object,Object> vo) {
          return mapper.selectUsers(vo);                
      }

      // Slaver datasource에 connect
      @Transactional
      public void updateUserByID(HashMap<Object,Object> vo) {
          int updateCount = mapper.updateUserByID(vo);
          log.info("UPDATED COUNT : {}", updateCount);
      }
      ....
  }
 '''
### 참조 URLs
 - https://velog.io/@code-10/Spring-Boot-%EC%97%90%EC%84%9CAbstractRoutingDatasource-%EC%82%AC%EC%9A%A9%ED%95%9C-Read-Write-%EB%B6%84%EB%A6%AC
 - https://eddies.tistory.com/35
### 참조 Git
 - https://github.com/code-h10/spring-study/tree/main/oauth2
### 중요
 - mybatis 버전이 3.0.1 : @Autowired 사용시 에러발생 없음
 - 2.x.x 버전에서 @Autowired 사용시 에러발생