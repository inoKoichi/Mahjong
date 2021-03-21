package com.app.marjan.dto;

import java.util.ArrayList;
import java.util.List;

import com.app.marjan.entity.PlayUser;

import lombok.Getter;
import lombok.Setter;

/**
 * プレイユーザー情報を保持する
 * @author inokoichi
 *
 */
@Getter
@Setter
public class PlayUserDto extends PlayUser {

	/** Player情報のList */
	List<PlayUser> playUserList = new ArrayList<PlayUser>();

}
