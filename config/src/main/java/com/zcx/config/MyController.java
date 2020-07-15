package com.zcx.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MyController {

    @Value("${myNameKey:zhangsan}")
    private String myName;

    @Autowired
    private MyConfig configs;

    @RequestMapping("test")
    public String test(){
        return myName;
    }

    @RequestMapping("getobj")
    public String getobj(){
        return configs.toString();
    }
}
