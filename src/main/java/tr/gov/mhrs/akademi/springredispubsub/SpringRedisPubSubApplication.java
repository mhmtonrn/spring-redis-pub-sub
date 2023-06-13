package tr.gov.mhrs.akademi.springredispubsub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringRedisPubSubApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringRedisPubSubApplication.class, args);
  }

}
