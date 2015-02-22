package cassandraexample.sergio.olmedo.CassandraSpring.cassandraconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@PropertySource(value = { "classpath:cassandra.properties" })
@EnableTransactionManagement
@ComponentScan(basePackages="cassandraexample.sergio.olmedo.CassandraSpring.*")
@EnableCassandraRepositories(basePackages = { "cassandraexample.sergio.olmedo.CassandraSpring.*" })
public class CassandraConfiguration extends AbstractCassandraConfiguration {
	
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
//		LocalContainerEntityManagerFactoryBean em=new LocalContainerEntityManagerFactoryBean();
//		em.setDataSource(dataSource());
//		em.setPackagesToScan(new String[]{"cassandraexample.sergio.olmedo.CassandraSpring.*"});
//		JpaVendorAdapter vendorAdapter= new HibernateJpaVendorAdapter();
//		em.setJpaVendorAdapter(vendorAdapter);
//		em.setJpaProperties(additionalProperties());
//		return em;
//		
//	}
//	
//	@Bean
//	public DataSource dataSource(){
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/configcps");
//		dataSource.setUsername("prueba");
//		dataSource.setPassword("prueba");
//		return dataSource;
	
//	}
//	@Bean
//	public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
//		JpaTransactionManager transactionManager= new JpaTransactionManager();
//		transactionManager.setEntityManagerFactory(emf);
//		return transactionManager;
//		
//	}
//	@Bean
//	public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
//		return new PersistenceExceptionTranslationPostProcessor();
//		
//	}
	
//	Properties additionalProperties(){
//		Properties properties = new Properties();
//		properties.setProperty("hibernate.hbm2ddl.auto", "update");
//		properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
//		return properties;
//		
//		
//	}
	

    @Autowired
    private Environment environment;

    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints(environment.getProperty("cassandra.contactpoints"));
        cluster.setPort(Integer.parseInt(environment.getProperty("cassandra.port")));
        return cluster;
    }

    protected String getKeyspaceName() {
        return environment.getProperty("cassandra.keyspace");
    }

    @Bean
    public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {
        return new BasicCassandraMappingContext();
    }
}