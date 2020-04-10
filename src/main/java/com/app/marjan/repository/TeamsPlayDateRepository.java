package com.app.marjan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.marjan.entity.TeamsPlayDate;;

@Repository
public interface TeamsPlayDateRepository extends JpaRepository<TeamsPlayDate, Long> {}