package com.dj.protobuf;

/**
 * @author zcq
 * @description 处理模块
 * @date 2019年3月27日
 */
public enum Module {
    /**
     *	客户端
     */
    CLIENT,
    /**
     *	网关服务器
     */
    GATE_SERVER,
    // ---------------------------------------------------------
    /**
     *	玩家服务器
     */
    PLAYER_SERVER,
    /**
     *	玩家初始化
     */
    PLAYER_INIT,
    /**
     *	玩家基本
     */
    PLAYER_BASIC,
    /**
     *	玩家好友
     */
    PLAYER_FRIEND,
    /**
     *	玩家主页
     */
    PLAYER_HOME,
    /**
     *	单人游戏
     */
    PLAYER_SINGLE,
    /**
     *	玩家GM
     */
    PLAYER_GM,
    // ---------------------------------------------------------
    /**
     *	游戏服务器
     */
    GAME_SERVER,
    /**
     *	游戏主页
     */
    GAME_HOME,
    /**
     *	多人游戏
     */
    GAME_MULTI,
    /**
     *	生态园
     */
    GAME_PARK,
    /**
     *	小游戏
     */
    GAME_MINI,
    // --------------------------------------------------------
    /**
     *	全局服务器
     */
    GLOBAL_SERVER,
    /**
     *	排行榜，交易
     */
    GLOBAL_RANK,
    /**
     *	商会
     */
    GLOBAL_GUILD,
    /**
     *	商会战斗
     */
    GLOBAL_GUILD_BATTLE,
    // --------------------------------------------------------
    /**
     *	聊天
     */
    CHAT,
    /**
     *	微信支付
     */
    WECHAT_PAY;
}
