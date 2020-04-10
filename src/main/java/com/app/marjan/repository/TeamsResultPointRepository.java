package com.app.marjan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.marjan.entity.PlayerResultPoint;;

@Repository
public interface TeamsResultPointRepository extends JpaRepository<PlayerResultPoint, Long> {}