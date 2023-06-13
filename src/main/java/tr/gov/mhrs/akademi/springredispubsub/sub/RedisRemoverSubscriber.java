package tr.gov.mhrs.akademi.springredispubsub.sub;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class RedisRemoverSubscriber implements MessageListener {



  @Override
  public void onMessage(Message message, byte[] pattern) {
    System.out.println("Received message " + message + " from channel " + new String(pattern));
    RedisMessageSubscriber.kilitliSlotlar.remove(Integer.parseInt(message.toString()));
    System.out.println("list " + RedisMessageSubscriber.kilitliSlotlar.toString());
  }
}