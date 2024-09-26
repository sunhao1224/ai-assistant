package com.radiance.ai.assistant.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * AI 助手数据源
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 15:03
 * @since 1.0.0
 */
@Slf4j
@Configuration
@MapperScan(basePackages = "com.radiance.ai.assistant.mapper",
        sqlSessionTemplateRef = "asstSqlSessionTemplate")
public class AsstDatasource {

    @Bean(name = "asst")
    @ConfigurationProperties(prefix = "spring.datasource.asst")
    public DataSource indexManagement() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "asstSqlSessionFactory")
    public SqlSessionFactory indexManagementSqlSessionFactory(@Qualifier("asst") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(this.resolveMapperLocations(Arrays.asList("classpath:mapper/*.xml")));
        return bean.getObject();
    }

    @Bean(name = "asstTransactionManager")
    public DataSourceTransactionManager indexManagementTransactionManager(@Qualifier("asst") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "asstSqlSessionTemplate")
    public SqlSessionTemplate indexManagementSqlSessionTemplate(
            @Qualifier("asstSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    @ConfigurationProperties("mybatis.configuration")
    public org.apache.ibatis.session.Configuration globalConfiguration() {
        return new org.apache.ibatis.session.Configuration();
    }

    /**
     * 解析 Mybatis 包扫描路径
     *
     * @param mapperLocationList 包扫描路径列表
     * @return 返回资源数组
     * @author sunhao
     * @date 2024/9/25 16:18
     * @since 1.0.0
     */
    private Resource[] resolveMapperLocations(List<String> mapperLocationList) {
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        List<Resource> resources = new ArrayList<>();
        if (!CollectionUtils.isEmpty(mapperLocationList)) {
            for (String mapperLocation : mapperLocationList) {
                try {
                    Resource[] mappers = resourceResolver.getResources(mapperLocation);
                    resources.addAll(Arrays.asList(mappers));
                } catch (IOException e) {
                    log.error("Get myBatis resources happened exception", e);
                }
            }
        }
        return resources.toArray(new Resource[0]);
    }

}
