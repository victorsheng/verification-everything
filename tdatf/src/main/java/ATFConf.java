import com.alibaba.druid.pool.DruidDataSource;
import com.talkingdata.sdx.atf.Clerk;
import com.talkingdata.sdx.atf.Scheduler;
import com.talkingdata.sdx.atf.TaskConsumer;
import com.talkingdata.sdx.atf.entity.TaskEntity;
import com.talkingdata.sdx.atf.entity.TaskResultEntity;
import com.talkingdata.sdx.atf.impl.DefaultClerk;
import com.talkingdata.sdx.atf.impl.DefaultScheduler;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.talkingdata.sdx.atf.dao")
@Configuration
public class ATFConf {

  @Bean
  public Scheduler defaultScheduler(@Autowired Clerk clerk) {
    DefaultScheduler ds = new DefaultScheduler(new TaskConsumer() {
      public TaskResultEntity consume(TaskEntity e) {
        System.out.println("consume");
        return new TaskResultEntity();
      }
    },
        clerk);  //将TaskConsumer的具体实现设置到Scheduler中
    return ds.init(1);  //启动Scheduler
  }


  @Bean
  public Clerk defaultClerk() {
    Clerk defaultClerk = new DefaultClerk();
    return defaultClerk;
  }

  @Bean
  public DataSource datasource() {
    DruidDataSource ds = new DruidDataSource();
    ds.setUrl(
        "jdbc:mysql://localhost:3306/local_td_atf");
    ds.setUsername("local_td_atf");
    ds.setPassword("local_td_atf");

    return ds;
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    return new DataSourceTransactionManager(datasource());
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(datasource());
    sessionFactory.setMapperLocations(
        new PathMatchingResourcePatternResolver().getResources("classpath*:mappers/*Mapper.xml"));
    return sessionFactory.getObject();
  }

}
