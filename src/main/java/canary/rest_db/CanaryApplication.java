package canary.rest_db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("canary.rest_db.repository")
public class CanaryApplication {

  public static void main(String[] args) {
    SpringApplication.run(CanaryApplication.class, args);
  }

}
