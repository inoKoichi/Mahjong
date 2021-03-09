package com.app.marjan.constant;

import java.util.ArrayList;
import java.util.List;
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

	// 風情報を格納するMap
	public static Map<Integer, String> windMap = new TreeMap<Integer, String>();

	// 役満のポイント情報を格納するMap
	public static List<Integer> yakumanPointList = new ArrayList<Integer>();

	/**
	 * 風の一覧を取得
	 * @return
	 */
    public static Map<Integer, String> getWindList() {
    	// 風の定数値を設定
    	windMap.put(1,East);
    	windMap.put(2,South);
    	windMap.put(3,West);
    	windMap.put(4,North);

    	return windMap;
    }

	/**
	 * 役満のポイントリスト
	 * @return
	 */
    public static List<Integer> getYakumanPointList() {
    	// 風の定数値を設定
    	for (int i = -24 ; i <= 24 ; i ++) {
    		yakumanPointList.add(i);
    	}

    	return yakumanPointList;
    }
}
