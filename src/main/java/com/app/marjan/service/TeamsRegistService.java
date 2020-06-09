package com.app.marjan.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.marjan.entity.Teams;
import com.app.marjan.repository.TeamsRepository;;

@Service
@Transactional
public class TeamsRegistService {

	@Autowired
	private TeamsRepository groupListRepository;

    @PersistenceContext
    private EntityManager em;

    /**
	 * 全user情報を取得する
	 * @param userId
	 * @return List<User>
	 **/
	public List<Teams> findAll() {
		return groupListRepository.findAll();
	}

	/**
	 * user情報を更新する
	 * @param userId
	 * @return User
	 */
	public Teams updata(Teams user) {
		return groupListRepository.save(user);
	}

	/**
	 * user情報を削除する
	 * @param userId
	 */
	public void delete(Long id) {
		groupListRepository.deleteById(id);
	}

	/**
	 * グループ日付情報を取得する
	 * @param userId
	 * @return
	 */
	public Teams findByGroupId(String groupId) {
		// Criteria APIを利用するためにインスタンを生成
		CriteriaBuilder cb = em.getCriteriaBuilder();

		// GroupIDをキーにDBから情報を取得するためのクエリ生成
		CriteriaQuery<Teams> query = cb.createQuery(Teams.class);
		Root<Teams> root = query.from(Teams.class);
		query.where(cb.equal(root.get("groupId"), groupId));

		// クエリの実行
		Teams result = em
				.createQuery(query)
				.getResultList().get(0);
		return result;
	}
}