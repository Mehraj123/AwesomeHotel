package com.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;;

@Configuration
@EnableCaching
public class HazelCastCacheConfig {

	@Value("${cache.hazelcast.expirationInSeconds}")
	private int expirationInSeconds;
	
	@Bean
    public Config hazelCastConfig(){
        return new Config()
                .setInstanceName("hazelcast-instance")
                .addMapConfig(
                        new MapConfig()
                                .setName("Hotel")
                                .setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
                                .setEvictionPolicy(EvictionPolicy.LRU)
                                .setTimeToLiveSeconds(expirationInSeconds));
    }
	
	public void sum() {
		ClientConfig clientConfig = new ClientConfig();
		ClientNetworkConfig  networkConfig = clientConfig.getNetworkConfig();
		networkConfig.addAddress("");
		//this.ClientNetworkConfig.setAddresses(new ArrayList<>());
		
		HazelcastClient.newHazelcastClient();
	}
}
