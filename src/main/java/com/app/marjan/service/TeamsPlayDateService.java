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

import com.app.marjan.entity.TeamsPlayDate;
import com.app.marjan.repository.TeamsPlayDateRepository;

@Service
@Transactional
public class TeamsPlayDateService {

	@Autowired
	private TeamsPlayDateRepository groupPlayDateRepository;

    @PersistenceContext
    private EntityManager entityManager;

	/**
	 * 全user情報を取得する
	 * @param userId
	 * @return List<GroupPlayDate>
	 **/
	public List<TeamsPlayDate> findAll() {
		return groupPlayDateRepository.findAll();
	}

	/**
	 * user情報を更新する
	 * @param userId
	 * @return User
	 */
	public TeamsPlayDate updata(TeamsPlayDate user) {
		return groupPlayDateRepository.save(user);
	}

	/**
	 * user情報を削除する
	 * @param userId
	 */
	public void delete(Long id) {
		groupPlayDateRepository.deleteById(id);
	}

	/**
	 * user情報を取得する
	 * @param userId
	 * @return
	 */
	public Optional<TeamsPlayDate> findById(Long userId) {
		return groupPlayDateRepository.findById(userId);
	}

	/**
	 *
	 * @param groupId
	 * @param playDate
	 * @return
	 */
	public TeamsPlayDate findByGroupIdAndPlayDate(String groupId, String playDate) {
		// Criteria APIを利用するためにインスタンを生成
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		// GroupIDをキーにDBから情報を取得するためのクエリ生成
		CriteriaQuery<TeamsPlayDate> query = cb.createQuery(TeamsPlayDate.class);
		Root<TeamsPlayDate> root = query.from(TeamsPlayDate.class);
//		query.where(cb.equal(root.get("playDate"), cb.currentDate()), cb.equal(root.get("groupId"), groupId));
		query.where(cb.equal(root.get("groupId"), groupId));

		// クエリの実行
		TeamsPlayDate result = entityManager
				.createQuery(query)
				.getResultList().get(0);
		return result;
	}
}