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
	 *
	 * @param player
	 * @return
	 */
    public PlayerResultPoint save(PlayerResultPoint playerResultPoint) {
        return pointListRepository.save(playerResultPoint);
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
//		// Criteria APIを利用するためにインスタンを生成
//		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//
//		// GroupIDをキーにDBから情報を取得するためのクエリ生成
//		CriteriaQuery<PlayerResultPoint> query = cb.createQuery(PlayerResultPoint.class);
//		Root<PlayerResultPoint> root = query.from(PlayerResultPoint.class);
//		query.where(cb.equal(root.get("groupId"), groupId), cb.equal(root.get("playDate"), playDate));
//
//		// クエリの実行
//		List<PlayerResultPoint> results = entityManager
//				.createQuery(query)
//				.getResultList();
//		return results;
		return getTestDataParticipantHeaderInfoDtoInfo(playDate);
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

	/**
	 * dummy Data
	 *  参加者達の情報を取得
	 */
	private List<PlayerResultPoint> getTestDataParticipantHeaderInfoDtoInfo(String playDate) {
		List<PlayerResultPoint> playerResultPointList = new ArrayList<PlayerResultPoint>();
		playerResultPointList.add(createTestParticipantHeaderInfoDtoInfo("001","猪野",playDate,1,"東",40000,50,5000,1));
		playerResultPointList.add(createTestParticipantHeaderInfoDtoInfo("002","望",playDate,1,"南",30000,15,1500,2));
		playerResultPointList.add(createTestParticipantHeaderInfoDtoInfo("003","間宮",playDate,1,"西",20000,-15,-1500,3));
		playerResultPointList.add(createTestParticipantHeaderInfoDtoInfo("004","波",playDate,1,"北",10000,-25,-2500,4));
		playerResultPointList.add(createTestParticipantHeaderInfoDtoInfo("001","猪野",playDate,2,"西",80000,65,3000,1));
		playerResultPointList.add(createTestParticipantHeaderInfoDtoInfo("002","望",playDate,2,"東",10000,-5,2000,2));
		playerResultPointList.add(createTestParticipantHeaderInfoDtoInfo("003","間宮",playDate,2,"南",6000,-34,-2000,3));
		playerResultPointList.add(createTestParticipantHeaderInfoDtoInfo("004","波",playDate,2,"北",4000,-41,-3000,4));
		playerResultPointList.add(createTestParticipantHeaderInfoDtoInfo("001","猪野",playDate,3,"西",5000,-40,3000,3));
		playerResultPointList.add(createTestParticipantHeaderInfoDtoInfo("002","望",playDate,3,"北",30000,15,2000,2));
		playerResultPointList.add(createTestParticipantHeaderInfoDtoInfo("003","間宮",playDate,3,"東",61000,56,-2000,1));
		playerResultPointList.add(createTestParticipantHeaderInfoDtoInfo("004","波",playDate,3,"南",4000,-41,-3000,4));
		playerResultPointList.add(createTestParticipantHeaderInfoDtoInfo("001","猪野",playDate,4,"西",40000,50,3000,1));
		playerResultPointList.add(createTestParticipantHeaderInfoDtoInfo("002","望",playDate,4,"北",30000,20,2000,2));
		playerResultPointList.add(createTestParticipantHeaderInfoDtoInfo("003","間宮",playDate,4,"南",20000,-20,-2000,3));
		playerResultPointList.add(createTestParticipantHeaderInfoDtoInfo("004","波",playDate,4,"東",10000,-50,-3000,4));
		playerResultPointList.add(createTestParticipantHeaderInfoDtoInfo("001","猪野",playDate,5,"東",0,12,3000,4));
		playerResultPointList.add(createTestParticipantHeaderInfoDtoInfo("002","望",playDate,5,"北", 4000,-20,2000,3));
		playerResultPointList.add(createTestParticipantHeaderInfoDtoInfo("003","間宮",playDate,5,"南",6000,-10,-2000,2));
		playerResultPointList.add(createTestParticipantHeaderInfoDtoInfo("004","波",playDate,5,"西",90000,80,-1000,1));
		return playerResultPointList;
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
	private PlayerResultPoint createTestParticipantHeaderInfoDtoInfo(
			String userId
			, String userName
			, String playDate
			, Integer hanso
			, String seatWind
			, Integer point
			, Integer score
			, Integer money
			, Integer rank) {
		PlayerResultPoint playerResultPoint = new PlayerResultPoint();
		playerResultPoint.userId = userId;
		playerResultPoint.userName = userName;
		playerResultPoint.playDate = playDate;
		playerResultPoint.hanso = hanso;
		playerResultPoint.seatWind = seatWind;
		playerResultPoint.point = point;
		playerResultPoint.score = score;
		playerResultPoint.money = money;
		playerResultPoint.rank = rank;

		return playerResultPoint;
	}
}