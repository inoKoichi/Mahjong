package com.app.marjan.service;

import java.util.Date;
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

import com.app.marjan.common.CommonUtility;
import com.app.marjan.constant.CommonConstant;
import com.app.marjan.dto.PlayRuleSettingDto;
import com.app.marjan.entity.TeamsPlayDate;
import com.app.marjan.repository.TeamsPlayDateRepository;

@Service
@Transactional
public class TeamsPlayDateService {

	@Autowired
	private TeamsPlayDateRepository groupPlayDateRepository;

    @PersistenceContext
    private EntityManager em;

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
	 * user情報を更新する
	 * @param userId
	 * @return User
	 */
	public TeamsPlayDate save(PlayRuleSettingDto playRuleSettingDto) {
		TeamsPlayDate TeamsPlayDate = this.setTeamsPlayDate(playRuleSettingDto);
		return groupPlayDateRepository.save(TeamsPlayDate);
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
	public Optional<TeamsPlayDate> findById(Long groupId) {
		return groupPlayDateRepository.findById(groupId);
	}

	/**
	 *
	 * @param groupId
	 * @param playDate
	 * @return
	 */
	public List<TeamsPlayDate> findByGroupId(String groupId) {
		// Criteria APIを利用するためにインスタンを生成
		CriteriaBuilder cb = em.getCriteriaBuilder();

		// GroupIDをキーにDBから情報を取得するためのクエリ生成
		CriteriaQuery<TeamsPlayDate> query = cb.createQuery(TeamsPlayDate.class);
		Root<TeamsPlayDate> root = query.from(TeamsPlayDate.class);
		Predicate authorNamePredicate = cb.equal(root.get("groupId"), groupId);
		query.where(authorNamePredicate);
//		query.where(cb.equal(root.get("groupId"), groupId));

		System.out.println("TODO : query = " + query);
		// クエリの実行
		TypedQuery<TeamsPlayDate> resultList = em.createQuery(query);
		return resultList.getResultList();
	}

	/**
	 * プレイ日付とグループIDを元に取得
	 * @param groupId
	 * @param playDate
	 * @return
	 */
	public TeamsPlayDate findByGroupIdAndPlayDate(String groupId, String playDate) {
		// Criteria APIを利用するためにインスタンを生成
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//
//		System.out.println("TODO : select : playDate = " + playDate);
//		// GroupIDをキーにDBから情報を取得するためのクエリ生成
//		CriteriaQuery<TeamsPlayDate> query = cb.createQuery(TeamsPlayDate.class);
//		Root<TeamsPlayDate> root = query.from(TeamsPlayDate.class);
//		query.where(cb.equal(root.get("playDate"), playDate));
//
//		// クエリの実行
//		TeamsPlayDate result = em
//				.createQuery(query)
//				.getSingleResult();
//		return result;
		// test Data
		return getTestDataTeamsPlayDateInfo(groupId, playDate);
	}

	/**
	 * TeamsPlayDateのEntityに設定
	 * @param playRuleSettingDto
	 * @return teamsPlayDate
	 */
	private TeamsPlayDate setTeamsPlayDate(PlayRuleSettingDto playRuleSettingDto) {
		TeamsPlayDate teamsPlayDate = new TeamsPlayDate();
		teamsPlayDate.groupId = playRuleSettingDto.groupId;
		teamsPlayDate.playDate = playRuleSettingDto.playDate;
		teamsPlayDate.playGroupNo = playRuleSettingDto.playGroupNo;
		teamsPlayDate.settingNo = playRuleSettingDto.settingNo;
		teamsPlayDate.registrationDate = CommonUtility.convertStringToDate(CommonUtility.getCurrentDate());
		teamsPlayDate.updateDate = CommonUtility.convertStringToDate(CommonUtility.getCurrentDate());
		teamsPlayDate.deleteDate = null;
		teamsPlayDate.deleteFlag = CommonConstant.ZERO;

		return teamsPlayDate;
	}

	/**
	 * dummy Data
	 *  チーム実施日の情報を取得
	 */
	private TeamsPlayDate getTestDataTeamsPlayDateInfo(String groupId, String playDate) {
		if (groupId.equals("001") && playDate.equals("2020/12/01")) {
			return createTestTeamPlayDateInfo("001","2020/12/01");
		} else if (groupId.equals("001") && playDate.equals("2020/12/02")) {
			return createTestTeamPlayDateInfo("001","2020/12/02");
		} else if (groupId.equals("001") && playDate.equals("2020/12/03")) {
			return createTestTeamPlayDateInfo("001","2020/12/03");
		} else if (groupId.equals("001") && playDate.equals("2020/12/04")) {
			return createTestTeamPlayDateInfo("001","2020/12/04");
		} else if (groupId.equals("001") && playDate.equals("2020/12/21")) {
			return createTestTeamPlayDateInfo("001","2020/12/21");
		} else if (groupId.equals("001") && playDate.equals("2020/12/31")) {
			return createTestTeamPlayDateInfo("001","2020/12/31");
		} else if (groupId.equals("001") && playDate.equals("2021/12/04")) {
			return createTestTeamPlayDateInfo("001","2021/01/04");
		} else if (groupId.equals("002") && playDate.equals("2020/12/01")) {
			return createTestTeamPlayDateInfo("002","2020/12/01");
		} else if (groupId.equals("002") && playDate.equals("2020/12/02")) {
			return createTestTeamPlayDateInfo("002","2020/12/02");
		} else if (groupId.equals("002") && playDate.equals("2020/12/03")) {
			return createTestTeamPlayDateInfo("002","2020/12/03");
		} else if (groupId.equals("002") && playDate.equals("2020/12/04")) {
			return createTestTeamPlayDateInfo("002","2020/12/04");
		} else if (groupId.equals("002") && playDate.equals("2020/12/21")) {
			return createTestTeamPlayDateInfo("002","2020/12/21");
		} else if (groupId.equals("002") && playDate.equals("2020/12/31")) {
			return createTestTeamPlayDateInfo("002","2020/12/31");
		} else if (groupId.equals("002") && playDate.equals("2021/01/04")) {
			return createTestTeamPlayDateInfo("002","2021/01/04");
		} else if (groupId.equals("003") && playDate.equals("2020/12/01")) {
			return createTestTeamPlayDateInfo("003","2020/12/01");
		} else if (groupId.equals("003") && playDate.equals("2020/12/02")) {
			return createTestTeamPlayDateInfo("003","2020/12/02");
		} else if (groupId.equals("003") && playDate.equals("2020/12/03")) {
			return createTestTeamPlayDateInfo("003","2020/12/03");
		} else if (groupId.equals("003") && playDate.equals("2020/12/04")) {
			return createTestTeamPlayDateInfo("003","2020/12/04");
		} else if (groupId.equals("003") && playDate.equals("2020/12/21")) {
			return createTestTeamPlayDateInfo("003","2020/12/21");
		} else if (groupId.equals("003") && playDate.equals("2020/12/31")) {
			return createTestTeamPlayDateInfo("003","2020/12/31");
		} else if (groupId.equals("003") && playDate.equals("2021/01/04")) {
			return createTestTeamPlayDateInfo("003","2021/01/04");
		} else {
			return null;
		}
	}

	/**
	 * dummy data
	 * チームの実施日を取得
	 */
	private TeamsPlayDate createTestTeamPlayDateInfo(String groupId, String playDate) {
		TeamsPlayDate teamsPlayDate = new TeamsPlayDate();
		teamsPlayDate.groupId = groupId;
		teamsPlayDate. playDate = playDate;
		teamsPlayDate.registrationDate = new Date();

		return teamsPlayDate;
	}

}