package com.app.marjan.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author inokoichi
 */
public class CommonUtility {

	/** 定数値 */
	static final String YYYYMMDD = "yyyy/MM/dd";
	static final String YYYYMMDD_HHMMSS = "yyyy/MM/dd HH:mm:ss";

	/**
	 * 現在日付を取得
	 * @return
	 */
    public static String getCurrentDate() {
    	// 現在日時を取得
        LocalDateTime current = LocalDateTime.now();
        // yyyy/mm/ddのフォーマットに変換
        String playDate = current.format(DateTimeFormatter.ofPattern(YYYYMMDD));
        return playDate;
    }

	/**
	 * 現在日時を取得
	 * @return
	 */
    public static String getCurrentDateTime() {
    	// 現在日時を取得
        LocalDateTime current = LocalDateTime.now();
        // yyyy/mm/dd HH:mm:ssのフォーマットに変換
        String playDate = current.format(DateTimeFormatter.ofPattern(YYYYMMDD_HHMMSS));
        return playDate;
    }

	/**
	 * 現在日付のUNIXTime(UTC)を取得
	 * @return
	 */
    public static Long getCurrentDateUnixTimeUTC() {
    	// 現在日時を取得
    	LocalDate ld = LocalDate.now();
        // yyyy/mm/ddのフォーマットに変換
    	ZonedDateTime zdt = ld.atStartOfDay(ZoneOffset.UTC);
    	long epochSecond = zdt.toEpochSecond();
        return epochSecond;
    }

    /**
     * LocalDateTimeをDate型に変換
     * @param date
     * @return
     */
    public static Date convertLocalDateTimeToDate(LocalDateTime localDate) {
        ZoneId zone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDate, zone);
        Instant instant = zonedDateTime.toInstant();
        return Date.from(instant);
   }

    /**
     * LocalDateTimeをDate型に変換
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date convertStringToDate(String date) {
    	SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDD);
        Date formatDate = null;
		try {
			formatDate = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return formatDate;
    }

}
