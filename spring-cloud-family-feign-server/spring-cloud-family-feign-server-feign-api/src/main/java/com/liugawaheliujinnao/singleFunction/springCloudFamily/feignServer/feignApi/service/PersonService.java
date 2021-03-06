package com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignApi.service;

import com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignApi.domain.Person;
import com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignApi.hystrix.PersonServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

/**
 * @Description: {@link Person} 服务
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-29
 */
@FeignClient(value = "person-service", fallback = PersonServiceFallback.class) // 服务提供方应用的名称
public interface PersonService {

    /**
     * 保存
     * @param person {@link Person}
     * @return 如果成功，<code>true<code/>
     */
    @PostMapping(value = "/person/save")
    boolean save(@RequestBody Person person);

    /**
     * 查找所有的服务
     * @return
     */
    @GetMapping(value = "/person/find/all")
    Collection<Person> findAll();
}
