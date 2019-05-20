package com.cai.springcloud.controller;

import com.cai.springcloud.pojo.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by CAI_GC on 2019/5/17.
 */
@RestController
public class OrderController {
    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id){
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("provider-user", false);
        String url = instance.getHomePageUrl();
        User user = restTemplate.getForObject(url+"/user/"+id,User.class);
        return user;
    }
}
