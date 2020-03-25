package com.mukul.profile.service;

import com.mukul.profile.dto.User;
import com.mukul.profile.exception.ProfileException;

public interface ProfileService{
    void register(User user) throws ProfileException;
    User getUser(String key, String keyType) throws ProfileException;
}