package com.blurdel.web.thymeleaf.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.blurdel.web.thymeleaf.entities.UserInfo;
import com.blurdel.web.thymeleaf.repositories.UserInfoRepository;


@Service
public class UserService {

	private final UserInfoRepository userInfoRepository;

	public UserService(UserInfoRepository userInfoRepository) {
		this.userInfoRepository = userInfoRepository;
	}

	public List<UserInfo> getUsers() {
		return userInfoRepository.findAll();
	}

	public UserInfo saveUser(UserInfo userInfo) {
		return userInfoRepository.save(userInfo);
	}

	public void saveAll(List<UserInfo> userInfoList) {
		userInfoRepository.saveAll(userInfoList);
	}

	public void delete(Integer id) {
		userInfoRepository.deleteById(id);
	}

}
