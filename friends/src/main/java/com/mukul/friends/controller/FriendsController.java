package com.mukul.friends.controller;

import java.util.List;
import com.mukul.friends.dto.Friends;
import com.mukul.friends.dto.User;
import com.mukul.friends.exception.FriendsException;
import com.mukul.friends.service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/friends")
public class FriendsController{

    @Autowired
    private FriendsService friendsService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Friends friends) throws FriendsException{
        friendsService.create(friends);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody Friends friends) throws FriendsException{
        friendsService.delete(friends);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value="/{id}")
    public List<User> getFriends(@PathVariable String id) throws FriendsException {
        return friendsService.getFriends(id);
    }
    
    
}