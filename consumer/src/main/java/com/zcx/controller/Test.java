package com.zcx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class Test {
    @Autowired
    private DiscoveryClient client;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("service")
    public List servieces(){
        return client.getServices();
    }

    @RequestMapping("bcall")
    public String balanceCall(){
        ServiceInstance instance = loadBalancerClient.choose("provider");

        String url = instance.getUri().toString() + "/test";

        RestTemplate restTemplate = new RestTemplate();

        String s = restTemplate.getForObject(url, String.class);
        System.out.println(s);
        return s;
    }
}
