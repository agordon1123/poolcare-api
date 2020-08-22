// TODO: configure datasource
package com.poolcare.poolcareapi.config;

import java.beans.BeanProperty;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.poolcare.poolcareapi.repository", entityManagerFactoryRef = "pcDataSourceEntityManager")
public class DataSourceConfig {
    private final Logger LOG = LoggerFactory.getLogger(DataSourceConfig.class);
    
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    public DataSourceConfig() {
        super();
    }

    @Primary
    @Bean
	public LocalContainerEntityManagerFactoryBean pcDataSourceEntityManager() {
		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(pcDataSource());
		em.setPackagesToScan("com.poolcare.poolcareapi.domain");
		final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setPersistenceUnitName("pcPersistenceUnit");
		return em;
	}

    @Primary
    @Bean
    public DataSource pcDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        LOG.info(">> DataSource being setup:" + url);
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
    }
    
}