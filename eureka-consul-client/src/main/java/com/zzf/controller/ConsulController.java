package com.zzf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zzf
 * @date: 2017/12/24
 * @time: 10:02
 * @description : consul 的访问类
 */
@RestController
public class ConsulController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("consul")
    public String consul(){

        String services = "" + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }
}
