package com.xxc.base.admin.moudle.mail.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Slf4j
public class RestDayUtils {

	public static boolean isWeekend(String bDate) {
		try {
			DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			Date bdate = format1.parse(bDate);
			Calendar cal = Calendar.getInstance();
			cal.setTime(bdate);
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
					|| cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e) {
			log.error("com.xxc.base.admin.moudle.mail.MailSchudle.isWeekend 时间判断异常：{}", e.getMessage());
		}
		return false;

	}

}
