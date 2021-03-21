package com.app.marjan.service;

import java.util.ArrayList;
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
//		return userListRepository.findAll();
		// test data
		return getTestDataMembersInfo();
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

	/**
	 * dummy Data
	 *  参加者達の情報を取得
	 */
	private List<User> getTestDataMembersInfo() {
		List<User> userlist = new ArrayList<User>();

		userlist.add(createTestMemberInfo("001","猪野","narimasu"));
		userlist.add(createTestMemberInfo("002","望","narimasu"));
		userlist.add(createTestMemberInfo("003","間宮","narimasu"));
		userlist.add(createTestMemberInfo("004","波","narimasu"));
		userlist.add(createTestMemberInfo("005","工藤","narimasu"));

		return userlist;
	}

	/**
	 * dummy data
	 * 参加者の情報を取得
	 */
	private User createTestMemberInfo(String userId, String userName, String groupId1) {
		User user = new User();
		user.userId = userId;
		user.userName = userName;
		user.groupId1 = groupId1;

		return user;
	}

}