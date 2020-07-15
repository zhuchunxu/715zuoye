package com.zcx.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BalanceConfig {
    @Bean
    public IRule myRule(){
        //随即
        return new RandomRule();
    }

}
