package com.app.marjan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.marjan.entity.PlayUser;

@Repository
public interface PlayUserRepository extends JpaRepository<PlayUser, Long> {}