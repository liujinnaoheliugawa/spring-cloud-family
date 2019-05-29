package com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignServiceProvidor.web.controller;

import com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignServiceProvidor.entity.Person;
import com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignServiceProvidor.repository.PersonRepository;
import com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignServiceProvidor.service.PersonService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: {@link PersonService} 提供者控制器，可选实现 {@link PersonService}，也可以不实现
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-29
 */
@RestController
public class PersonServiceProviderController {

    private Map<Long, Person> persons = new ConcurrentHashMap<>();

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    private final static Random random = new Random();

    @PostMapping(value = "/person/save")
    public boolean savePerson(@RequestBody com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignApi.domain.Person  person) {
        Person person1 = new Person();
        BeanUtils.copyProperties(person, person1);
        personService.save(person1);
        personRepository.save(person1);
        return true;
    }

    @GetMapping("/person/list")
    public Page<Person> list(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    @GetMapping(value = "/person/find/all")
    @HystrixCommand(fallbackMethod = "fallbackForFindAllPersons",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                            value = "100")
            }
    )
    public Collection<Person> findAllPersons() throws Exception {
        // 如果随机时间大于 100，那么触发容错
        int value = random.nextInt(200);
        System.out.println("findAllPersons() costs " + value + "ms.");
        Thread.sleep(value);
        List<Person> persons = new ArrayList<>();
        Iterable<Person> personIterable = personRepository.findAll();
        personIterable.forEach(person -> {
            persons.add(person);
        });
        return persons;
    }

    /**
     * {@link #findAllPersons()}Fallback 方法
     * @return 返回空集合
     */
    public Collection<Person> fallbackForFindAllPersons() {
        System.err.println("findAllPersons() is invoked!");
        return Collections.emptyList();
    }
}
