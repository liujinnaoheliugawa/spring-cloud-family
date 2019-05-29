package com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignServiceProvidor.entity;

import javax.persistence.*;

/**
 * @Description: Person 实体
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-29
 */
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column(columnDefinition = "VARCHAR(128) NOT NULL")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
