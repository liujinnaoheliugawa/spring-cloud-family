package com.liugawaheliujinnao.singleFunction.springCloudFamily.zuulServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-29
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class SpringCloudZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuulServerApplication.class, args);
    }
}
