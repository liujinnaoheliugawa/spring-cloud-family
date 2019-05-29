package com.liugawaheliujinnao.singleFunction.springCloudFamily.sleuthServer.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-29
 */
@RestController
public class DemoController {

    protected final static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public DemoController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("")
    private String index() {
        String returnValue = "Hello, World";
        logger.info("{} index(): {}", getClass().getSimpleName(), returnValue);
        return returnValue;
    }

    /**
     * 完整的调用链路
     *
     * spring-cloud-sleuth
     * -> zuul
     *      -> person-client
     *            -> person-service
     * @return
     */
    @GetMapping("/to/zuul/person-client/person/find/all")
    public Object toZuul() {
        //spring-cloud-zuul : 7070
        logger.info("spring-cloud-sleuth#toZuul()");
        String url = "http://spring-cloud-zuul/person-client/person/find/all";
        return restTemplate.getForObject(url, Object.class);
    }
}
