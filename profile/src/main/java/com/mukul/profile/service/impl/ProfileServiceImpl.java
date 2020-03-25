package com.mukul.profile.service.impl;

import java.util.UUID;
import com.mukul.profile.dto.User;
import com.mukul.profile.entity.UserEntity;
import com.mukul.profile.exception.ProfileException;
import com.mukul.profile.mapper.UserMapper;
import com.mukul.profile.repository.ProfileRepository;
import com.mukul.profile.service.ProfileService;
import com.mukul.profile.utils.ProfileConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private UserMapper userMapper;
   
    @Override
    public void register(User user) throws ProfileException {
        UserEntity userEntity = userMapper.toEntity(user);
        userEntity.setId(UUID.randomUUID().toString().replace("-",""));
        profileRepository.save(userEntity);
    }

    @Override
    public User getUser(String key, String keyType) throws ProfileException {
        UserEntity userEntity = null;
        if(ProfileConstants.EMAIL_ADDRESS.equals(keyType)){
            userEntity = profileRepository.findByEmailAddress(key);
        }else{
            userEntity = profileRepository.findById(key).orElse(null);
        }
        if(userEntity == null){
            throw new ProfileException("User not found.");
        }
        userEntity.setPassword(null);
        return userMapper.toDto(userEntity);
    }
    
}