package com.alura.hotelalura.springboottres.config;

import java.time.Duration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;



@Configuration
@EnableCaching
public class RedisConfig 
{
    @Bean
    public RedisConnectionFactory redisConnectionFactory()
    {
       return new LettuceConnectionFactory(System.getenv("REMOTE_DB"),6379);
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory)
    {   
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig()
                                                .entryTtl(Duration.ofMinutes(3));
        
        RedisCacheConfiguration configuration2 = RedisCacheConfiguration.defaultCacheConfig()
                                                 .entryTtl(Duration.ofHours(1));                                        
                                                                                         

        return RedisCacheManager.builder(redisConnectionFactory)
                                .cacheDefaults(configuration)
                                .withCacheConfiguration("cachingUserName", configuration2)
                                .build();
    }
}
