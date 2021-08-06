package com.challengeDisney.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challengeDisney.Models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{

	UserModel findByUserName(String username);
}
