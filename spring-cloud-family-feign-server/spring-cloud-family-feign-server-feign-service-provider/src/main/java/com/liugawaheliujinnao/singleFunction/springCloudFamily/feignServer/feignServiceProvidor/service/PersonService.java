package com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignServiceProvidor.service;

import com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignServiceProvidor.entity.Person;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @Description: {@link Person} 服务
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-29
 */
@Service
public class PersonService {

    /**
     * 通过标准的 JPA 的方式注入
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 存储 {@link Person}
     * @param person
     */
    public void save(Person person) {
        entityManager.persist(person);
    }
}
