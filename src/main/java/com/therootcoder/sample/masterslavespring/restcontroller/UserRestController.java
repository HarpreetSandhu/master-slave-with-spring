package com.therootcoder.sample.masterslavespring.restcontroller;

import com.therootcoder.sample.masterslavespring.entity.User;
import com.therootcoder.sample.masterslavespring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Harpreet Sandhu
 * @since 24-Mar-2019
 **/
@RestController
@RequestMapping(value = "/user/")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "all")
    public ResponseEntity<List<User>> all(@RequestParam boolean useRO) {
        List<User> userList = userService.findAllUsers(useRO);
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping(value = "add")
    public ResponseEntity<User> add(@RequestParam String name, @RequestParam String email) {
        return new ResponseEntity<>(userService.add(name, email), HttpStatus.OK);
    }

    @PostMapping(value = "readonly/add")
    public ResponseEntity<User> readOnlyAdd(@RequestParam String name, @RequestParam String email) {
        return new ResponseEntity<>(userService.addByReadOnlyRepo(name, email), HttpStatus.OK);
    }
}