package com.app.marjan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.marjan.entity.Teams;;

@Repository
public interface TeamsRepository extends JpaRepository<Teams, Long> {}