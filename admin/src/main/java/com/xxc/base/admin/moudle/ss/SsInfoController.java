package com.xxc.base.admin.moudle.ss;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jadmin
 */
@RestController
@RequestMapping({ "/ss" })
public class SsInfoController {


	@GetMapping("/info")
	public Object getSsInfo(){



		return null;
	}


}
