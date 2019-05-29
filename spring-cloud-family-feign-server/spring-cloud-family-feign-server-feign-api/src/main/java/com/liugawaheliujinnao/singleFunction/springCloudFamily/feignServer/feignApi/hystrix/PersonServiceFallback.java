package com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignApi.hystrix;

import com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignApi.domain.Person;
import com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignApi.service.PersonService;

import java.util.Collection;
import java.util.Collections;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-29
 */
public class PersonServiceFallback implements PersonService {

    @Override
    public boolean save(Person person) {
        return false;
    }

    @Override
    public Collection<Person> findAll() {
        return Collections.emptyList();
    }
}
