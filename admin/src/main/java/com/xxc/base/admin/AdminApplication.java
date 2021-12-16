package com.xxc.base.admin;

import com.hccake.ballcat.autoconfigure.log.annotation.EnableAccessLog;
import com.hccake.ballcat.autoconfigure.log.annotation.EnableOperationLog;
import com.hccake.ballcat.common.swagger.annotation.EnableSwagger2Aggregator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hccake
 */
@EnableSwagger2Aggregator
@EnableAccessLog
@EnableOperationLog
@MapperScan({ "com.xxc.base.**.mapper" })
@SpringBootApplication
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

}
