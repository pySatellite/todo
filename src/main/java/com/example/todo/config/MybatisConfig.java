package com.example.todo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// @Configuration
// @PropertySource("classpath:/application.yaml")
public class MybatisConfig {

    // @Bean
    // public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
    //     SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
    //     sessionFactoryBean.setDataSource(dataSource);
    //     sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mappers/**/*.xml"));
    //     return sessionFactoryBean.getObject();
    // }
    // DI 구현
    @Autowired
    private ApplicationContext context; 

    // hikariConfig : ApplicationContext
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public HikariConfig hikariConfig() {
        HikariConfig config = new HikariConfig();
        return config ;
    }
    
    @Bean
    public DataSource datasource() {
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(datasource()); 
        // Mapper 관련 추가 작업이 필요하다.
        factory.setMapperLocations( context.getResources("classpath:/mappers/**/*Mapper.xml"));
        return factory.getObject() ; 
    }

    // 
    @Bean
    public SqlSessionTemplate sqlSession() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

}
