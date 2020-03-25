package com.mukul.profile.repository;

import com.mukul.profile.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<UserEntity, String> {
	UserEntity findByEmailAddress(String emailAddress);
}