package com.app.marjan.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MarjognTermEnum implements ValuesIF{
	// 風
	EAST("1", "東"),
	SOUTH("2", "南"),
	WEST("3", "西"),
	NORTH("4", "北");

	// 風の番号
	private final String id;
	// 風の名称
	private final String name;

}
