package com.dj.bms.modules.tag.controller;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dj.bms.common.controller.AbstractBaseController;
import com.dj.bms.common.dao.mapper.wrapper.query.QueryWrapper;
import com.dj.bms.common.service.BaseService;
import com.dj.bms.modules.tag.dto.TagDTO;
import com.dj.bms.modules.tag.model.Tag;
import com.dj.bms.modules.tag.service.TagService;
import com.dj.bms.modules.tag.vo.TagVO;

/**
 * @author zcq
 * @date 2020-01-14
 */
@Controller
@RequestMapping(value = "/tag")
public class TagController extends AbstractBaseController<Tag, TagDTO, TagVO> {

	@Autowired
	private TagService tagService;
	
	@Override
	protected Function<? super TagDTO, ? extends TagVO> getDTO2VO() {
		return tagDTO -> {
			TagVO tagVO = new TagVO();
			tagVO.setTagId(tagDTO.getTagId());
			tagVO.setTagName(tagDTO.getTagName());
			tagVO.setTagAvatar(tagDTO.getTagAvatar());
			tagVO.setTagContent(tagDTO.getTagContent());
			tagVO.setTagState(tagDTO.getTagState());
			tagVO.setCreateDate(tagDTO.getCreateDate());
			tagVO.setUpdateDate(tagDTO.getUpdateDate());
			return tagVO;
		};
	}

	@Override
	protected Function<? super TagVO, ? extends TagDTO> getVO2DTO() {
		return tagVO -> {
			TagDTO tagDTO = new TagDTO();
			tagDTO.setTagId(tagVO.getTagId());
			tagDTO.setTagName(tagVO.getTagName());
			tagDTO.setTagAvatar(tagVO.getTagAvatar());
			tagDTO.setTagContent(tagVO.getTagContent());
			tagDTO.setTagState(tagVO.getTagState());
			tagDTO.setCreateDate(tagVO.getCreateDate());
			tagDTO.setUpdateDate(tagVO.getUpdateDate());
			return tagDTO;
		};
	}

	@Override
	protected BaseService<Tag, TagDTO> getService() {
		return tagService;
	}

	@Override
	protected String getModuleName() {
		return "tag";
	}

	@Override
	protected QueryWrapper<Tag> getQueryWrapper() {
		return new QueryWrapper<>();
	}

}
