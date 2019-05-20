package com.cai.springcloud.controller;

import com.cai.springcloud.pojo.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CAI_GC on 2019/5/17.
 */
@RestController
public class UserController {
    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id){
        return new User(id);
    }

    @GetMapping(value = "/eurekaInfo")
    public String info() {
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("provider-user", false);
        return instance.getHomePageUrl();
    }
}
