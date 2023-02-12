package com.dj.bms.common.dao.mapper.injector.methods;

import com.dj.bms.common.dao.mapper.enums.SqlMethod;
import com.dj.bms.common.dao.mapper.metadata.TableInfo;

import org.apache.ibatis.executor.keygen.NoKeyGenerator;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.mapping.SqlSource;

/**
 * 查询满足条件的一条数据
 *
 * @Author: zcq
 * @Date: 2019/8/29 22:01
 */
public class SelectOne extends AbstractMethod {

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        SqlMethod selectOne = SqlMethod.SELECT_ONE;
        String sqlScript = String.format(selectOne.getSql(), tableInfo.getSelectColumnSegments(true),
                tableInfo.getTableName(), getWrapperScript());
        SqlSource sqlSource = this.languageDriver.createSqlSource(this.configuration, sqlScript, modelClass);
        return this.addMappedStatement(mapperClass, selectOne.getMethod(), sqlSource, SqlCommandType.SELECT, String.class, null, modelClass, new NoKeyGenerator(), tableInfo.getKeyProperty(), tableInfo.getKeyColumn());
    }
}
