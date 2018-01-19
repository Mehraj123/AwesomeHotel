/*package com.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

*//**
 * @author Mehraj Malik
 * @version 1.0
 *
 *//*
@Configuration
@EnableCaching
public class RedisCacheConfig {

	@Value("${spring.redis.host}")
	private String hostName;

	@Value("${spring.redis.port}")
	private Integer port;

	@Value("${redis.cache.expirationInSeconds}")
	private Long cacheExpirationSeconds;

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
		redisConnectionFactory.setHostName(hostName);
		redisConnectionFactory.setPort(port);
		return redisConnectionFactory;
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}

	@Bean
	public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate());
		// Number of seconds before expiration. Defaults to unlimited (0)
		cacheManager.setDefaultExpiration(cacheExpirationSeconds);
		return cacheManager;
	}

	*//**
	 * To generate custom unique key
	 *//*
	@Override
	@Bean
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object o, Method method, Object... objects) {
				// This will generate a unique key of the class name, the method name,
				// and all method parameters appended.
				StringBuilder sb = new StringBuilder();
				sb.append(o.getClass().getName());
				sb.append(method.getName());
				for (Object obj : objects) {
					sb.append(obj.toString());
				}
				return sb.toString();
			}
		};
	}

}
*/