package com.todo.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
	    "com.todo.dao",
	    "comtodo.model",
	    "com.todo.controller"
	})
public class AppConfig implements WebMvcConfigurer{
	@Bean
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setUrl("jdbc:mysql://localhost:3305/todo_db?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
		ds.setUsername("root");
		ds.setPassword("1234");
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource ds) {
		return new JdbcTemplate(ds);
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/views/");
		vr.setSuffix(".jsp");
		return vr;
	}
}
