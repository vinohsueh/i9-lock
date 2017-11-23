package org.i9.lock.platform.api.config;

import org.i9.lock.platform.api.interceptor.UserLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * 项目web配置
 * 
 * 
 * @author lby
 *
 * @create 2017年11月14日
 *
 */
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

	/**
	 * 配置拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		// 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
		
		registry.addInterceptor(new UserLoginInterceptor()).addPathPatterns("/**");
		
		
		super.addInterceptors(registry);
	}
	
	/**
	 * 添加自定义的静态资源映射
	 * 这样使用代码的方式自定义目录映射，并不影响Spring Boot的默认映射，可以同时使用。
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
//		registry.addResourceHandler("/myres/**").addResourceLocations("classpath:/myres/");
//		registry.addResourceHandler("/**").addResourceLocations("/");
		super.addResourceHandlers(registry);
	}
	
}
