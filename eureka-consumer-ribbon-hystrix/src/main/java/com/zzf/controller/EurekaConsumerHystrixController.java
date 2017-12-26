package com.zzf.controller;

import com.zzf.service.ConsumerService;
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
public class EurekaConsumerHystrixController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/balancedConsumerHystrix")
    public String eurekaConsumer(){
        return consumerService.consumer();
    }
}

