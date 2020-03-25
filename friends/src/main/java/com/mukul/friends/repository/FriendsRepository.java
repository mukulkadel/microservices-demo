package com.mukul.friends.repository;
import java.util.List;

import com.mukul.friends.entity.FriendsEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendsRepository extends JpaRepository<FriendsEntity, String> {

	FriendsEntity findByUser1AndUser2(String user1, String user2);
	List<FriendsEntity> findByUser1(String user1);
}