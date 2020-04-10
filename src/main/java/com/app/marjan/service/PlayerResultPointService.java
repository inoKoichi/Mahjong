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

import com.app.marjan.entity.PlayerResultPoint;
import com.app.marjan.repository.TeamsResultPointRepository;

@Service
@Transactional
public class PlayerResultPointService {

	@Autowired
	private TeamsResultPointRepository pointListRepository;

    @PersistenceContext
    private EntityManager entityManager;

	/**
	 * 全user情報を取得する
	 * @param userId
	 * @return List<User>
	 **/
	public List<PlayerResultPoint> findAll() {
		return pointListRepository.findAll();
	}

	/**
	 * user情報を更新する
	 * @param userId
	 * @return User
	 */
	public PlayerResultPoint updata(PlayerResultPoint user) {
		return pointListRepository.save(user);
	}

	/**
	 * user情報を削除する
	 * @param userId
	 */
	public void delete(Long id) {
		pointListRepository.deleteById(id);
	}

	/**
	 * user情報を取得する
	 * @param userId
	 * @return
	 */
	public Optional<PlayerResultPoint> findById(Long userId) {
		return pointListRepository.findById(userId);
	}

	/**
	 *
	 * @param groupId
	 * @param playDate
	 * @return
	 */
	public List<PlayerResultPoint> findByGroupIdAndPlayDate(String groupId, String playDate) {
		// Criteria APIを利用するためにインスタンを生成
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		// GroupIDをキーにDBから情報を取得するためのクエリ生成
		CriteriaQuery<PlayerResultPoint> query = cb.createQuery(PlayerResultPoint.class);
		Root<PlayerResultPoint> root = query.from(PlayerResultPoint.class);
		query.where(cb.equal(root.get("groupId"), groupId), cb.equal(root.get("playDate"), playDate));

		// クエリの実行
		List<PlayerResultPoint> results = entityManager
				.createQuery(query)
				.getResultList();
		return results;
	}

	/**
	 *
	 * @param groupId
	 * @return
	 */
	public List<PlayerResultPoint> findByGroupIdAndPlayDate(String groupId) {
		// Criteria APIを利用するためにインスタンを生成
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		// GroupIDをキーにDBから情報を取得するためのクエリ生成
		CriteriaQuery<PlayerResultPoint> query = cb.createQuery(PlayerResultPoint.class);
		Root<PlayerResultPoint> root = query.from(PlayerResultPoint.class);
		query.where(cb.equal(root.get("groupId"), groupId));

		// クエリの実行
		List<PlayerResultPoint> results = entityManager
				.createQuery(query)
				.getResultList();
		return results;
	}

}