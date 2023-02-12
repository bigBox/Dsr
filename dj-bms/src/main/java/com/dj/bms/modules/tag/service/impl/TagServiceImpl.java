package com.dj.bms.modules.tag.service.impl;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dj.bms.common.dao.BaseDao;
import com.dj.bms.common.service.impl.AbstractBaseServiceImpl;
import com.dj.bms.common.util.DateUtils;
import com.dj.bms.modules.tag.dao.ITagDao;
import com.dj.bms.modules.tag.dto.TagDTO;
import com.dj.bms.modules.tag.model.Tag;
import com.dj.bms.modules.tag.service.TagService;

/**
 * @author zcq
 * @date 2020-01-04
 */
@Service
public class TagServiceImpl extends AbstractBaseServiceImpl<Tag, TagDTO> implements TagService {

	@Autowired
	private ITagDao tagDao;

	@Override
	public Function<? super TagDTO, ? extends Tag> getDTO2DOMapper() {
		return tagDTO -> {
			Tag tag = new Tag();
			tag.setTagId(tagDTO.getTagId());
			tag.setTagName(tagDTO.getTagName());
			tag.setTagAvatar(tagDTO.getTagAvatar());
			tag.setTagContent(tagDTO.getTagContent());
			tag.setTagState(tagDTO.getTagState());
			tag.setCreateDate(DateUtils.string2Date(tagDTO.getCreateDate(), DateUtils.FORMAT_DATETIME));
			tag.setUpdateDate(DateUtils.string2Date(tagDTO.getUpdateDate(), DateUtils.FORMAT_DATETIME));
			return tag;
		};
	}

	@Override
	public Function<? super Tag, ? extends TagDTO> getDO2DTOMapper() {
		return tagDO -> {
			TagDTO tagDTO = new TagDTO();
			tagDTO.setTagId(tagDO.getTagId());
			tagDTO.setTagName(tagDO.getTagName());
			tagDTO.setTagAvatar(tagDO.getTagAvatar());
			tagDTO.setTagContent(tagDO.getTagContent());
			tagDTO.setTagState(tagDO.getTagState());
			tagDTO.setCreateDate(DateUtils.formatDateTime(tagDO.getCreateDate()));
			tagDTO.setUpdateDate(DateUtils.formatDateTime(tagDO.getUpdateDate()));
			return tagDTO;
		};
	}

	@Override
	public BaseDao<Tag> getDao() {
		return tagDao;
	}

}
