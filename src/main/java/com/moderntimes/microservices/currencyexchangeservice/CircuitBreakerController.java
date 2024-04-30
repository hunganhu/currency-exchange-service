package com.moderntimes.microservices.currencyexchangeservice;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    // default is to retry 3 times, then return error response,
    // It can be changed to 5 by setting the attribute
    // resilience4j.retry.instances.sample-api.maxAttempts=5
    // the string "sample-api" of the attribute is the same as the Retry name.
    // You can specify fallbackMethod to be called when reaching the retry limit.
    // change retry interval by setting
    // resilience4j.retry.instances.sample-api.waitDuration=1s

    // The interval increases exponentially by setting
    // resilience4j.retry.instances.sample-api.enableExponentialBackoff=true
    // the interval each retry takes longer than the previous retry.
    //@Retry(name="sample-api", fallbackMethod = "hardCodedResponse")
    //@CircuitBreaker(name="default", fallbackMethod = "hardCodedResponse")
    // watch -n 0.1 curl http://localhost:8000/sample-api
    @RateLimiter(name="default")
    //@Bulkhead(name="sample-api")
    public String sampleApi() {
        logger.info("Sample API call received");
  //      ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/dummy-url",
    //          String.class);
      //  return forEntity.getBody();
        return "Sample-API";
    }

    public String hardCodedResponse(Exception ex) {
        return ("fallback-response");
    }
}
