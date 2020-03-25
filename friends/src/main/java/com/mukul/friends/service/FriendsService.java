package com.mukul.friends.service;

import java.util.List;

import com.mukul.friends.dto.Friends;
import com.mukul.friends.dto.User;
import com.mukul.friends.exception.FriendsException;

public interface FriendsService{

	void create(Friends friends) throws FriendsException;
	void delete(Friends friends) throws FriendsException;
	List<User> getFriends(String id) throws FriendsException;
}