package com.mukul.friends.mapper;

import com.mukul.friends.dto.Friends;
import com.mukul.friends.entity.FriendsEntity;
import org.springframework.stereotype.Component;

@Component
public class FriendsMapper{
    public Friends toFriends(FriendsEntity friendsEntity){
        if(friendsEntity==null){
            return null;
        }
        Friends friends = new Friends();
        friends.setUser1(friendsEntity.getUser1());
        friends.setUser2(friendsEntity.getUser2());
        return friends;
    }
    public FriendsEntity toFriendsEntity(Friends friends){
        if(friends==null){
            return null;
        }
        FriendsEntity friendsEntity = new FriendsEntity();
        friendsEntity.setUser1(friends.getUser1());
        friendsEntity.setUser2(friends.getUser2());
        return friendsEntity;
    }
}