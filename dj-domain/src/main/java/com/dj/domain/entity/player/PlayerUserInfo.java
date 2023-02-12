package com.dj.domain.entity.player;

import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;
import com.dj.protobuf.login.WeChatUserInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PlayerUserInfo extends BaseEntity {
	private static final long serialVersionUID = -138624326927726478L;
	private String openId;
	private String unionId;
	private String nickname;
	private String sex;
	private Integer sexId;
	private String language;
	private String city;
	private String province;
	private String country;
	private String headImgUrl;

	private String remark;
	private Integer groupId;

//	@Override
//	public String getPrimaryKeyName() {
//		return "openId";
//	}
//
//	@Override
//	public Object getPrimaryKeyValue() {
//		return openId;
//	}

	@Override
	public IEntity copy() {
		PlayerUserInfo info = new PlayerUserInfo();
		copySuper(info);
		info.setOpenId(openId);
		info.setUnionId(unionId);
		info.setNickname(nickname);
		info.setSex(sex);
		info.setSexId(sexId);
		info.setLanguage(language);
		info.setCity(city);
		info.setProvince(province);
		info.setCountry(country);
		info.setHeadImgUrl(headImgUrl);
		info.setRemark(remark);
		info.setGroupId(groupId);
		return info;
	}

	public PlayerUserInfo(long roleID, WeChatUserInfo userInfo) {
		super(roleID);
		setOpenId(userInfo.getOpenid());
		setUnionId(userInfo.getUnionid());
		setNickname(userInfo.getNickname());
		setSexId(userInfo.getSex());
		if(userInfo.getSex() == 0) {
			setSex("女");
		}else{
			setSex("男");
		}
		setHeadImgUrl(userInfo.getHeadimgurl());
		setLanguage(userInfo.getLanguage());
		setCity(userInfo.getCity());
		setProvince(userInfo.getProvince());
		setCountry(userInfo.getCountry());
		setGroupId(0);
		setRemark("");
	}
}