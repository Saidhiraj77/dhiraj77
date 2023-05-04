package com.cognizant.demo;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
//@EnableEurekaServer
public class AirlineApplication {
	
	
	@Bean
	JdbcTemplate getJdbcTemplate(DataSource dataSource)
	{
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		jdbcTemplate.setQueryTimeout(20);        
		jdbcTemplate.setFetchSize(10);                     // fetch 10 rows at atime
		return jdbcTemplate;
	}

	
	public static void main(String[] args) {
		SpringApplication.run(AirlineApplication.class, args);
	}

}
