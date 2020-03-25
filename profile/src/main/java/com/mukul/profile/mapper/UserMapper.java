package com.mukul.profile.mapper;

import com.mukul.profile.dto.User;
import com.mukul.profile.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper{
    public User toDto(UserEntity userEntity){
        if(userEntity == null){
            return null;
        }
        User user = new User();
        user.setId(userEntity.getId());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setEmailAddress(userEntity.getEmailAddress());
        user.setPassword(userEntity.getPassword());
        return user;
    }

    public UserEntity toEntity(User user){
        if(user == null){
            return null;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmailAddress(user.getEmailAddress());
        userEntity.setPassword(user.getPassword());
        return userEntity;
    }
}