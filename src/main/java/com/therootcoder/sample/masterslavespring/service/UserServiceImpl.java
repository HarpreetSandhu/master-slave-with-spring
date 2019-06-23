package com.therootcoder.sample.masterslavespring.service;

import com.therootcoder.sample.masterslavespring.entity.User;
import com.therootcoder.sample.masterslavespring.repository.ReadOnlyTestRepository;
import com.therootcoder.sample.masterslavespring.repository.UserRORepository;
import com.therootcoder.sample.masterslavespring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Harpreet Sandhu
 * @since 24-Mar-2019
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRORepository userRORepository;

    @Autowired
    private ReadOnlyTestRepository readOnlyTestRepository;

    @Override
    public List<User> findAllUsers(boolean useRO) {
        return useRO ? userRORepository.findAll() : userRepository.findAll();
    }

    @Override
    public User add(String name, String email) {
        User user = new User();
        user.setEmail(email).setName(name);
        return userRepository.save(user);
    }

    @Override
    public User addByReadOnlyRepo(String name, String email) {
        User user = new User();
        user.setEmail(email).setName(name);
        return readOnlyTestRepository.save(user);
    }
}