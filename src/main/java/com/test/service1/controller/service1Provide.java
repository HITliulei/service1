package com.test.service1.controller;

import com.test.service1.entity.User;
import com.test.service1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Lei
 * @Date 2020/2/9 15:21
 * @Version 1.0
 */

@RestController
@RequestMapping("/userService")
public class service1Provide {

    @Value("${eureka.instance.metadata-map.version}")
    private String version;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getServiceInfo")
    public String getVersion(){
        return this.version;
    }

    @GetMapping("/users/{id}")
    public User findOne(@PathVariable("id")Long id){
        return this.userRepository.getOne(id);
    }


    @PutMapping("/puttests")
    public String puttest(@RequestBody User user){
        System.out.println("      " + user.toString());
        return "success put test";
    }

    @GetMapping("/alluser")
    public List<User> getall(){
        return this.userRepository.findAll();
    }


    @GetMapping("/only")
    public String get(){
        return "no other service use";
    }
}
