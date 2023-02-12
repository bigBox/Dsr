package com.dj.bms.common.dto;

import com.dj.bms.common.enums.InsertReplyEnum;
import com.dj.bms.modules.comment.model.Comment;

/**
 * 存储添加评论的结果
 * @author zcq
 * 2018年5月25日
 * 下午8:49:11
 * TODO
 */
public class ReplyExecution {

	private String replyAuthorName;//当前回复用户昵称
	private int state;// 结果状态
	private String stateInfo;// 状态标识
	private Comment reply;//成功对象
	
	public ReplyExecution() {
		super();
	}
	
	/**
	 * 失败时的构造器
	 * @param replyAuthorId
	 * @param stateEnum
	 */
	public ReplyExecution(String replyAuthorName,InsertReplyEnum stateEnum) {
		this.replyAuthorName = replyAuthorName;
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}
	
	/**
	 * 成功时的构造器
	 * @param replyAuthorId
	 * @param stateEnum
	 * @param reply
	 */
	public ReplyExecution(String replyAuthorName,InsertReplyEnum stateEnum,Comment reply) {
		this.replyAuthorName = replyAuthorName;
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.reply = reply;
	}

	public String getReplyAuthorName() {
		return replyAuthorName;
	}

	public void setReplyAuthorName(String replyAuthorName) {
		this.replyAuthorName = replyAuthorName;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public Comment getReply() {
		return reply;
	}

	public void setReply(Comment reply) {
		this.reply = reply;
	}

	@Override
	public String toString() {
		return "RootReplyExecution [replyAuthorName=" + replyAuthorName + ", state=" + state + ", stateInfo="
				+ stateInfo + ", reply=" + reply + "]";
	}

	
}
