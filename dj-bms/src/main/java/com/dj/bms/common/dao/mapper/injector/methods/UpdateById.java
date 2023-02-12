package com.dj.bms.common.dao.mapper.injector.methods;

import com.dj.bms.common.dao.mapper.enums.SqlMethod;
import com.dj.bms.common.dao.mapper.metadata.TableInfo;

import org.apache.ibatis.executor.keygen.NoKeyGenerator;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.mapping.SqlSource;

/**
 * 根据 ID 更新一条数据
 * @Author: zcq
 * @Date: 2019/11/2 23:47
 */
public class UpdateById extends AbstractMethod {

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        SqlMethod updateById = SqlMethod.UPDATE_BY_ID;
        String sqlScript = String.format(updateById.getSql(), tableInfo.getTableName(), tableInfo.getSetSegments(),
                tableInfo.getKeyColumn(), tableInfo.getKeyPropertySegment());
        SqlSource sqlSource = this.languageDriver.createSqlSource(this.configuration, sqlScript, modelClass);
        return this.addMappedStatement(mapperClass, updateById.getMethod(), sqlSource, SqlCommandType.UPDATE, String.class, null, Integer.class, new NoKeyGenerator(), tableInfo.getKeyProperty(), tableInfo.getKeyColumn());
    }
}
