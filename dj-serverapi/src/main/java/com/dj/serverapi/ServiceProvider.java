package com.dj.serverapi;

import com.dj.serverapi.service.*;
import com.dj.serverapi.service.inf.*;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

import com.dj.serverapi.redis.CommonRedis;
import com.dj.servercore.redis.base.BaseService;
import com.dj.servercore.service.ProxyFactory;
import com.dj.servercore.service.ServiceHandler;

import lombok.Getter;

public class ServiceProvider {

	private final static Objenesis OBJENESIS = new ObjenesisStd(true);

	/**
	 * 玩家
	 */
	@Getter
	protected static IPlayerService playerService = (IPlayerService) getProxyService(PlayerServiceImpl.class);
	/**
	 * 游戏：主页 ，荒地， 农场
	 */
	@Getter
	protected static IGameService gameService = (IGameService) getProxyService(GameServiceImpl.class);
	/**
	 * 挖矿
	 */
	@Getter
	protected static IGameMineService gameMineService = (IGameMineService) getProxyService(GameMineServiceImpl.class);
	/**
	 * 物品：处理物品流通， 道具5（收集品）， 鉴定相关， 道具来源
	 */
	@Getter
	protected static IItemService itemService = (IItemService) getProxyService(ItemServiceImpl.class);
	/**
	 * 排行
	 */
	@Getter
	protected static IRankService rankService = (IRankService) getProxyService(RankServiceImpl.class);
	/**
	 * 好友
	 */
	@Getter
	protected static IFriendService friendService = (IFriendService) getProxyService(FriendServiceImpl.class);
	/**
	 * 通用：处理玩具属性变化，客户端数据（页面打开次数）
	 */
	@Getter
	protected static ICommonService commonService = (ICommonService) getProxyService(CommonServiceImpl.class);
	/**
	 * buff
	 */
	@Getter
	protected static IBuffService buffService = (IBuffService) getProxyService(BuffServiceImpl.class);
	/**
	 * 展厅
	 */
	@Getter
	protected static IShowTableService showTableService = (IShowTableService) getProxyService(ShowTableServiceImpl.class);
	/**
	 * 商会
	 */
	@Getter
	protected static IGuildService guildService = (IGuildService) getProxyService(GuildServiceImpl.class);
	/**
	 * 交易
	 */
	@Getter
	protected static ITradeService tradeService = (ITradeService) getProxyService(TradeServiceImpl.class);
	/**
	 * 生态园
	 */
	@Getter
	protected static IParkService parkService = (IParkService) getProxyService(ParkServiceImpl.class);
	/**
	 * 单人接鸡蛋
	 */
	@Getter
	protected static IMeetEggSingleService meetEggSingleService = (IMeetEggSingleService) getProxyService(MeetEggSingleServiceImpl.class);
	/**
	 * 其他数据
	 */
	@Getter
	protected static IOtherService otherService = (IOtherService) getProxyService(OtherServiceImpl.class);
	/**
	 * 鉴定
	 */
	@Getter
	protected static IVerifyService verifyService = (IVerifyService) getProxyService(VerifyServiceImpl.class);
	/**
     * 精灵
     */
    @Getter
    protected static ISummonService summonService = (ISummonService) getProxyService(SummonServiceImpl.class);
	/**
	 * 节假日
	 */
	@Getter
	protected static IHolidayService holidayService = (IHolidayService) getProxyService(HolidayServiceImpl.class);

	/**
	 * 物品：处理物品流通， 道具5（收集品）， 鉴定相关， 道具来源
	 */
	@Getter
	protected static IPayService payService = (IPayService) getProxyService(PayServiceImpl.class);

	protected static Object getProxyService(Class<? extends BaseService> clz) {
		return ProxyFactory.getProxy(OBJENESIS.newInstance(clz), new ServiceHandler());
	}

	public static long readModuleID(String module) {
		return CommonRedis.getInstance().readModuleID(module);
	}
}
