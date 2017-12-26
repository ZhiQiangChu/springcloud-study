package com.zzf;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zzf
 * @date: 2017/12/24
 * @time: 20:26
 * @description : spring cloud 配置中心的启动类
 */
@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder(SpringCloudConfigApplication.class).web(true).run(args);
    }
}
