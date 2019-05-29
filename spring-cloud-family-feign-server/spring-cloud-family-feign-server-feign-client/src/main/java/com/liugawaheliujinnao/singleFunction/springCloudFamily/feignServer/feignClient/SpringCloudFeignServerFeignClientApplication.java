package com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignClient;

import com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignApi.service.PersonService;
import com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignClient.ribbon.FirstServerForeverRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-29
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(clients = PersonService.class)
@EnableHystrix
//@RibbonClient(value = "person-service", configuration = PersonClientApplication.class)
public class SpringCloudFeignServerFeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFeignServerFeignClientApplication.class, args);
    }

    @Bean
    public FirstServerForeverRule firstServerForeverRule() {
        return new FirstServerForeverRule();
    }
}
