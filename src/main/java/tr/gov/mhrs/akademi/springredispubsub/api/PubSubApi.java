package tr.gov.mhrs.akademi.springredispubsub.api;

import lombok.RequiredArgsConstructor;
import tr.gov.mhrs.akademi.springredispubsub.conf.RedisMessagePublisher;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/publish")
public class PubSubApi {

  private final RedisMessagePublisher redisMessagePublisher;

  @PostMapping
  public ResponseEntity<Boolean> publishEvent(@RequestParam("message") String message){
    redisMessagePublisher.publish(message);
    return new ResponseEntity<>(true, HttpStatus.OK);
  }

}
