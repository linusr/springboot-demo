package me_4vr.menuapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jdbc.repository.config.MyBatisJdbcConfiguration;

// @EnableCaching
@EnableJdbcRepositories
@ConfigurationPropertiesScan
@Import({MyBatisJdbcConfiguration.class, MyBatisConfig.class})
@MapperScan("me_4vr.menuapp.mapper")
@SpringBootApplication // (exclude = {JacksonAutoConfiguration.class})
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
