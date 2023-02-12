package com.dj.domain.entity.global;

import java.io.Serializable;
import java.util.Date;

import com.dj.domain.base.IEntity;
import com.dj.domain.util.DateUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GlobalGuild implements Serializable, IEntity {
    private static final long serialVersionUID = -6500694915114232088L;

    public GlobalGuild(long roleID) {
        setChairman(roleID);
        setLevel(1);
        setExperience(0);
        setScore(10);
        setCurMemberNums(1);
        setCreateTime(DateUtil.getCurrentDate());
        setUpdateTime(DateUtil.getCurrentDate());
    }

    private long id;

    /**
     *	名称
     */
    private String name;
    /**
     *	等级
     */
    private int level;

    /**
     *	经验
     */
    private int experience;

	/**
	 *	积分
	 */
	private int score;
    /**
     *	商会说明
     */
    private String summary;
    /**
     *	当前成员数
     */
    private int curMemberNums;
    /**
     *	商会内部说明
     */
    private String innerSummary;
    /**
     *	会长
     */
    private long chairman;
    /**
     *	是否自动批准
     */
    private int autoApproval;
    /**
     * @Field createTime : 记录创建时间
     */
    private Date createTime;

    /**
     * @Field updateTime : 记录更新时间
     */
    private Date updateTime;

    @Override
    public String getPrimaryKeyName() {
        return "id";
    }

    @Override
    public Object getPrimaryKeyValue() {
        return id;
    }

    @Override
    public IEntity copy() {
        GlobalGuild item = new GlobalGuild();
        item.setId(id);
        item.setName(name);
        item.setLevel(level);
        item.setExperience(experience);
        item.setSummary(summary);
        item.setCurMemberNums(curMemberNums);
        item.setInnerSummary(innerSummary);
        item.setChairman(chairman);
        item.setAutoApproval(autoApproval);
        item.setCreateTime(createTime);
        item.setUpdateTime(DateUtil.getCurrentDate());
        return item;
    }

}