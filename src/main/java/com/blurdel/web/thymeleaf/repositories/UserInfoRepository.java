package com.blurdel.web.thymeleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blurdel.web.thymeleaf.entities.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

}
