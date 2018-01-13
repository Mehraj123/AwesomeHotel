package com.ah.apache.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author user
 *
 */
public class Constants {

	private static final Logger log = LoggerFactory.getLogger(Constants.class);

	public static void main(String[] args) {
		log.info(StringUtils.defaultIfBlank(" ", "Defalut"));
		log.info(StringUtils.defaultIfEmpty(" ", "Defalut"));
		log.info("getDigits {}", StringUtils.getDigits("12fdf45(@%&(#$&58"));
		log.info("isAllBlank {}", StringUtils.isAllBlank("", null, " "));
		log.info("isAllLowerCase {}", StringUtils.isAllLowerCase("msjhajahdj"));
		log.info("isAllLowerCase {}", StringUtils.isAllLowerCase("msjhajahdj"));
		log.info("isAlphanumeric {}", StringUtils.isAlphanumeric("ABCabc123"));
		log.info("join {}", StringUtils.join("A", "B", "C", 1, 1.0, 1.1));
		byte[] array = { 'A', 'B', 'C' };
		log.info("join {}", StringUtils.join(array, ','));
		List<String> strings = new ArrayList<>(Arrays.asList("A", "B", "C"));
		log.info("join {}", StringUtils.join(strings, "++"));
		log.info("hasText {}", org.springframework.util.StringUtils.hasText(""));
	}
}
