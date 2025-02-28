package kr.co.basedevice.corebase.config;

import java.util.Arrays;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class CachingConfig {
	
	@Bean
    CacheManager cacheManager() {
		SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(
        	Arrays.asList(
                new ConcurrentMapCache("CODE", false),
                new ConcurrentMapCache("MENU", false),
                new ConcurrentMapCache("AUTH_MENU", false),
                new ConcurrentMapCache("ROLE", false),
                new ConcurrentMapCache("ORG", false)
            )
        );
        return cacheManager;
	}
    
}
