package com.zcx;

import com.zcx.config.BalanceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@RibbonClient(name="provider",configuration = {BalanceConfig.class})
public class Consumer {
    public static void main(String[] args) {
        SpringApplication.run(Consumer.class);
    }
}
