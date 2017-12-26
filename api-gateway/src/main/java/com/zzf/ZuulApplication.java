package com.zzf;

import com.zzf.filter.AccessFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zzf
 * @date: 2017/12/25
 * @time: 16:59
 * @description : 创建网关的应用主类, 并使用 @EnableZuulProxy注解开启Zuul的功能。
 */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
    }

    /**
     * 如果这里不作为一个bean 的话可以在， AccessFilter 上添加一个@Component
     * 组建注解
     */
   /* @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }*/
}
