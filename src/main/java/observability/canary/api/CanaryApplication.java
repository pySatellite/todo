package observability.canary.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("observability.canary.api.repository")
public class CanaryApplication {

  public static void main(String[] args) {
    SpringApplication.run(CanaryApplication.class, args);
  }

}
