package com.demo.config;
/*package com.demo.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

*//**
	 * Configuration for EHCache
	 * 
	 * @author Mehraj Malik
	 * @version 1.0
	 *//*
		@Configuration
		@EnableCaching
		public class EHCacheConfig {
		
		@Bean
		public CacheManager cacheManager() {
			return new EhCacheCacheManager();
		}
		
		@Bean
		public EhCacheManagerFactoryBean ehCacheCacheManager() {
			EhCacheManagerFactoryBean factory = new EhCacheManagerFactoryBean();
			factory.setConfigLocation(new ClassPathResource("ehcache.xml"));
			factory.setShared(true);
			return factory;
		}
		}
		*/