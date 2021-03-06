package com.app.marjan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.marjan.entity.PlayUser;
import com.app.marjan.repository.PlayUserRepository;

@Service
@Transactional
public class PlayUserService {

	@Autowired
	private PlayUserRepository playUserRepository;

    @PersistenceContext
    private EntityManager em;

	/**
	 * 全user情報を取得する
	 * @param userId
	 * @return List<GroupPlayDate>
	 **/
	public List<PlayUser> findAll() {
		return playUserRepository.findAll();
	}

	/**
	 * user情報を更新する
	 * @param userId
	 * @return User
	 */
	public PlayUser updata(PlayUser playUser) {
		return playUserRepository.save(playUser);
	}

	/**
	 * user情報を削除する
	 * @param userId
	 */
	public void delete(Long id) {
		playUserRepository.deleteById(id);
	}

	/**
	 * user情報を取得する
	 * @param userId
	 * @return
	 */
	public Optional<PlayUser> findById(Long groupId) {
		return playUserRepository.findById(groupId);
	}

	/**
	 *
	 * @param groupId
	 * @param playDate
	 * @return
	 */
	public List<PlayUser> findByGroupId(String groupId) {
		// Criteria APIを利用するためにインスタンを生成
		CriteriaBuilder cb = em.getCriteriaBuilder();

		// GroupIDをキーにDBから情報を取得するためのクエリ生成
		CriteriaQuery<PlayUser> query = cb.createQuery(PlayUser.class);
		Root<PlayUser> root = query.from(PlayUser.class);
		Predicate authorNamePredicate = cb.equal(root.get("groupId"), groupId);
		query.where(authorNamePredicate);
//		query.where(cb.equal(root.get("groupId"), groupId));

		System.out.println("TODO : query = " + query);
		// クエリの実行
		TypedQuery<PlayUser> resultList = em.createQuery(query);
		return resultList.getResultList();
	}

	/**
	 *
	 * @param groupId
	 * @param playDate
	 * @return
	 */
	public List<PlayUser> findByPlayDate(String playDate) {
		// テストデータ
		return getPlayUserList(playDate);
	}

	/**
	 * プレイ日付とグループIDを元に取得
	 * @param groupId
	 * @param playDate
	 * @return
	 */
	public PlayUser findByGroupIdAndPlayDate(String groupId, String playDate) {
		// Criteria APIを利用するためにインスタンを生成
		CriteriaBuilder cb = em.getCriteriaBuilder();

		// GroupIDをキーにDBから情報を取得するためのクエリ生成
		CriteriaQuery<PlayUser> query = cb.createQuery(PlayUser.class);
		Root<PlayUser> root = query.from(PlayUser.class);
		query.where(cb.equal(root.get("playDate"), playDate));

		// クエリの実行
		PlayUser result = em
				.createQuery(query)
				.getSingleResult();
		return result;
	}

	/**
	 * testData
	 */
	private List<PlayUser> getPlayUserList (String playDate) {
    	List<PlayUser> playerUserList = new ArrayList<PlayUser>();
			playerUserList.add(createTestPlayUser("001","猪野",playDate));
			playerUserList.add(createTestPlayUser("002","望",playDate));
			playerUserList.add(createTestPlayUser("003","波",playDate));
			playerUserList.add(createTestPlayUser("004","工藤",playDate));
			playerUserList.add(createTestPlayUser("005","間宮",playDate));
    	return playerUserList;
	}

	/**
	 * dummy data
	 * 参加者の情報を取得
	 * @param userId
	 * @param userName
	 * @param playDate
	 * @param hanso
	 * @param point
	 * @param money
	 * @param rank
	 * @return
	 */
	private PlayUser createTestPlayUser(
			String userId
			, String userName
			, String playDate) {
		PlayUser playerUserDto = new PlayUser();
		playerUserDto.userId = userId;
		playerUserDto.userName = userName;
		playerUserDto.playDate = playDate;

		return playerUserDto;
	}
}