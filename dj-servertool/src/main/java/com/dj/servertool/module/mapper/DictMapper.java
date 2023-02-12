package com.dj.servertool.module.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dj.servertool.core.common.node.ZTreeNode;
import com.dj.servertool.module.entity.Dict;

/**
 * <p>
 * 基础字典 Mapper 接口
 * </p>
 */
public interface DictMapper extends BaseMapper<Dict> {

	/**
	 * 获取ztree的节点列表
	 */
	List<ZTreeNode> dictTree(@Param("dictTypeId") Long dictTypeId);

	/**
	 * where parentIds like ''
	 */
	List<Dict> likeParentIds(@Param("dictId") Long dictId);
}
