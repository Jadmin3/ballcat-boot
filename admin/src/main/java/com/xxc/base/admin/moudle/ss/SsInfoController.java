package com.xxc.base.admin.moudle.ss;

import cn.hutool.http.HttpUtil;
import com.hccake.ballcat.common.model.result.R;
import com.xxc.base.admin.moudle.ss.entity.SsInfoEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author Jadmin
 */
@RestController
@RequestMapping({ "/ss" })
@Slf4j
public class SsInfoController {

	@GetMapping("/info")
	public Object getSsInfo() {
		try {
			String url = "";
			String post = HttpUtil.get(url, new HashMap<>(2));
			byte[] decode = Base64.getDecoder().decode(post);
			String s = new String(decode, StandardCharsets.UTF_8);
			String[] split = s.split("ss://");
			List<SsInfoEntity> datas = new ArrayList<>();
			for (int i = 0; i < split.length; i++) {
				String s1 = split[i];
				if (s1.contains("vmess://")) {
					continue;
				}
				SsInfoEntity ssInfoEntity = SsInfoEntity.builder().id(Long.parseLong(String.valueOf(i)))
						.by("www.xxc520.cn").msg("版權來自于网站，請勿用於商業用途").url("ss://" + split[i]).build();
				datas.add(ssInfoEntity);
			}

			String[] split2 = s.split("vmess://");
			for (String s1 : split2) {
				if (s1.contains("ss://")) {
					continue;
				}
				SsInfoEntity ssInfoEntity = SsInfoEntity.builder().id(1L).by("www.xxc520.cn").msg("版權來自于网站，請勿用於商業用途")
						.url("vmess://" + s1).build();
				datas.add(ssInfoEntity);
			}

			return R.ok(datas);
		}
		catch (Exception e) {
			log.error("获取ss信息失败:{}", e.getMessage());
		}

		return null;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		String url = "";
		Map m = new HashMap();
		String post = HttpUtil.get(url, m);
		byte[] decode = Base64.getDecoder().decode(post);
		String s = new String(decode, "utf-8");
		// System.out.println(s );
		String[] split = s.split("ss://");
		// System.out.println(split[1]);
		String[] split2 = s.split("vmess://");
		for (String s1 : split2) {
			if (s1.contains("ss://")) {
				continue;
			}
			System.out.println("vmess://" + s1);
		}

	}

}
