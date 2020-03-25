package com.mukul.friends.client;

import com.mukul.friends.dto.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProfileClient{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;
    @Value("${profile.url}")
    private String profileUrl;

    public User getUser(String id){
        String url = String.format("%s%s?keyType=id",profileUrl,id);
        logger.info("Fetching url: {}",url);
        return restTemplate.getForObject(url, User.class);
    }
}