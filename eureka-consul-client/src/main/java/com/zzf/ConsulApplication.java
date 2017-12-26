package com.zzf;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zzf
 * @date: 2017/12/24
 * @time: 9:42
 * @description : consul启动类
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsulApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConsulApplication.class).web(true).run(args);
    }
}
