package com.therootcoder.sample.masterslavespring.repository;

import com.therootcoder.sample.masterslavespring.annotation.ReadOnly;
import com.therootcoder.sample.masterslavespring.entity.User;
import org.springframework.data.repository.CrudRepository;


/**
 * @author Harpreet Sandhu
 * @since 25-Mar-2019
 **/
@ReadOnly
public interface ReadOnlyTestRepository extends CrudRepository<User, Integer> {

}