package com.cai.springcloud;

import com.cai.TestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="PROVIDER-USER",configuration = TestConfig.class)
public class ConsumerOrder {

    @Bean//相当于 xml中的bean标签，主要是用于调用当前方法获取指定对象
    public RestTemplate getTemp(){
        return new RestTemplate();
    }
    public static void main( String[] args )
    {
        SpringApplication.run(ConsumerOrder.class);
    }
}
