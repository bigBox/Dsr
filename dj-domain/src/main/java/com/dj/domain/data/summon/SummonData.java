package com.dj.domain.data.summon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SummonData {
    private static final long serialVersionUID = 6371734526686585814L;

    private long roleID;
    /**
     *	精灵配表的ID
     */
    private int summonID;
    /**
     *	精灵五行属性 1金 2木 3水 4火 5土
     */
    private int element;
    /**
     * 是否是默认使用的精灵
     */
    private boolean defUsed;
    /**
     *	精灵等级
     */
    private int level;
    /**
     *	派出时间
     */
    private long sendTime;
    /**
     *	回来时间
     */
    //private long returnTime;
    /**
     *	上次发放邮件时间
     */
    private long lastMailTime;
    /**
     *	邮件
     */
    private List<SummonPackage> packages = new ArrayList<>();
    /**
     *	邮件周期（秒）
     */
    //private int mailCycle;
    /**
     * 是否可以投资
     */
    private boolean canInvest;
    /**
     * 投资奖励
     */
    private List<SummonInvest> investReward = new ArrayList<>();
    /**
     * 是否旅行结束
     */
    private boolean tourEnd;
    /**
     *	总邮包数量
     */
    private int allPackageCount;
    /**
     *	已经收到的邮包数量
     */
    private int revPackageCount;
    /**
     *	已经生成的投资邮包数量
     */
    private int investPackageCount;
    /**
     *	已经生成收到的普通邮包数量
     */
    private int commonPackageCount;
}

