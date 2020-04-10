package com.app.marjan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.marjan.entity.User;
import com.app.marjan.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userListRepository;

	/**
	 * 全user情報を取得する
	 * @param userId
	 * @return List<User>
	 **/
	public List<User> findAll() {
		return userListRepository.findAll();
	}

	/**
	 * user情報を更新する
	 * @param userId
	 * @return User
	 */
	public User updata(User user) {
		return userListRepository.save(user);
	}

	/**
	 * user情報を削除する
	 * @param userId
	 */
	public void delete(Long id) {
		userListRepository.deleteById(id);
	}

	/**
	 * user情報を取得する
	 * @param userId
	 * @return
	 */
	public Optional<User> findById(Long userId) {
		return userListRepository.findById(userId);
	}
}