package com.xxc.base.admin.moudle.ss.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author Jadmin
 */
@Data
@Builder
public class SsInfoEntity {

	private Long id;

	private String url;

	private String msg;

	private String by;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime creationTime = LocalDateTime.now();

}
