package com.app.marjan.constant;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author inokoichi
 */
public class HarfRoundConstant {

	/** 定数 */
	static final String East = "東";
	static final String West = "西";
	static final String South = "南";
	static final String North = "北";

	public static Map<Integer, String> windMap = new TreeMap<Integer, String>();

    public static Map<Integer, String> getWindList() {
    	// 風の定数値を設定
    	windMap.put(1,East);
    	windMap.put(2,West);
    	windMap.put(3,South);
    	windMap.put(4,North);

    	return windMap;
    }
}
