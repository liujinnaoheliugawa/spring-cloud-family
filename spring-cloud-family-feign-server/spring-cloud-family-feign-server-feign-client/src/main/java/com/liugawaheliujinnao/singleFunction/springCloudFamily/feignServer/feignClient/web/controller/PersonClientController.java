package com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignClient.web.controller;

import com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignApi.domain.Person;
import com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignApi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

/**
 * @Description: @link PersonClientController} 实现 {@link PersonService}
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-29
 */
public class PersonClientController implements PersonService {

    private final PersonService personService;

    @Autowired
    public PersonClientController(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public boolean save(@RequestBody Person person) {
        return personService.save(person);
    }

    @Override
    public Collection<Person> findAll() {
        return personService.findAll();
    }
}
