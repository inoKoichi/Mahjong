package com.app.marjan.form;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 半荘の結果入力画面のFormクラス
 * @author inokoichi
 *
 */
@Getter
@Setter
@Data
public class harfRoundGameResultForm implements Serializable {

	/** プレーヤー1の名前 */
	public String playerName1;

	/** プレーヤー2の名前 */
	public String playerName2;

	/** プレーヤー3の名前 */
	public String playerName3;

	/** プレーヤー4の名前 */
	public String playerName4;

	/** プレーヤー1の点数 */
	public Integer playerPoint1;

	/** プレーヤー2の点数 */
	public Integer playerPoint2;

	/** プレーヤー3の点数 */
	public Integer playerPoint3;

	/** プレーヤー4の点数 */
	public Integer playerPoint4;

	/** プレーヤー1の飛び */
	public Integer playerTobiFromName1;

	/** プレーヤー2の飛び */
	public Integer playerTobiFromName2;

	/** プレーヤー3の飛び */
	public Integer playerTobiFromName3;

	/** プレーヤー4の飛び */
	public Integer playerTobiFromName4;

	/** プレーヤー1の飛びフラグ */
	public Integer playerTobiFlag1;

	/** プレーヤー2の飛びフラグ */
	public Integer playerTobiFlag2;

	/** プレーヤー3の飛びフラグ */
	public Integer playerTobiFlag3;

	/** プレーヤー4の飛びフラグ */
	public Integer playerTobiFlag4;

	/** プレーヤー1の風 */
	public String playerWind1;

	/** プレーヤー2の風 */
	public String playerWind2;

	/** プレーヤー3の風 */
	public String playerWind3;

	/** プレーヤー4の風 */
	public String playerWind4;

	/** プレーヤー1の役満の上がり数 */
	public Integer yakumanCount1;

	/** プレーヤー2の役満の上がり数 */
	public Integer yakumanCount2;

	/** プレーヤー3の役満の上がり数 */
	public Integer yakumanCount3;

	/** プレーヤー4の役満の上がり数 */
	public Integer yakumanCount4;

	/** プレーヤー1のメモ */
	public String playerMemo1;

	/** プレーヤー2のメモ */
	public String playerMemo2;

	/** プレーヤー3のメモ */
	public String playerMemo3;

	/** プレーヤー4のメモ */
	public String playerMemo4;

}