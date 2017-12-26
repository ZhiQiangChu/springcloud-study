package com.zzf.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zzf
 * @date: 2017/12/20
 * @time: 17:08
 * @description :  eureka 客户端发现测试客户端发现
 */
@RestController
public class DisconveryClientController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/disconver")
    public String getDisconveryInfo() throws InterruptedException {

        // 添加这个是为了测试(容错降级的操作， 这个其实也是可以打断点进行操作)
        // Thread.sleep(5000L);
        // 获取服务列表清单
        String service = "Service" + discoveryClient.getServices();
        System.out.println("eureka-client ==== >>> " + service);
        return service;
    }
}