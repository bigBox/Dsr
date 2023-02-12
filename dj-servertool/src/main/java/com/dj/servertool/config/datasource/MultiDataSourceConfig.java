package com.dj.servertool.config.datasource;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.atomikos.jdbc.AtomikosDataSourceBean;

import cn.stylefeng.roses.core.config.properties.DruidProperties;
import cn.stylefeng.roses.core.mutidatasource.aop.MultiSourceExAop;
import cn.stylefeng.roses.core.util.ToolUtil;

/**
 * 多数据源配置<br/>
 * <p>
 * 注：由于引入多数据源，所以让spring事务的aop要在多数据源切换aop的后面
 */
@Configuration
@ConditionalOnProperty(prefix = "site.datasource", name = "open", havingValue = "true")
@MapperScan(basePackages = { "com.dj.servertool.module.mapper" }, sqlSessionTemplateRef = "sqlSessionTemplate")
public class MultiDataSourceConfig {

	/**
	 * 工具源配置
	 */
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "tool.datasource")
	public DruidProperties toolDruidProperties() {
		return new DruidProperties();
	}

	/**
	 * 网站源配置
	 */
	@Bean
	@ConfigurationProperties(prefix = "site.datasource")
	public DruidProperties siteDruidProperties() {
		return new DruidProperties();
	}

	/**
	 * 日志源配置
	 */
	@Bean
	@ConfigurationProperties(prefix = "log.datasource")
	public DruidProperties logDruidProperties() {
		return new DruidProperties();
	}

	/**
	 * 工具数据源实例
	 */
	@Primary
	@Bean
	public DataSource dataSourceTool(@Qualifier("toolDruidProperties") DruidProperties toolDruidProperties) {
		if (ToolUtil.isOneEmpty(toolDruidProperties, toolDruidProperties.getDataSourceName())) {
			throw new IllegalArgumentException(
					"初始化OptionalSqlSessionTemplate错误！请设置tool.datasource.data-source-name属性的值！");
		}
		return createDataSource(toolDruidProperties.getDataSourceName(), toolDruidProperties);
	}

	/**
	 * 网站数据源实例
	 */
	@Bean
	public DataSource dataSourceSite(@Qualifier("siteDruidProperties") DruidProperties siteDruidProperties) {
		if (ToolUtil.isOneEmpty(siteDruidProperties, siteDruidProperties.getDataSourceName())) {
			throw new IllegalArgumentException(
					"初始化OptionalSqlSessionTemplate错误！请设置site.datasource.data-source-name属性的值！");
		}
		return createDataSource(siteDruidProperties.getDataSourceName(), siteDruidProperties);
	}

	/**
	 * 日志数据源实例
	 */
	@Bean
	public DataSource dataSourceLog(@Qualifier("logDruidProperties") DruidProperties logDruidProperties) {
		if (ToolUtil.isOneEmpty(logDruidProperties, logDruidProperties.getDataSourceName())) {
			throw new IllegalArgumentException(
					"初始化OptionalSqlSessionTemplate错误！请设置log.datasource.data-source-name属性的值！");
		}
		return createDataSource(logDruidProperties.getDataSourceName(), logDruidProperties);
	}

	/**
	 * 多数据源切换的aop
	 */
	@Bean
	public MultiSourceExAop multiSourceExAop() {
		return new MultiSourceExAop();
	}

	/**
	 * 数据源创建模板
	 */
	private static DataSource createDataSource(String dataSourceName, DruidProperties druidProperties) {
		AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
		atomikosDataSourceBean.setXaDataSourceClassName("com.alibaba.druid.pool.xa.DruidXADataSource");
		atomikosDataSourceBean.setUniqueResourceName(dataSourceName);
		atomikosDataSourceBean.setXaProperties(druidProperties.createProperties());
		atomikosDataSourceBean.setMaxLifetime(30);
		atomikosDataSourceBean.setMaxIdleTime(30);
		return atomikosDataSourceBean;
	}
}
