package com.app.marjan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.marjan.entity.PlayRuleSetting;

@Repository
public interface PlayRuleSettingRepository extends JpaRepository<PlayRuleSetting, Long> {}