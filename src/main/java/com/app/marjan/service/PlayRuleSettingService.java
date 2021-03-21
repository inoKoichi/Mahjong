package com.app.marjan.service;

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
import com.app.marjan.entity.PlayRuleSetting;
import com.app.marjan.entity.PlayUser;
import com.app.marjan.repository.PlayRuleSettingRepository;

@Service
@Transactional
public class PlayRuleSettingService {

	@Autowired
	private PlayRuleSettingRepository playRuleSettingRepository;

    @PersistenceContext
    private EntityManager em;

    /** 定数 */
    private static final String HIHUN = "-";

	/**
	 * 全user情報を取得する
	 * @param userId
	 * @return List<GroupPlayDate>
	 **/
	public List<PlayRuleSetting> findAll() {
		return playRuleSettingRepository.findAll();
	}

	/**
	 * user情報を更新する
	 * @param userId
	 * @return User
	 */
	public PlayRuleSetting updata(PlayRuleSetting playUser) {
		return playRuleSettingRepository.save(playUser);
	}

	/**
	 * user情報を更新する
	 * @param userId
	 * @return User
	 */
	public PlayRuleSetting save(PlayRuleSettingDto dto) {
		PlayRuleSetting playRuleSetting = this.setPlayRuleSettingEntity(dto);
		return playRuleSettingRepository.save(playRuleSetting);
	}

	/**
	 * user情報を削除する
	 * @param userId
	 */
	public void delete(Long id) {
		playRuleSettingRepository.deleteById(id);
	}

	/**
	 * user情報を取得する
	 * @param userId
	 * @return
	 */
	public Optional<PlayRuleSetting> findById(Long groupId) {
		return playRuleSettingRepository.findById(groupId);
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
		return null;
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
	 * Formの情報をEntityにsetする
	 * @param playRuleSettingForm
	 * @return
	 */
	private PlayRuleSetting setPlayRuleSettingEntity(PlayRuleSettingDto dto) {
		PlayRuleSetting playRuleSetting = new PlayRuleSetting();
		String unixTime = String.valueOf(CommonUtility.getCurrentDateUnixTimeUTC());
		playRuleSetting.settingNo = unixTime;
		playRuleSetting.groupId = dto.groupId;
		playRuleSetting.playDate = dto.playDate;
		playRuleSetting.playGroupNo = dto.playGroupNo;
		playRuleSetting.rankReward1 = dto.rankReward1;
		playRuleSetting.rankReward2 = dto.rankReward2;
		playRuleSetting.rankReward3 = dto.rankReward3;
		playRuleSetting.rankReward4 = dto.rankReward4;
		playRuleSetting.tobiReward = dto.tobiReward;
		playRuleSetting.rateMoney = dto.rateMoney;
		playRuleSetting.tipMoney = dto.tipMoney;
		playRuleSetting.returnPoint = dto.returnPoint;
		playRuleSetting.yakumanRon = dto.yakumanRon;
		playRuleSetting.yakumanTsumo = dto.yakumanTsumo;
		playRuleSetting.registrationDate = CommonUtility.convertStringToDate(CommonUtility.getCurrentDate());
		playRuleSetting.updateDate = CommonUtility.convertStringToDate(CommonUtility.getCurrentDate());
		playRuleSetting.deleteDate = null;
		playRuleSetting.deleteFlag = CommonConstant.ZERO;
		return playRuleSetting;

	}

}