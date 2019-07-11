package main;

import conf.SpringConf;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.Foo;
import service.FooService;

public class Main2 {


  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        SpringConf.class);
    Foo bean = context.getBean(Foo.class);
    bean.out("foo");
    bean.out("tom");
  }

}
