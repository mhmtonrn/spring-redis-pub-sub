package tr.gov.mhrs.akademi.springredispubsub.conf;

import lombok.RequiredArgsConstructor;
import tr.gov.mhrs.akademi.springredispubsub.sub.RedisMessageSubscriber;
import tr.gov.mhrs.akademi.springredispubsub.sub.RedisRemoverSubscriber;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@RequiredArgsConstructor
public class AppConf {

  private final RedisConnectionFactory jedisConnectionFactory;

  @Bean
  public RedisTemplate<String, Object> redisTemplate() {
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(jedisConnectionFactory);
    template.setKeySerializer(new StringRedisSerializer());
    template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
    return template;
  }

  @Bean
  public RedisMessageListenerContainer redisContainer() {
    RedisMessageListenerContainer container = new RedisMessageListenerContainer();
    container.setConnectionFactory(jedisConnectionFactory);
    container.addMessageListener(messageListener(), addChanel());
    return container;
  }

  @Bean
  public MessageListenerAdapter messageListener() {
    return new MessageListenerAdapter(new RedisMessageSubscriber());
  }

  @Bean
  public MessageListenerAdapter removerListener() {
    return new MessageListenerAdapter(new RedisRemoverSubscriber());
  }

  @Bean("addChanel")
  public ChannelTopic addChanel() {
    return new ChannelTopic("add-channel");
  }

}
