package com.dj.domain.constant;

public final class ConstantServer {

	public static final String defaultNettyServerConfig = "gate/netty-server-config.xml";

	public static final String defaultConnectServerConfig = "gate/connect-server-config.xml";

	public static final String defaultInnerServerConfig = "config/inner-server-config.xml";

	/**
	 * @Fields SUBMISSION_NUM_LOWER_LIMIT: 提交数值参数的下限
	 */
	public static final int SUBMIT_NUM_LOWER_LIMIT = 1;

	/**
	 * @Fields SUBMISSION_NUM_UPPER_LIMIT: 提交数值参数的上限
	 */
	public static final int SUBMIT_NUM_UPPER_LIMIT = 9999;
}
