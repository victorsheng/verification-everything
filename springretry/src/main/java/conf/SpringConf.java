package conf;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import service.Foo;
import service.FooService;
import service.RecoryHandler;

@Configuration
@EnableRetry
public class SpringConf {

  @Bean
  public FooService fooService() {
    return new FooService();
  }

  @Bean
  public RecoryHandler recoryHandler() {
    return new RecoryHandler();
  }

  @Bean
  public Foo f() {
    return new Foo();
  }

}
