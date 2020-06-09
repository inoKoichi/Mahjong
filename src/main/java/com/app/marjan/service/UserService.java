package com.app.marjan.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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

    @PersistenceContext
    private EntityManager em;

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

	/**
	 * user情報を取得する
	 * @param userId
	 * @return
	 */
	public User findByUserId(String userId) {
		// Criteria APIを利用するためにインスタンを生成
		CriteriaBuilder cb = em.getCriteriaBuilder();

		// GroupIDをキーにDBから情報を取得するためのクエリ生成
		CriteriaQuery<User> query = cb.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.where(cb.equal(root.get("userId"), userId));

		// クエリの実行
		User result = em
				.createQuery(query)
				.getResultList().get(0);
		return result;
	}
}