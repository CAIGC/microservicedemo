package com.cai.springcloud.controller;

import com.cai.springcloud.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CAI_GC on 2019/5/17.
 */
@RestController
public class OrderController {

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id){
        return new User(id);
    }
}
