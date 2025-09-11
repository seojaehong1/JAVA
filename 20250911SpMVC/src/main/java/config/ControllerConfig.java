package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = {"chap09","spring"})
public class ControllerConfig {
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3305/spring5fs?characterEncoding=utf8");
		ds.setUsername("root");
		ds.setPassword("1234");
//		ds.setInitialSize(2);
//		ds.setMaxActive(10);
//		ds.setTestWhileIdle(true);
//		ds.setMinEvictableIdleTimeMillis(60000 * 3);
//		ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
		return ds;
	}

}
