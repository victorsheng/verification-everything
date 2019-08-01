package conf;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.RetryListener;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import service.DefaultListenerSupport;
import service.Foo;
import service.FooService;
//import service.RecoryHandler;

@Configuration
@EnableRetry
public class SpringConf {

  @Bean
  public FooService fooService() {
    return new FooService();
  }

//  @Bean
//  public RecoryHandler recoryHandler() {
//    return new RecoryHandler();
//  }

  @Bean
  public Foo f() {
    return new Foo();
  }

  @Bean
  public DefaultListenerSupport defaultListenerSupport(){
    return new DefaultListenerSupport();
  }

  @Bean
  public RetryTemplate retryTemplate(DefaultListenerSupport listener) {
    RetryTemplate retryTemplate = new RetryTemplate();

    FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
    fixedBackOffPolicy.setBackOffPeriod(2000l);
    //backoff  策略
    //规避,让开
    //BackOffPolicy is used to control back off between retry attempts
    retryTemplate.setBackOffPolicy(fixedBackOffPolicy);

    SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
    retryPolicy.setMaxAttempts(2);
    //重试策略
    //RetryPolicy determines when an operation should be retried
    retryTemplate.setRetryPolicy(retryPolicy);

    RetryListener[] retryListeners = {listener};
    retryTemplate.setListeners(retryListeners);

    return retryTemplate;
  }

}
