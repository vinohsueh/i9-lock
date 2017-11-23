package org.i9.lock.platform.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan("org.i9.lock.platform")
@ServletComponentScan // 扫描使用注解方式的servlet 
@ImportResource(value = { "classpath:applicationContext.xml" })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
