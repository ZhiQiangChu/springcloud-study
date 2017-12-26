package com.zzf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author : zzf
 * @date: 2017/11/1
 * @time: 17:09
 * @description : 应用服务启动类, 这个是一个注册中心
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

    public static void main(String[] args) {

        // 因为在pom 中引入了spring-boot-starter-web, 所以使用下面的方式启动
        SpringApplication.run(EurekaApplication.class, args);

        // 没有引入上面的包使用下面的方式进行启动
        // new SpringApplicationBuilder(EurekaApplication.class).web(true).run(args);

    }
}
