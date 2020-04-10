package com.app.marjan.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * harfRoundGameKyokuList.jsp（半荘一覧）に表示するときの点数情報を保持する
 * @author inokoichi
 *
 */
public class  ParticipantBodyInfoDto {

	/**
	 * 1半荘のユーザー全員の情報を保持しているDto
	 */
	public List<PlayerPlayResultDto> playerPlayResultDto = new ArrayList<PlayerPlayResultDto>();

	/**
	 * 半荘数
	 */
	public Integer hanso = 1;

}
