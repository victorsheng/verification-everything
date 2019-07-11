package service;

import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

@Component
public class Foo {

  @Retryable(include = NoResultException.class)
  public void out(String foo) {
    System.out.println(foo);
    if (foo.equals("foo")) {
      throw new NoResultException();
    } else {
      throw new IllegalStateException();
    }
  }

  @Recover
  public void connectionException(NoResultException e, String foo) {
    System.out.println("Retry failure-1" + foo);
  }

  @Recover
  public void connectionException(Exception e, String foo) throws Exception {
    System.out.println("Retry failure-2" + foo);
    throw e;
  }

  private class NoResultException extends RuntimeException {

  }
}