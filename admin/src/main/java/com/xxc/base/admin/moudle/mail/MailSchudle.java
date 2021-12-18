package com.xxc.base.admin.moudle.mail;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Jadmin
 */
@Service
@Slf4j
public class MailSchudle {

	@Scheduled(cron = "0 0 19 * * ? ")
	public void mailAlarm() {
		log.info("发送消息提醒成功:{}", LocalDate.now());
		MailAccount account = new MailAccount();
		account.setHost("smtp.qq.com");
		account.setPort(465);
		account.setAuth(true);
		account.setFrom("1243678726@qq.com");
		account.setUser("1243678726");
		account.setPass("fuhzsshyrexsujchb");
		account.setSslEnable(true);
		String content = "现在是:" + DateUtil.now() + ",下班啦~";
		MailUtil.send(account, CollUtil.newArrayList("admin@xxc520.cn"), "记得下班打卡！！！！", content + "下班啦 下班啦", false);
	}

}
