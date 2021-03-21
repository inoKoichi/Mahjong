package com.app.marjan.dto;

import com.app.marjan.entity.PlayRuleSetting;

import lombok.Getter;
import lombok.Setter;

/**
 * 半荘の設定を保持する
 * @author inokoichi
 *
 */
@Getter
@Setter
public class PlayRuleSettingDto extends PlayRuleSetting{

	/** プレイグループ番号 */
	public String playGroupNo;

}
