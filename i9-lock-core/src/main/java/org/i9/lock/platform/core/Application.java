package org.i9.lock.platform.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/** 
 * 创建时间：2017年10月31日 下午11:18:34
 * @author  lby
 * @version  
 * 为了打包war包执行，需要继承SpringBootServletInitializer 
 */


@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan("org.i9.lock.platform")
@ServletComponentScan // 扫描使用注解方式的servlet 
@SpringBootApplication
public class Application extends SpringBootServletInitializer{
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
