package com.xxc.base.admin.moudle.mail;

import cn.hutool.http.HttpUtil;
import com.xxc.base.admin.moudle.mail.utils.RestDayUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * @date 2021年12月20日22:14:14
 * @author Jadmin
 */
@Service
@Slf4j
public class MailSchudle {

	private String url = "http://bark.xxc520.cn/YVE3STKSVsEbwKkBUJxnYc/小小谢温馨提醒/";

	@Scheduled(cron = "0 0 18 * * ? ")
	public void mailAlarm() {
		boolean weekend = RestDayUtils.isWeekend(LocalDate.now().toString());
		if (weekend) {
			log.info("今天是:{} 属于节假日 不提醒", LocalDate.now());
			return;
		}
		String s = url + "下班打卡~ ";
		log.info("发送消息提醒成功:{}", LocalDate.now());
		HttpUtil.get(s);
	}

}
