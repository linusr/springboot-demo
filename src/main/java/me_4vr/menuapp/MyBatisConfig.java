package me_4vr.menuapp;

import me_4vr.menuapp.mapper.plugin.LoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisConfig {

    @Bean
    LoggingInterceptor loggingInterceptor() {
        return new LoggingInterceptor();
    }
}
