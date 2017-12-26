package com.zzf.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zzf
 * @date: 2017/12/25
 * @time: 11:44
 * @description : 消费的服务
 */
@Service
public class ConsumerService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 进行容错降级（fallbackMethod 后面的是容错要调用的方法）
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer(){
        String url  = "http://eureka-client/disconver";
        return restTemplate.getForObject(url, String.class);
    }

    /**
     * 调用失败后进行降级到这个方法
     * @return
     */
    public String fallback(){
        return "fallback--->>";
    }
}
