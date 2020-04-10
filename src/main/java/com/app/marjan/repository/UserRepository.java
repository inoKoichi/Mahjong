package com.app.marjan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.marjan.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}