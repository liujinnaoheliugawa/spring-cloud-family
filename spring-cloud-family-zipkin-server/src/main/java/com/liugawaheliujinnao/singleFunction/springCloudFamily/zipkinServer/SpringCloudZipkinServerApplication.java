package com.liugawaheliujinnao.singleFunction.springCloudFamily.zipkinServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import zipkin.server.internal.EnableZipkinServer;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-29
 */
@SpringBootApplication
//@EnableZipkinServer
@EnableZipkinStreamServer
public class SpringCloudZipkinServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZipkinServerApplication.class, args);
    }
}
