package com.demo.apache.string;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * @author Mehraj Malik
 *
 */
public class SpringUtil {

	private static final Logger log = LoggerFactory.getLogger(SpringUtil.class);

	public static void main(String[] args) {
		log.info("quoteIfString {}", StringUtils.quoteIfString("Hi"));
		log.info("addStringToArray {}", StringUtils.addStringToArray(null, "a"));
		log.info("capitalize {}", StringUtils.capitalize("mehraj"));
		log.info("containsWhitespace {}", StringUtils.containsWhitespace("mehraj "));
		log.info("countOccurrencesOf {}", StringUtils.countOccurrencesOf("helelela", "el"));
		log.info("countOccurrencesOf {}", StringUtils.delete("Heyaaa", "aa"));
		log.info("deleteAny {}", StringUtils.deleteAny("Heyaaa", "aay"));
		log.info("isEmpty {}", StringUtils.isEmpty(""));
		log.info("trimAllWhitespace {}", StringUtils.trimAllWhitespace("  There is no white space  "));
		log.info("trimWhitespace {}", StringUtils.trimWhitespace("  No leading and traling whitespace "));
	}
}
