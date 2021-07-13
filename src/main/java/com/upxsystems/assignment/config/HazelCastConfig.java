package com.upxsystems.assignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;

@Configuration
public class HazelCastConfig {
	@Bean
	public Config hazelCastConfig() {
		return new Config().setInstanceName("hazelcast-instance")
				.addMapConfig(new MapConfig().setName("usersCache"));
	}

}
