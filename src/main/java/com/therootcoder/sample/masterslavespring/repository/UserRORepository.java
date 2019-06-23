package com.therootcoder.sample.masterslavespring.repository;

import com.therootcoder.sample.masterslavespring.annotation.ReadOnly;
import com.therootcoder.sample.masterslavespring.entity.User;

/**
 * @author Harpreet Sandhu
 * @since 24-Mar-2019
 **/
@ReadOnly
public interface UserRORepository extends ReadOnlyRepository<User, Integer> {

}