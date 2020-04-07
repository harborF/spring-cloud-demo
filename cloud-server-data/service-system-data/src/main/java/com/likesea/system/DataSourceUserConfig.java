package com.likesea.system;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Deprecated
//@Configuration
@MapperScan(basePackages = "com.likesea.system.mapper", sqlSessionTemplateRef = "userSqlSessionTemplate")
public class DataSourceUserConfig {

    @Bean(name = "userDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.user-db")
    public DataSource userDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "userSqlSessionFactory")
    public SqlSessionFactory userSqlSessionFactory(@Qualifier("userDataSource") DataSource dataSource) throws Exception {
        org.apache.ibatis.session.Configuration ibatisConfig = new org.apache.ibatis.session.Configuration();
        ibatisConfig.setMapUnderscoreToCamelCase(true);

        SqlSessionFactoryBean mybatisBean = new SqlSessionFactoryBean();
        mybatisBean.setDataSource(dataSource);
        mybatisBean.setConfiguration(ibatisConfig);
        mybatisBean.setTypeAliasesPackage("com.likesea.data.domain.user");
        mybatisBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mappers.user/*.xml"));
        return mybatisBean.getObject();
    }

    @Bean(name = "userTransactionManager")
    @Primary
    public DataSourceTransactionManager userTransactionManager(@Qualifier("userDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "userSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate userSqlSessionTemplate(@Qualifier("userSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}

