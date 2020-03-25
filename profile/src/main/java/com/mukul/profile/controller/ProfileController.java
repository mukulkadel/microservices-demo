package com.mukul.profile.controller;

import com.mukul.profile.dto.User;
import com.mukul.profile.exception.ProfileException;
import com.mukul.profile.service.ProfileService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/profiles")
public class ProfileController{

    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ProfileService profileService;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody User user) throws ProfileException{
        user.setPassword(String.valueOf(user.getPassword().hashCode()));
        profileService.register(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value="/{key}")
    public ResponseEntity<User> getUser( @PathVariable String key,
        @RequestParam String keyType) throws ProfileException{
        log.info("Request for {}",key);
        User user = profileService.getUser(key, keyType);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    
}