package tr.gov.mhrs.akademi.springredispubsub.sub;

import java.util.concurrent.ConcurrentSkipListSet;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class RedisMessageSubscriber implements MessageListener {


  public static ConcurrentSkipListSet<Integer> kilitliSlotlar = new ConcurrentSkipListSet<>();


  @Override
  public void onMessage(Message message, byte[] pattern) {
    System.out.println("Received message " + message + " from channel " + new String(pattern));
    kilitliSlotlar.add(Integer.parseInt(message.toString()));
    System.out.println("list " + kilitliSlotlar.toString());
  }
}