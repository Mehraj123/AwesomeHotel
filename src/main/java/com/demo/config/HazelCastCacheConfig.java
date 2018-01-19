/*package com.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;;

@Configuration
@EnableCaching
public class HazelCastCacheConfig {

	private static final Logger logger = LoggerFactory.getLogger(HazelCastCacheConfig.class);

	@Value("${cache.hazelcast.host}")
	private String host;

	@Value("${cache.hazelcast.port}")
	private String port;

	@Value("${cache.hazelcast.expirationInSeconds}")
	private int expirationInSeconds;


	@Bean
	public HazelcastInstance hazelcastInstance() {
		String uri = host + ":" + port;
		logger.info("--- Connecting hazelcast client to {} ", uri);
		Config config = new Config();
		NetworkConfig network =  config.getNetworkConfig();
		network.getJoin().getTcpIpConfig().setEnabled(true);
		ClientConfig clientConfig = new ClientConfig();
		ClientNetworkConfig networkConfig = clientConfig.getNetworkConfig();
		networkConfig.addAddress(host);
		clientConfig.setNetworkConfig(networkConfig);
		HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
		logger.info("--- Connected successfully to {} ", uri);
		HazelcastInstance client = Hazelcast.newHazelcastInstance();
		return client;
	}
}
*/