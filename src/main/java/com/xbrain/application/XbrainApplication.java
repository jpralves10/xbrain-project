package com.xbrain.application;

import java.util.TimeZone;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackageClasses = { XbrainApplication.class, Jsr310JpaConverters.class })
@ComponentScan(basePackages="com.xbrain.application")
@EnableJpaRepositories("com.xbrain.application")
@EnableScheduling
public class XbrainApplication {

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(XbrainApplication.class, args);
	}
	
	@Bean
	public TaskScheduler taskScheduler() {
	    return new ConcurrentTaskScheduler(Executors.newSingleThreadScheduledExecutor());
	}
}