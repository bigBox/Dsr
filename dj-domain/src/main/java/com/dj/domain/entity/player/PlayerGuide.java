package com.dj.domain.entity.player;

import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;
import com.dj.protobuf.guide.GuideInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PlayerGuide extends BaseEntity {
	private static final long serialVersionUID = 8373056600922118748L;

	public PlayerGuide(long roleID) {
		super(roleID);
	}

	private int guideId;

	private int state;

	private int arg;
	
	private String exData;

//	@Override
//	public String getPrimaryKeyName() {
//		return "guideId";
//	}
//
//	@Override
//	public Object getPrimaryKeyValue() {
//		return guideId;
//	}


	@Override
	public IEntity copy() {
		PlayerGuide item = new PlayerGuide();
		copySuper(item);
		item.setGuideId(guideId);
		item.setState(state);
		item.setArg(arg);
		item.setExData(exData);
		return item;
	}
	
	public GuideInfo toGuideInfo(GuideInfo.Builder builder) {
		builder.setGuideId(guideId);
		builder.setState(state);
		builder.setArg(arg);
		builder.setExData(exData);
		return builder.build();
	}
}