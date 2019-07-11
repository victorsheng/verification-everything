package main;

import conf.SpringConf;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.FooService;

public class Main {


  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        SpringConf.class);
    FooService bean = context.getBean(FooService.class);
    String hi = bean.hi("tom");
    System.out.println(hi);
  }

}
