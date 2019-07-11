package service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

public class FooService {

  @Retryable(
      value = {RuntimeException.class},
      maxAttempts = 2,
      backoff = @Backoff(delay = 50))
  public String hi(String name) {
    System.out.println("hi execute");
    throw new IllegalStateException();
//    return s;
  }

  //不仅要参数一致,而且返回值也要一致
  @Recover
  public String recovery(IllegalStateException e, String name) {
//    System.out.println("exception:" + e);
    System.out.println("recover:" + name);
    return "recovery";
  }


}
