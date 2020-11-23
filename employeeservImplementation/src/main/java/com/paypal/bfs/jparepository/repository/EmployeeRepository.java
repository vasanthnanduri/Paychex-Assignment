package com.paypal.bfs.jparepository.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.paypal.bfs.entity.EmployeeEntity;

/**
 * 
 * @author vasanthnanduri
 * Class Name: EmployeeRepository
 * Description: This Class extends CrudRepository which is provided by the spring framework to perform simplified CRUD operations on DB.
 *
 */

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer>{

}
