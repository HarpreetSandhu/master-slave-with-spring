package com.therootcoder.sample.masterslavespring.service;

import com.therootcoder.sample.masterslavespring.entity.User;

import java.util.List;

/**
 * @author Harpreet Sandhu
 * @since 24-Mar-2019
 **/
public interface UserService {

    List<User> findAllUsers(boolean useRO);

    User add(String name, String email);

    User addByReadOnlyRepo(String name, String email);
}