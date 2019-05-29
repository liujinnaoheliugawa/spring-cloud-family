package com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignServiceProvidor;

import com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignApi.web.WebConfig;
import com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignServiceProvidor.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description: {@link PersonService} 提供者应用
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-29
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@Import(WebConfig.class)
@EnableTransactionManagement(proxyTargetClass = true)
public class SpringCloudFeignServerFeignServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFeignServerFeignServiceProviderApplication.class, args);
    }
}
