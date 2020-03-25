package com.mukul.friends.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.mukul.friends.client.ProfileClient;
import com.mukul.friends.dto.Friends;
import com.mukul.friends.dto.User;
import com.mukul.friends.entity.FriendsEntity;
import com.mukul.friends.exception.FriendsException;
import com.mukul.friends.mapper.FriendsMapper;
import com.mukul.friends.repository.FriendsRepository;
import com.mukul.friends.service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FriendsServiceImpl implements FriendsService {

    @Autowired
    private FriendsRepository friendsRepository;
    @Autowired
    private FriendsMapper friendsMapper;
    @Autowired
    private ProfileClient profileClient;

    @Override
    public void create(Friends friends) throws FriendsException {
        FriendsEntity entity1, entity2;
        entity1 = friendsMapper.toFriendsEntity(friends);
        entity1.setId(UUID.randomUUID().toString().replace("-", ""));
        entity2 = new FriendsEntity();
        entity2.setId(UUID.randomUUID().toString().replace("-", ""));
        entity2.setUser1(entity1.getUser2());
        entity2.setUser2(entity1.getUser1());
        friendsRepository.save(entity1);
        friendsRepository.save(entity2);
    }

    @Override
    public void delete(Friends friends) throws FriendsException {
        FriendsEntity entity = 
                friendsRepository.findByUser1AndUser2(friends.getUser1(),friends.getUser2());
        friendsRepository.delete(entity);
        entity = friendsRepository.findByUser1AndUser2(friends.getUser2(),friends.getUser1());
        friendsRepository.delete(entity);
    }

    @Override
    public List<User> getFriends(String id) throws FriendsException {
        List<FriendsEntity> entities = friendsRepository.findByUser1(id);
        List<User> users = entities.stream()
                                    .map(FriendsEntity::getUser2)
                                    .map(profileClient::getUser).collect(Collectors.toList());
        return users;
    }
    
}