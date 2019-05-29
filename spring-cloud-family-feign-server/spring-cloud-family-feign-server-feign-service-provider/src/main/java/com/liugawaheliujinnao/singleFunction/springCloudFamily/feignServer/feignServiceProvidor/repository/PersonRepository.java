package com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignServiceProvidor.repository;

import com.liugawaheliujinnao.singleFunction.springCloudFamily.feignServer.feignServiceProvidor.entity.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * {@link Person} 仓储
 */
@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
}
