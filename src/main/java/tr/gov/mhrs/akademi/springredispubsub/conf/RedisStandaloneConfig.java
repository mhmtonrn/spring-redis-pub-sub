package tr.gov.mhrs.akademi.springredispubsub.conf;

import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
@EnableConfigurationProperties(RedisConfigurationProperties.class)
@ConditionalOnProperty(prefix = "redis", name = "type", havingValue = "standalone")
public class RedisStandaloneConfig {

  @Autowired
  RedisConfigurationProperties redisConfigurationProperties;

  @Bean
  public JedisPoolConfig jedisPoolConfig() {
    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
    jedisPoolConfig.setMinIdle(redisConfigurationProperties.getMinIdle());
    jedisPoolConfig.setMaxIdle(redisConfigurationProperties.getMaxIdle());
    jedisPoolConfig.setMaxTotal(redisConfigurationProperties.getMaxTotal());
    jedisPoolConfig.setMaxWaitMillis(redisConfigurationProperties.getMaxWaitMillis());
    return jedisPoolConfig;
  }


  @Bean
  public RedisStandaloneConfiguration redisStandaloneConfiguration() {
    RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
    configuration.setHostName(redisConfigurationProperties.getNodes().get(0));
    configuration.setPort(redisConfigurationProperties.getPort());
    return configuration;
  }


  @Bean
  public JedisConnectionFactory jedisConnectionFactory() {
    return new JedisConnectionFactory(redisStandaloneConfiguration(), jedisClientConfiguration());
  }


  @Bean
  public JedisClientConfiguration jedisClientConfiguration() {
    JedisClientConfiguration.JedisClientConfigurationBuilder builder = JedisClientConfiguration.builder();
    builder.connectTimeout(Duration.ofMillis(redisConfigurationProperties.getConnectTimeout()));
    builder.readTimeout(Duration.ofMillis(redisConfigurationProperties.getReadTimeout()));
    return builder.usePooling()
        .poolConfig(jedisPoolConfig())
        .build();
  }

}
