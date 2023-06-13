package tr.gov.mhrs.akademi.springredispubsub.conf;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisMessagePublisher {

  private final RedisTemplate<String, Object> redisTemplate;

  @Qualifier("addChanel")
  private final ChannelTopic topic;

  public void publish(String message) {
    redisTemplate.convertAndSend(topic.getTopic(), Integer.parseInt(message));
  }
}