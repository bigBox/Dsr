package com.dj.servertool.config.datasource;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.baomidou.mybatisplus.autoconfigure.SpringBootVFS;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;

import cn.stylefeng.roses.core.config.properties.DruidProperties;
import cn.stylefeng.roses.core.datascope.DataScopeInterceptor;
import cn.stylefeng.roses.core.mutidatasource.mybatis.OptionalSqlSessionTemplate;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;

/**
 * 多数据源配置<br/>
 * <p>
 * 注：由于引入多数据源，所以让spring事务的aop要在多数据源切换aop的后面
 */
@Slf4j
@Configuration
@ConditionalOnProperty(prefix = "site.datasource", name = "open", havingValue = "true")
public class MultiSqlSessionFactoryConfig {

	public static final String MAPPING_XML = "classpath:com/dj/servertool/module/mapping/*.xml";

	/**
	 * 工具sql工厂
	 */
	@Primary
	@Bean
	public SqlSessionFactory sqlSessionFactoryTool(@Qualifier("dataSourceTool") DataSource dataSource) {
		return createSqlSessionFactory(dataSource, MAPPING_XML);
	}

	/**
	 * 网站sql工厂
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactorySite(@Qualifier("dataSourceSite") DataSource dataSource) {
		return createSqlSessionFactory(dataSource, MAPPING_XML);
	}

	/**
	 * 日志sql工厂
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactoryLog(@Qualifier("dataSourceLog") DataSource dataSource) {
		return createSqlSessionFactory(dataSource, MAPPING_XML);
	}

	/**
	 * 多数据源sqlSessionTemplate切换模板
	 */
	@Bean(name = "sqlSessionTemplate")
	public OptionalSqlSessionTemplate sqlSessionTemplate(
			@Qualifier("sqlSessionFactoryTool") SqlSessionFactory sqlSessionFactoryTool,
			@Qualifier("sqlSessionFactorySite") SqlSessionFactory sqlSessionFactorySite,
			@Qualifier("sqlSessionFactoryLog") SqlSessionFactory sqlSessionFactoryLog,
			@Qualifier("toolDruidProperties") DruidProperties toolDruidProperties,
			@Qualifier("siteDruidProperties") DruidProperties siteDruidProperties,
			@Qualifier("logDruidProperties") DruidProperties logDruidProperties) {
		Map<Object, SqlSessionFactory> sqlSessionFactoryMap = new HashMap<>(3);
		sqlSessionFactoryMap.put(toolDruidProperties.getDataSourceName(), sqlSessionFactoryTool);
		sqlSessionFactoryMap.put(siteDruidProperties.getDataSourceName(), sqlSessionFactorySite);
		sqlSessionFactoryMap.put(logDruidProperties.getDataSourceName(), sqlSessionFactoryLog);
		return new OptionalSqlSessionTemplate(sqlSessionFactoryTool, sqlSessionFactoryMap);
	}

	/**
	 * mybatis-plus分页插件
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}

	/**
	 * 数据范围mybatis插件
	 */
	@Bean
	public DataScopeInterceptor dataScopeInterceptor() {
		return new DataScopeInterceptor();
	}

	/**
	 * 乐观锁mybatis插件
	 */
	@Bean
	public OptimisticLockerInterceptor optimisticLockerInterceptor() {
		return new OptimisticLockerInterceptor();
	}

	/**
	 * 创建数据源
	 */
	private SqlSessionFactory createSqlSessionFactory(DataSource dataSource, String xmlPath) {
		try {
			MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
			bean.setDataSource(dataSource);
			bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(xmlPath));
			bean.setVfs(SpringBootVFS.class);
			bean.setPlugins(new Interceptor[] { paginationInterceptor(), dataScopeInterceptor(),
					optimisticLockerInterceptor() });
			return bean.getObject();
		} catch (Exception e) {
			log.error("初始化SqlSessionFactory错误！", e);
			throw new ServiceException(500, "初始化SqlSessionFactory错误！");
		}
	}

}
