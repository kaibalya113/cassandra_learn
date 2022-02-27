package com.nosql.cassandra.controller;

import com.nosql.cassandra.dao.UserRepository;
import com.nosql.cassandra.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    //@PostConstruct
    public void addUser(){
        List<User> lst = new ArrayList<>();

        lst.add(new User(1001, "Kaibalya", "pune", 27));
        lst.add(new User(1002, "mohanty", "mumbai", 28));
        lst.add(new User(1003, "manas", "bangalor", 27));
        lst.add(new User(1004, "himesh", "canada", 27));

        userRepository.saveAll(lst);
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<List<User>> getByName(@PathVariable String name){
        List<User> userList = userRepository.getUserFilterByName(name);
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/getall/{age}")
    public ResponseEntity<List<User>> getByName(@PathVariable int age){
        List<User> userList = userRepository.findByAgeGreaterThan(age);
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<User>> getall(){
        List<User> all = userRepository.findAll();
        return ResponseEntity.ok(all);
    }
}
