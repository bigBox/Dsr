package com.dj.servertool.module.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.servertool.module.entity.Relation;
import com.dj.servertool.module.mapper.RelationMapper;

/**
 * <p>
 * 角色和菜单关联表 服务实现类
 * </p>
 */
@Service
public class RelationService extends ServiceImpl<RelationMapper, Relation> {

}
