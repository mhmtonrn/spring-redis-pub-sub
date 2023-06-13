package tr.gov.mhrs.akademi.springredispubsub.conf;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "redis")
public class RedisConfigurationProperties {

  private Integer port;
  private Integer minIdle;
  private Integer maxIdle;
  private Integer maxTotal;
  private Integer maxWaitMillis;
  private Integer connectTimeout;
  private Integer readTimeout;
  private List<String> nodes;
  private Integer maxRedirects;

  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }

  public Integer getMinIdle() {
    return minIdle;
  }

  public void setMinIdle(Integer minIdle) {
    this.minIdle = minIdle;
  }

  public Integer getMaxIdle() {
    return maxIdle;
  }

  public void setMaxIdle(Integer maxIdle) {
    this.maxIdle = maxIdle;
  }

  public Integer getMaxTotal() {
    return maxTotal;
  }

  public void setMaxTotal(Integer maxTotal) {
    this.maxTotal = maxTotal;
  }

  public Integer getMaxWaitMillis() {
    return maxWaitMillis;
  }

  public void setMaxWaitMillis(Integer maxWaitMillis) {
    this.maxWaitMillis = maxWaitMillis;
  }

  public Integer getConnectTimeout() {
    return connectTimeout;
  }

  public void setConnectTimeout(Integer connectTimeout) {
    this.connectTimeout = connectTimeout;
  }

  public Integer getReadTimeout() {
    return readTimeout;
  }

  public void setReadTimeout(Integer readTimeout) {
    this.readTimeout = readTimeout;
  }

  public List<String> getNodes() {
    return nodes;
  }

  public void setNodes(List<String> nodes) {
    this.nodes = nodes;
  }

  public Integer getMaxRedirects() {
    return maxRedirects;
  }

  public void setMaxRedirects(Integer maxRedirects) {
    this.maxRedirects = maxRedirects;
  }

}
