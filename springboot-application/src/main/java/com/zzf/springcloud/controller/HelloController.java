package com.zzf.springcloud.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zzf
 * @date: 2017/11/1
 * @time: 23:35
 * @tescription : 测试服务发现的controller
 */
@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass());
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index(){

        // 获取本地服务实例
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello, host : " + instance.getHost() + ", service_id : " + instance.getServiceId());
        return "Hello World";
    }
}
