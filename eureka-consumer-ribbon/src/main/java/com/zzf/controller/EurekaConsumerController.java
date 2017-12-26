package com.zzf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zzf
 * @date: 2017/12/23
 * @time: 21:54
 * @description : 一个接口用来消费eureka-client提供的接口
 */
@RestController
public class EurekaConsumerController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/balancedConsumer")
    public String eurekaConsumer(){

        String url  = "http://eureka-client/disconver";
        return restTemplate.getForObject(url, String.class);
    }

}
