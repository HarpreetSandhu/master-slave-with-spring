package com.therootcoder.sample.masterslavespring.repository;

import com.therootcoder.sample.masterslavespring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Harpreet Sandhu
 * @since 24-Mar-2019
 **/
public interface  UserRepository extends JpaRepository<User, Integer> {

}