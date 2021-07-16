package com.itplus.configuration;


//import java.util.Properties;

import javax.sql.DataSource;

//import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.itplus"})
//@EnableTransactionManagement
@PropertySource(value = {"classpath:db.properties"})
public class SpringConfiguration implements WebMvcConfigurer{
	@Autowired
	Environment enviroment;
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;		
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
		bundleMessageSource.setBasename("classpath:messages");
		bundleMessageSource.setDefaultEncoding("utf-8");
		return bundleMessageSource;
	}
	
	@Bean(name = "multipartResolver")
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(-1);
		return commonsMultipartResolver;
	}
	
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(enviroment.getProperty("driver"));
		dataSource.setUrl(enviroment.getProperty("url"));
		//dataSource.setUsername(enviroment.getProperty("username"));
		dataSource.setUsername("root");
		dataSource.setPassword(enviroment.getProperty("password"));
		return dataSource;
	}	
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
//	@Bean
//	public DataSourceTransactionManager dataSourceTransactionManager() {
//		return new DataSourceTransactionManager(dataSource());
//	}
	
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		return mapper;
	}
	
//	@Bean
//	public LocalSessionFactoryBean localSessionFactoryBean() {
//		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
//		bean.setDataSource(dataSource());
//		bean.setPackagesToScan("com.itplus.entity");
//		Properties properties = new Properties();
//		properties.put("hibernate.dialect", enviroment.getProperty("hibernate.dialect"));
//		properties.put("hibernate.show_sql", enviroment.getProperty("hibernate.show_sql"));
//		return bean;
//	}
//	
//	
//	@Bean(name = "transactionManager")
//	@Autowired
//	public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
//		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
//		hibernateTransactionManager.setSessionFactory(sessionFactory);
//		return hibernateTransactionManager;		
//	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
