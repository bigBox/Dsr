package com.dj.serverplayer.handler;

import com.dj.domain.GlobalRoleID;
import com.dj.domain.config.*;
import com.dj.domain.constant.ConstantGame;
import com.dj.domain.data.MonthCard;
import com.dj.domain.data.Verify;
import com.dj.domain.entity.player.*;
import com.dj.domain.entity.player.item.PlayerItem5;
import com.dj.domain.entity.player.task.PlayerTask1;
import com.dj.domain.enums.PlayerAttrEnum;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.enums.TaskState;
import com.dj.domain.type.AccessType;
import com.dj.domain.util.*;
import com.dj.domain.util.codec.Md5Utils;
import com.dj.domain.util.codec.Sha;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.domain.util.math.RandomUtil;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.buffer.EDrawTodayType;
import com.dj.protobuf.buffer.MonthCardDrawReq;
import com.dj.protobuf.buffer.MonthCardNtf;
import com.dj.protobuf.character.*;
import com.dj.protobuf.common.BaseRoleInfo;
import com.dj.protobuf.common.ERoleFiveEle;
import com.dj.protobuf.datetime.DateTime;
import com.dj.protobuf.item.ItemInteractHistory;
import com.dj.protobuf.item.ItemInteractHistoryRsp;
import com.dj.protobuf.login.*;
import com.dj.protobuf.server.ReadPlayerItemRsp;
import com.dj.protobuf.task.ETaskType;
import com.dj.serverapi.AntiAddictionClient;
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.constant.ResponseCode;
import com.dj.serverapi.dao.*;
import com.dj.serverapi.dao.task.PlayerTask1Dao;
import com.dj.serverapi.helper.OnlineHelper;
import com.dj.serverapi.helper.OnlineRole;
import com.dj.serverapi.kernel.ClientConfig;
import com.dj.serverapi.kernel.ClientContext;
import com.dj.serverapi.model.*;
import com.dj.serverapi.redis.CommonRedis;
import com.dj.serverapi.sensitiveword.SensitivewordFilter;
import com.dj.servercore.Checker;
import com.dj.servercore.conf.*;
import com.dj.servercore.db.cache.CacheManager;
import com.dj.servercore.server.SocketServer;
import com.dj.servercore.server.base.AbsServer;
import com.dj.servercore.spring.SpringContext;
import com.dj.serverplayer.handler.base.BaseHandler;
import com.dj.serverplayer.helper.QueueHelper;
import com.dj.serverplayer.manager.ChannelManager;
import com.dj.serverplayer.manager.ConfManager;
import com.dj.serverplayer.manager.EventManager;
import com.dj.serverplayer.manager.ServiceManager;
import com.dj.serverplayer.server.PlayerServer;
import com.dj.serverplayer.server.PlayerRobotInit;
import com.dj.serverplayer.worker.MeetEggWorker;
import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonObject;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20210111.SmsClient;
import com.tencentcloudapi.sms.v20210111.models.PullSmsSendStatusRequest;
import com.tencentcloudapi.sms.v20210111.models.PullSmsSendStatusResponse;
import com.tencentcloudapi.sms.v20210111.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20210111.models.SendSmsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;

import static jodd.util.ThreadUtil.sleep;

/**
 * @author zcq
 * @description ?????????????????????
 * @date 2019???3???29???
 */
@Slf4j
@Component
public class InitHandler extends BaseHandler {
    @Autowired
    @Qualifier("playerCacheManager")
    public CacheManager playerCacheManager;
    @Autowired
    @Qualifier("robotCacheManager")
    public CacheManager robotCacheManager;
    @Autowired
    public FriendHandler friendHandler;
    @Autowired
    public ItemHandler itemHandler;
    @Autowired
    public RobHandler robHandler;

    private AntiAddictionClient antiAddictionClient;

    public InitHandler() {
         playerService.logPlayerName();
        ClientContext clientContext = ClientContext.builder
                .aClientContext()
                .appId("3b461800c9614109a9bbda662365a1c6")
                .bizId("1108009471")
                .secretKey("ba99bbccd9ffc945cde2feff5e5a6691")
                .build();

        ClientConfig clientConfig = ClientConfig.builder
                .aClientConfig()
                .ignoreSSL(true)
                .connectTimeout(4000)
                .readTimeout(4000)
                .maxRetry(1)
                .build();
        antiAddictionClient = new AntiAddictionClient(clientContext,clientConfig);
    }

    /**
     *	????????????
     * @param gateServerID ??????id
     * @param req
     * @param ip ??????ip
     * @return
     */
    public PlayerAccount createPlayer(int gateServerID, CreateAccountReq req, String ip) {
    	if(req.getAccount().length() < 2) {
    		throw new CommonException(ErrorID.PLAYER_NAME_LENGTH_SHORT);
    	}
    	String account = req.getAccount().toLowerCase();
        if (!Checker.isValidAccountName(account)) {
            throw new CommonException(ErrorID.INPUT_WORD_IS_NOT_RIGHT);
        }
        if (SensitivewordFilter.isContainSensitiveWord(account)) {
            throw new CommonException(ErrorID.PLAYER_NAME_IS_ILLEGAL);
        }
        //if(!Checker.isValidNickName(req.getNickname())) {
        //	throw new CommonException(ErrorID.INPUT_WORD_IS_NOT_RIGHT);
        //}
        if(SensitivewordFilter.isContainSensitiveWord(req.getNickname())) {
            throw new CommonException(ErrorID.INPUT_WORD_IS_ILLEGAL);
        }
        //if(!IdCardUtil.isValid(req.getIdCard())) {
        //	throw new CommonException(ErrorID.IDCARD_ERROR);
        //}
        //String ai = Md5Utils.md5To32(account);
        //AuthenticationCheckRequest checkRequest = new AuthenticationCheckRequest();
        //checkRequest.setAi(ai);
        //checkRequest.setIdNum(req.getIdCard());
        //checkRequest.setName(req.getName());
        //Response response = antiAddictionClient.authenticationCheck(checkRequest);
        //if(response == null){
        //    throw new CommonException(ErrorID.SYSTEM_REQUEST_ERROR);
        //}
        //if(response.getErrcode() != ResponseCode.OK.getCode()){
        //    log.error(response.getErrmsg());
        //    throw new CommonException(ErrorID.SYSTEM_REQUEST_ERROR);
        //}
        //int status = response.getData().getResult().getStatus();
        //if(status == 1) {
        //    sleep(5000);
        //    AuthenticationQueryRequest queryRequest = new AuthenticationQueryRequest();
        //    queryRequest.setAi(ai);
        //    response = antiAddictionClient.authenticationQuery(queryRequest);
        //    if (response == null) {
        //        throw new CommonException(ErrorID.SYSTEM_REQUEST_ERROR);
        //    }
        //    if(response.getErrcode() != ResponseCode.OK.getCode()){
        //        log.error(response.getErrmsg());
        //        throw new CommonException(ErrorID.SYSTEM_REQUEST_ERROR);
        //    }
        //    status = response.getData().getResult().getStatus();
        //}
        //if(status == 2) {
        //    log.error(response.getErrmsg());
        //    throw new CommonException(ErrorID.IDCARD_ERROR);
        //}
        //String pi = response.getData().getResult().getPi();
        String channel = AbsServer.getServerConfig().getTag();
        // ????????????
        PlayerAccount playerAccount = playerAccountDao.createAccount(req, ip, channel);
        if(playerAccount == null){
            log.error("createPlayer playerAccount conf == null");
            throw new CommonException(ErrorID.SYSTEM_REQUEST_ERROR);
        }
        // ???????????????????????????
        //int age = IdCardUtil.getAge(req.getIdCard());
        //int age = 20;
        // ????????????
        int fiveEle = RandomUtil.nextInt(1, 5);
        // ????????????
        PlayerRole role = playerRoleDao.createRole(playerAccount.getId(), PlayerAttrEnum.LEVEL.getDefaultValue(), playerAccount.getNickname(), channel, gateServerID, fiveEle);
        if(role != null) {
            // ????????????redis
            playerService.createPlayer(role);
            // ???????????????
            playerFactoryDao.initFactory(role.getRoleID());
            // ???????????????
            buffService.updateMonthCardTime(role.getRoleID(), 0);
            //?????????????????????
            SpringContext.getBean(PlayerRobotInit.class).init(role.getRoleID());
            // ??????????????????
            EventManager.postRegisterEvent(req.getAccount(), req.getPassword(), role.getRoleID());
        }
        return playerAccount;
    }

    /**
     *	????????????
     * @param gateServerID ??????id
     * @param req
     * @return
     */
    public PlayerAccount realNameCertification(int gateServerID, RealNameAuthReq req) {
        if(req.getAccount().length() < 2) {
            log.error("realNameCertification gateServerID = :{}", gateServerID);
            throw new CommonException(ErrorID.PLAYER_NAME_LENGTH_SHORT);
        }
        String account = req.getAccount().toLowerCase();
        if (!Checker.isValidAccountName(account) || SensitivewordFilter.isContainSensitiveWord(account)) {
            log.error("realNameCertification account == null");
            throw new CommonException(ErrorID.INPUT_WORD_IS_ILLEGAL);
        }
        if(req.getName().length() < 2 || !Checker.isValidRealName(req.getName()) || SensitivewordFilter.isContainSensitiveWord(req.getName())) {
            throw new CommonException(ErrorID.ACCOUNT_NAME_ERROR);
        }
        if(!IdCardUtil.isValid(req.getIdCard())) {
            throw new CommonException(ErrorID.IDCARD_ERROR);
        }
        // ??????????????????
        PlayerAccount playerAccount = null;
        List<PlayerAccount>list = playerAccountDao.getAccountFromDB(account, null);
        if (list == null || list.size() == 0) {
            throw new CommonException(ErrorID.ACCOUNT_PASS_ERROR, "account:"+account+", password:"+req.getPassword());
        }
        String shaPassword = Sha.getPassword(req.getPassword());
        for (PlayerAccount tmp : list) {
            if (tmp.getPassword().equals(shaPassword)) {
                playerAccount = tmp;
                break;
            }
        }
        if (playerAccount == null) {
            log.error("realNameCertification playerAccount == null");
            throw new CommonException(ErrorID.ACCOUNT_PASS_ERROR, "account:"+account+", password:"+req.getPassword());
        }

        // ??????????????????
        List<PlayerAccount> list1 = playerAccountDao.getAccountFromDB(null, req.getIdCard());
        if (list1 != null && list1.size() > 0) {
            throw new CommonException(ErrorID.IDCARD_ERROR, "account:"+account+", password:"+req.getPassword());
        }

        if((playerAccount.getPi() != null) && (!playerAccount.getPi().isEmpty())) {
            throw new CommonException(ErrorID.COMMON_DATA_ERROR);
        }

        String ai = Md5Utils.md5To32(Md5Utils.md5To32(account));
        AuthenticationCheckRequest checkRequest = new AuthenticationCheckRequest();
        checkRequest.setAi(ai);
        checkRequest.setIdNum(req.getIdCard());
        checkRequest.setName(req.getName());
        Response response = antiAddictionClient.authenticationCheck(checkRequest);
        if(response == null){
            log.error("realNameCertification response == null");
            throw new CommonException(ErrorID.SYSTEM_REQUEST_ERROR);
        }
        if(response.getErrcode() != ResponseCode.OK.getCode().intValue()){
            log.error(response.getErrmsg());
            throw new CommonException(ErrorID.SYSTEM_REQUEST_ERROR);
        }
        int status = response.getData().getResult().getStatus();
        if(status == 1) {
            sleep(5000);
            AuthenticationQueryRequest queryRequest = new AuthenticationQueryRequest();
            queryRequest.setAi(ai);
            response = antiAddictionClient.authenticationQuery(queryRequest);
            if (response == null) {
                throw new CommonException(ErrorID.SYSTEM_REQUEST_ERROR);
            }
            if(response.getErrcode() != ResponseCode.OK.getCode().intValue()){
                log.error(response.getErrmsg());
                throw new CommonException(ErrorID.SYSTEM_REQUEST_ERROR);
            }
            status = response.getData().getResult().getStatus();
        }
        if(status == 2) {
            log.error(response.getErrmsg());
            throw new CommonException(ErrorID.IDCARD_ERROR);
        }
        String pi = response.getData().getResult().getPi();
        String si = Md5Utils.md5To32(System.currentTimeMillis()+"");
        playerAccount.setName(req.getName());
        playerAccount.setIdCard(req.getIdCard());
        playerAccount.setAge(IdCardUtil.getAge(req.getIdCard()));
        playerAccount.setAi(ai);
        playerAccount.setPi(pi);
        playerAccount.setSi(si);
        playerAccountDao.cacheUpdate(playerAccount, playerAccount.getId());
        return playerAccount;
    }
    /**
     *	????????????
     * @param gateServerID ??????id
     * @param req
     * @param ip	??????ip
     * @return
     */
    public void loginPlayer(int gateServerID, UserLoginReq req, UserLoginRsp.Builder builder, String ip, String channelID) {
        String account = req.getAccount().toLowerCase();
        PlayerAccount playerAccount = playerAccountDao.cacheLoad("account", account, 0l);
        if(req.getPlatformType() == 0) {
            //??????????????????????????????
            if (playerAccount == null) {
                List<PlayerAccount> list = playerAccountDao.getAccountFromDB(account, null);
                if (list == null || list.size() == 0) {
                    log.error("loginPlayer list == null error! ???????????????!  account == {}", account);
                    throw new CommonException(ErrorID.ACCOUNT_PASS_ERROR, "account:"+account+", password:"+req.getPassword());
                }
                String shaPassword = Sha.getPassword(req.getPassword());
                for (PlayerAccount tmp : list) {
                    if (tmp.getPassword().equals(shaPassword)) {
                        playerAccount = tmp;
                        break;
                    }
                }
                if (playerAccount == null) {
                    log.error("loginPlayer playerAccount == null error! ??????????????????!  account == {}", account);
                    throw new CommonException(ErrorID.ACCOUNT_PASS_ERROR, "account:"+account+", password:"+req.getPassword());
                }
            }else{
                String shaPassword = Sha.getPassword(req.getPassword());
                if(!shaPassword.equalsIgnoreCase(playerAccount.getPassword())){
                    log.error("loginPlayer error! req.getPassword() != playerAccount.getPassword() ??????????????????!  account == {}", account);
                    throw new CommonException(ErrorID.ACCOUNT_PASS_ERROR, "account:"+account+", password:"+req.getPassword());
                }
            }
            // ??????????????????
            playerAccount.setFirstLoginFlag(playerAccount.getLastLoginTime() == null);
            // ?????????????????????
            if (playerAccount.getLastLoginTime() == null || !DateUtil.isToday(playerAccount.getLastLoginTime().getTime())) {
                EventManager.postTaskActionEvent(playerAccount.getId(), TaskActionEnum.ACTIVE_DAY, 1);
            }
            playerAccount.setLastLoginIp(ip);
            playerAccount.setLastLoginTime(DateUtil.getCurrentDate());
            if((playerAccount.getPi() != null) && (!playerAccount.getPi().isEmpty())) {
                String si = Md5Utils.md5To32(System.currentTimeMillis() + "");
                BehaviorLoginOutItem item = new BehaviorLoginOutItem();
                item.setNo(1);
                item.setSi(si);
                item.setBt(1);
                item.setOt(System.currentTimeMillis() / 1000);
                item.setCt(0);
                item.setDi("");
                item.setPi(playerAccount.getPi());
                BehaviorLoginOutListRequest     request     = new BehaviorLoginOutListRequest();
                ArrayList<BehaviorLoginOutItem> collections = new ArrayList<>();
                collections.add(item);
                request.setCollections(collections);
                Response response = antiAddictionClient.behaviorLoginOut(request);
                if (response == null) {
                    throw new CommonException(ErrorID.SYSTEM_REQUEST_ERROR);
                }
                if (response.getErrcode() != ResponseCode.OK.getCode().intValue()) {
                    log.error(response.getErrmsg());
                    throw new CommonException(ErrorID.SYSTEM_REQUEST_ERROR);
                }
                playerAccount.setSi(si);
            }
            playerAccountDao.cacheUpdate(playerAccount, playerAccount.getId());

            PlayerRole playerRole = playerService.getPlayer(playerAccount.getId());
            if(playerRole == null) {
                playerRole = playerRoleDao.cacheLoad("roleID",playerAccount.getId(), playerAccount.getId());
                if (playerRole != null) {
                    // ????????????redis
                    playerService.setPlayer(playerAccount.getId(), playerRole);
                }
            }
        }else{
            if (playerAccount == null) {
                List<PlayerAccount> list = playerAccountDao.getAccountFromDB(account, null);
                if (list == null || list.size() == 0) {
                    String channel = AbsServer.getServerConfig().getTag();
                    // ????????????
                    if (account.equals(GlobalRoleID.getXiaoXunRoleName())) {
                        throw new CommonException(ErrorID.ACCOUNT_IS_EXITS);
                    }
                    // ????????????????????????
                    long roleID = GlobalRoleID.getRobot();
                    if (!account.equals("robot")) {
                        roleID = CommonRedis.getInstance().getAtomicRoleId();
                    }
                    playerAccount = new PlayerAccount(roleID, account, req.getPassword(), req.getUserInfo().getNickname(), ip, channel);
                    // ??????????????????
                    playerAccount.setFirstLoginFlag(playerAccount.getLastLoginTime() == null);
                    // ?????????????????????
                    if (playerAccount.getLastLoginTime() == null || !DateUtil.isToday(playerAccount.getLastLoginTime().getTime())) {
                        EventManager.postTaskActionEvent(playerAccount.getId(), TaskActionEnum.ACTIVE_DAY, 1);
                    }
                    playerAccount.setLastLoginIp(ip);
                    playerAccount.setLastLoginTime(DateUtil.getCurrentDate());
                    playerAccountDao.cacheInsert(playerAccount, roleID);
                    PlayerUserInfo playerUserInfo = new PlayerUserInfo(playerAccount.getId(), req.getUserInfo());
                    playerUserInfoDao.cacheInsert(playerUserInfo, playerAccount.getId());
                    // ????????????
                    int fiveEle = RandomUtil.nextInt(1, 5);
                    // ????????????
                    PlayerRole playerRole = playerRoleDao.createRole(playerAccount.getId(), PlayerAttrEnum.LEVEL.getDefaultValue(), playerAccount.getNickname(), channel, gateServerID, fiveEle);
                    if (playerRole != null) {
                        // ????????????redis
                        playerService.createPlayer(playerRole);
                        // ???????????????
                        playerFactoryDao.initFactory(playerRole.getRoleID());
                        // ???????????????
                        buffService.updateMonthCardTime(playerRole.getRoleID(), 0);
                        // ??????????????????????????????
                        //itemHandler.initNewRoleItem(playerRole.getRoleID());
                        // ???????????????????????????
                        //playerFarmDao.initNewRoleFarm(playerRole.getRoleID());
                        // ???????????????????????????????????????
                        //Map<Integer, Integer> moneyMap = playerShowTableDao.initNewRoleShowTableItem(playerRole.getRoleID());
                        // ??????????????????
                        //PlayerShowTableMoney showTableMoney = playerShowTableMoneyDao.createPlayerShowTableMoney(playerRole.getRoleID(), moneyMap);
                        //addShowTable(playerRole.getRoleID(), showTableMoney.getTotalMoney(), ResourceBillEnum.firstLogin);
                        //playerRole.setShowTable(showTableMoney.getTotalMoney());
                        // ?????????????????????
                        //playerVerifyDao.initNewRoleGuideVerify(role.getRoleID());
                        //?????????????????????
                        SpringContext.getBean(PlayerRobotInit.class).init(playerRole.getRoleID());
                        // ??????????????????
                        EventManager.postRegisterEvent(req.getAccount(), req.getPassword(), playerRole.getRoleID());
                    }
                } else {
                    playerAccount = list.get(0);
                    playerAccount.setPassword(Sha.getPassword(req.getPassword()));
                    // ??????????????????
                    playerAccount.setFirstLoginFlag(playerAccount.getLastLoginTime() == null);
                    // ?????????????????????
                    if (playerAccount.getLastLoginTime() == null || !DateUtil.isToday(playerAccount.getLastLoginTime().getTime())) {
                        EventManager.postTaskActionEvent(playerAccount.getId(), TaskActionEnum.ACTIVE_DAY, 1);
                    }
                    playerAccount.setLastLoginIp(ip);
                    playerAccount.setLastLoginTime(DateUtil.getCurrentDate());
                    playerAccountDao.cacheUpdate(playerAccount, playerAccount.getId());
                    PlayerRole playerRole = playerService.getPlayer(playerAccount.getId());
                    if(playerRole == null) {
                        playerRole = playerRoleDao.cacheLoad("roleID",playerAccount.getId(), playerAccount.getId());
                        if (playerRole != null) {
                            // ????????????redis
                            playerService.setPlayer(playerAccount.getId(), playerRole);
                        }
                    }
                }
            }else {
                // ??????????????????
                playerAccount.setPassword(Sha.getPassword(req.getPassword()));
                playerAccount.setFirstLoginFlag(playerAccount.getLastLoginTime() == null);
                // ?????????????????????
                if (playerAccount.getLastLoginTime() == null || !DateUtil.isToday(playerAccount.getLastLoginTime().getTime())) {
                    EventManager.postTaskActionEvent(playerAccount.getId(), TaskActionEnum.ACTIVE_DAY, 1);
                }
                playerAccount.setLastLoginIp(ip);
                playerAccount.setLastLoginTime(DateUtil.getCurrentDate());
                playerAccountDao.cacheUpdate(playerAccount, playerAccount.getId());
                PlayerRole playerRole = playerService.getPlayer(playerAccount.getId());
                if(playerRole == null) {
                    playerRole = playerRoleDao.cacheLoad("roleID",playerAccount.getId(), playerAccount.getId());
                    if (playerRole != null) {
                        // ????????????redis
                        playerService.setPlayer(playerAccount.getId(), playerRole);
                    }
                }
            }
        }
        // ???????????????id
        PlayerRole playerRole = playerService.setLoginServerID(playerAccount.getId(), gateServerID, SocketServer.getServerConfig().getId());
        if(playerRole != null){
            // ??????????????????
            if (playerAccount.getLastLoginTime() != null && !DateUtil.isToday(playerAccount.getLastLoginTime().getTime())) {
                playerRole.setTodayOnline(0);
                playerRole.setCrossLogin(true);
            }
        }else {
            throw new CommonException(ErrorID.SYSTEM_ERROR);
        }
        // ???????????????
        if(((playerAccount.getPi() != null) && (!playerAccount.getPi().isEmpty()))
                &&(!playerAccount.isFirstLoginFlag())&&(playerAccount.getAge() < 18)) {
            // ??????????????????????????????????????????20-21???????????????????????????2021??????????????????????????????
            boolean isGameDay = ServiceProvider.getHolidayService().isPlayGameDayTime(System.currentTimeMillis());
            if(!isGameDay){
                throw new CommonException(ErrorID.ADDICTION_LIMIT_TIME);
            }
        }
        // ?????????????????????
        playerCacheManager.activateCache(playerAccount.getId());
        robotCacheManager.activateCache(playerAccount.getId());
        // ????????????
        if (playerAccount.isFirstLoginFlag()) {
        	builder.setFirstLogin(true);
            firstLogin(playerRole);
        }else {
        	// ????????????
        	if(playerRole.isCrossLogin()) {
        		taskHandler.flushDayTask(playerRole.getRoleID(), playerRole.getLevel());
        	}
        	builder.setFirstLogin(false);
        }
        if((playerRole.getGuideTaskId() < 10001)
                &&(playerRole.getGuideTaskState() < TaskState.complete.getState())
                &&(!playerAccount.isFirstLoginFlag())) {
            playerRole = playerService.updateGuideTaskState(playerRole.getRoleID(), playerRole.getGuideTaskId(), TaskState.noAccept.getState());
            playerTask1Dao.resetTaskInfo(playerRole.getGuideTaskId(), playerRole.getRoleID());
        }
        if(playerAccount.getPi()==null || playerAccount.getPi().isEmpty()){
            if (AbsServer.getServerConfig().isFormal()) {
                if (playerAccount.getAccount().equalsIgnoreCase("1-8")
                        || playerAccount.getAccount().equalsIgnoreCase("8-16")
                        || playerAccount.getAccount().equalsIgnoreCase("16-18")
                        || playerAccount.getAccount().equalsIgnoreCase("gaoji")) {
                    builder.setIsNeedCert(false);
                    builder.setAge(playerAccount.getAge());
                } else {
                    builder.setIsNeedCert(true);
                    builder.setAge(1);
                }
            }else {
                playerAccount.setAge(20);
                playerAccountDao.cacheUpdate(playerAccount, playerAccount.getId());
                builder.setIsNeedCert(false);
                builder.setAge(playerAccount.getAge());
            }
        }else {
            builder.setIsNeedCert(false);
            builder.setAge(playerAccount.getAge());
        }
        builder.setErrorID(ErrorID.OK);
        builder.setPlatformType(req.getPlatformType());
        builder.setAccount(playerAccount.getAccount());
        builder.setRoleID(playerAccount.getId());
        builder.setRoleName(playerAccount.getNickname());
        builder.setGmlevel(0);
        builder.setCreateRoleTime(DateTime.newBuilder().setValue(playerAccount.getRegisterTime().getTime()));
        builder.setZoneId(0);
        builder.setSignature(playerRole.getSignature());
        builder.setGrowUpTaskID(commonService.getAcceptTypeTask(playerAccount.getId(), ETaskType.GrowUp_VALUE));

        builder.setFiveEle(ERoleFiveEle.forNumber(playerRole.getFiveEle()));
        builder.setGuideID(playerRole.getGuideId());
        builder.setGuideState(playerRole.getGuideState());
        builder.setIsNeedUpdate(false);
        builder.setGuildID(playerRole.getGuildId());
        // ??????????????????
        repairLoginData(playerRole);
        if (!account.equals(GlobalRoleID.getAdmin())) {
            // ??????????????????
            EventManager.postLoginEvent(playerAccount.getAccount(), req.getPassword(), ip, playerAccount.getId(), playerRole, true, channelID);
            //WechatUtil.writeLoginMsg(AbsServer.getServerConfig().getTag(), account, req.getPassword(), ip, playerAccount.getRoleID());
            log.info("account:{}, ip:{}, roleID:{}, type:login", account, ip, playerAccount.getId());
        }
        if(playerRole.getGuildId() > 0) {
            EventManager.postTaskActionEvent(playerRole.getRoleID(), TaskActionEnum.HAS_GUILD, 1);
            EventManager.commitRoleEvent(playerRole.getRoleID());
        }
    }

    /**
     *	????????????
     * @param gateServerID ??????id
     * 
     */
    public void reLoginPlayer(int gateServerID, String account, String password, ReloginRsp.Builder builder, String ip, String channelID) {
        log.info("account:{}, password:{}", account, password);
        PlayerAccount playerAccount = playerAccountDao.loginAccount(account, password, ip);
        if (playerAccount == null) {
            log.error("reLoginPlayer playerAccount == null");
            throw new CommonException(ErrorID.SYSTEM_REQUEST_ERROR);
        }
        if((playerAccount.getPi() != null) && (!playerAccount.getPi().isEmpty())) {
            String si = Md5Utils.md5To32(System.currentTimeMillis() + "");
            BehaviorLoginOutItem item = new BehaviorLoginOutItem();
            item.setNo(1);
            item.setSi(si);
            item.setBt(1);
            item.setOt(System.currentTimeMillis() / 1000);
            item.setCt(0);
            item.setDi("");
            item.setPi(playerAccount.getPi());
            BehaviorLoginOutListRequest request = new BehaviorLoginOutListRequest();
            ArrayList<BehaviorLoginOutItem> collections = new ArrayList<>();
            collections.add(item);
            request.setCollections(collections);
            Response response = antiAddictionClient.behaviorLoginOut(request);
            if (response == null) {
                throw new CommonException(ErrorID.SYSTEM_REQUEST_ERROR);
            }
            if (response.getErrcode() != ResponseCode.OK.getCode().intValue()) {
                log.error(response.getErrmsg());
                throw new CommonException(ErrorID.SYSTEM_REQUEST_ERROR);
            }
            playerAccount.setSi(si);
            playerAccountDao.cacheUpdate(playerAccount, playerAccount.getId());
        }
        // ?????????????????????
        playerCacheManager.activateCache(playerAccount.getId());
        robotCacheManager.activateCache(playerAccount.getId());
        // ???????????????id
        PlayerRole playerRole = playerService.setLoginServerID(playerAccount.getId(), gateServerID, SocketServer.getServerConfig().getId());
        if(playerRole == null){
            throw new CommonException(ErrorID.SYSTEM_ERROR);
        }else {
            // ??????????????????
            if (playerAccount.getLastLoginTime() != null && !DateUtil.isToday(playerAccount.getLastLoginTime().getTime())) {
                playerRole.setTodayOnline(0);
                playerRole.setCrossLogin(true);
            }
        }
        playerRoleDao.cacheUpdate(playerRole);
        // ????????????
        if (playerAccount.isFirstLoginFlag()) {
            firstLogin(playerRole);
        }else {
        	// ????????????
        	if(playerRole.isCrossLogin()) {
        		taskHandler.flushDayTask(playerRole.getRoleID(), playerRole.getLevel());
        	}
        	// ??????????????????
            repairLoginData(playerRole);
        }
        builder.setRoleId(playerAccount.getId());
        builder.setRoleName(playerAccount.getNickname());
        
        // ??????????????????
        EventManager.postLoginEvent(playerAccount.getAccount(), password, ip, playerAccount.getId(), playerRole, false, channelID);
        log.info("account:{}, password:{}, ip:{}, roleID:{}, type:relogin", account, password, ip, playerAccount.getId());
    }

    /**
     *	???????????????
     *
     * @param playerRole
     */
    private void firstLogin(PlayerRole playerRole) {
        // ??????????????????????????????
        itemHandler.initNewRoleItem(playerRole.getRoleID());
        // ???????????????????????????
        playerFarmDao.initNewRoleFarm(playerRole.getRoleID());
        // ?????????????????????
        //playerVerifyDao.initNewRoleGuideVerify(playerRole.getRoleID());
        // ???????????????
        taskHandler.flushLevelTask(playerRole.getRoleID(), playerRole.getLevel());
        // ???????????????????????????????????????
        Map<Integer, Integer> moneyMap = playerShowTableDao.initNewRoleShowTableItem(playerRole.getRoleID());
        // ??????????????????
        PlayerShowTableMoney showTableMoney = playerShowTableMoneyDao.createPlayerShowTableMoney(playerRole.getRoleID(), moneyMap);
        addShowTable(playerRole.getRoleID(), showTableMoney.getTotalMoney(), ResourceBillEnum.firstLogin);
        playerRole.setShowTable(showTableMoney.getTotalMoney());

        List<PlayerShowTableInfo> showTableInfoList = playerShowTableInfoDao.initNewRoleShowTableInfo(playerRole.getRoleID());
        if(showTableInfoList != null) {
            for (PlayerShowTableInfo showTableInfo : showTableInfoList) {
                showTableService.setShowTableInfo(playerRole.getRoleID(), showTableInfo);
            }
        }
    }

    /**
     *	??????????????????
     */
    private void repairLoginData(PlayerRole playerRole) {
        long roleID = playerRole.getRoleID();
        List<PlayerVerify> queues = playerVerifyDao.cacheLoadAll(roleID);
        int verifyQueueCount = ConfigSundryConf.verifyQueueCount;
        if (queues != null && queues.size() < verifyQueueCount) {
            // ??????????????????
            for (int i = queues.size(); i < verifyQueueCount; i++) {
                PlayerVerify playerVerify = new PlayerVerify(roleID);
                //playerVerify.setId(readModuleID(TableID.TABLE_VERIFY));
                playerVerifyDao.cacheInsert(playerVerify, roleID);
            }
        }
        List<Verify> items = verifyService.getVerifyList(roleID);
        if (items == null || items.size() == 0) {
            List<PlayerItem5> items5 = playerItem5Dao.cacheLoadAll(roleID);
            if(items5 != null && items5.size() > 0) {
                verifyService.initNewRoleVerify(roleID, items5);
            }
        }
        // ?????????????????? ????????????????????????
        if(PlayerServer.getServerConfig().isJsonUpdate()&&(playerRole.getRepairCount() == 0)) {
        	// ??????????????????
        	ConfigFactoryConf conf = ConfManager.getInstance().getConfigFactoryConf();
            if(conf == null){
                throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
            }
        	ImmutableMap<Integer, ConfigFactory> factoryMap = conf.getFactoryMap();
    		for (ConfigFactory config : factoryMap.values()) {
                if(config.getShowLevel() == 0) {
                    QueryParamMap queryParams = new QueryParamMap();
                    queryParams.put("roleID", roleID);
                    queryParams.put("factoryID", config.getID());
                    PlayerFactory playerFactory = playerFactoryDao.cacheSelect(queryParams, playerRole.getRoleID());
                    if (playerFactory == null) {
                        playerFactory = new PlayerFactory(roleID);
                        playerFactory.setFactoryID(config.getID());
                        playerFactory.setShowLevel(config.getShowLevel());
                        playerFactory.setPointX(config.getX());
                        playerFactory.setPointY(config.getY());
                        playerFactoryDao.cacheInsert(playerFactory, roleID);
                    } else if (playerFactory.getPointX() != config.getX() || playerFactory.getPointY() != config.getY()) {
                        playerFactory.setPointX(config.getX());
                        playerFactory.setPointY(config.getY());
                        playerFactoryDao.cacheUpdate(playerFactory, playerRole.getRoleID());
                    }
                }
    		}
    		// ??????redis??????????????????
            List<PlayerFactory> playerFactories = playerFactoryDao.cacheLoadAll(playerRole.getRoleID());
            if(playerFactories != null && playerFactories.size() > 0) {
                gameService.setFactory(playerRole.getRoleID(), playerFactories);
            }
        	// ????????????
            //buffService.repairMonthCard(playerRole.getRoleID());
    		// ????????????
            //bookHandler.repairBook(playerRole.getRoleID());
        	
        	// ??????????????????
            playerRole.setRepairCount(playerRole.getRepairCount()+1);
            playerRoleDao.cacheUpdate(playerRole);
            playerService.setPlayer(playerRole.getRoleID(), playerRole);
        }
    }

    /**
     * gm??????
     *
     * @param roleID
     * @param cmd
     */
	public void gmCommandHandler(long roleID, String cmd) {
        if (AbsServer.getServerConfig().isFormal()) {
            // ?????????????????????gm??????
            log.error("gmCommandHandler roleID == {}", roleID);
            throw new CommonException(ErrorID.SYSTEM_SERVICE_DOWN);
        }
        String[] arr = cmd.split(" ");
        String str = arr[0].toLowerCase();
        if (str.equals("levelup")) {// ??????
            int level = arr.length > 1 ? Integer.parseInt(arr[1]) : 1;
            PlayerRole role = playerService.getPlayer(roleID);
            level = level + role.getLevel();
            if (level > 101) {
                level = 101;
            }
            ConfigExpLevelCfgConf conf = ConfManager.getInstance().getConfigExpLevelCfgConf();
            if(conf == null){
                throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
            }
            ConfigExpLevelCfg cfg = conf.getExpLevelCfg(level);
            int exp = (int) (cfg.getUpLevelTotalExp() - role.getExperience());
            addExp(roleID, exp, ResourceBillEnum.gmItem);
            playerTask1Dao.flushLevelTask(roleID, level);
        }
        else if (str.equals("level")) {// ??????????????????
            int level = arr.length > 1 ? Integer.parseInt(arr[1]) : 1;
            PlayerRole role = playerService.getPlayer(roleID);
            ConfigExpLevelCfgConf conf = ConfManager.getInstance().getConfigExpLevelCfgConf();
            if(conf == null){
                throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
            }
            ConfigExpLevelCfg cfg = conf.getExpLevelCfg(level);
            role.setLevel(level);
            Double ddDouble = Double.valueOf(cfg.getUpLevelTotalExp());
            role.setExperience(ddDouble.intValue());
            playerService.setPlayer(roleID, role);
            playerRoleDao.cacheUpdate(role);
            EventManager.postPlayerAttrEvent(roleID, PlayerAttrEnum.EXP, role.getExperience());
            EventManager.postPlayerAttrEvent(roleID, PlayerAttrEnum.LEVEL, role.getLevel());
            EventManager.postPlayerLevelUpEvent(roleID, role.getLevel(), role.getLevel());
            playerTask1Dao.flushLevelTask(roleID, level);
        }
        else if (str.equals("renown") || str.equals("addrenown")) {// ??????
            int level = arr.length > 1 ? Integer.parseInt(arr[1]) : 1;
            PlayerRole role = playerService.getPlayer(roleID);
            level = level + role.getRenownLevel();
            ConfigReputationLevelConf conf = ConfManager.getInstance().getConfigReputationLevelConf();
            if(conf == null){
                throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
            }
            ConfigReputationLevel config = conf.getReputationLevel(level);
            int renown = (int) (config.getUpLevelTotalExp() - role.getRenown());
            //addRenown(roleID, renown, ResourceBillEnum.gmItem);
        }
        else if (str.equals("item") || str.equals("additem")) {// ????????????
            if(arr.length == 3 ) {
                int itemID = Integer.parseInt(arr[1]);
                int count = Integer.parseInt(arr[2]);
                if (count > 0) {
                    addItem(roleID, itemID, count, ResourceBillEnum.gmItem, true);
                } else {
                    costItem(roleID, itemID, -count, ResourceBillEnum.gmItem);
                }
            }
        }
        else if (str.equals("exp") || str.equals("addexp")) {// ????????????
            if(arr.length == 2 ) {
                int exp = Integer.parseInt(arr[1]);
                addExp(roleID, exp, ResourceBillEnum.gmItem);
            }
        }
        else if (str.equals("monthcard")) {// ????????????
            if(arr.length == 2 ) {
                int month = Integer.parseInt(arr[1]);
                MonthCard monthCard = buffService.updateMonthCardTime(roleID, month);
                MonthCardNtf.Builder builder = MonthCardNtf.newBuilder();
                int leftSeconds = DateUtil.secondsBetween(DateUtil.getCurrentDate(), new Date(monthCard.getEndTime()));
                builder.setLeftSeconds(leftSeconds);
                builder.setIsDrawedToday(monthCard.isDrawedToday());
                PlayerRole role = playerService.getPlayer(roleID);
                ChannelManager.getInstance().sendPlayerSingleToGate(role.getGateServerID(), role.getRoleID(), builder.build());
            }
        }
        else if (str.equals("gold") || str.equals("addgold")) {// ????????????
            if(arr.length == 2 ) {
                int count = Integer.parseInt(arr[1]);
                addGold(roleID, count, ResourceBillEnum.gmItem);
            }
        }
        else if (str.equals("diamond") || str.equals("adddiamond")) {// ????????????
            if(arr.length == 2 ) {
                int count = Integer.parseInt(arr[1]);
                addDiamond(roleID, count, ResourceBillEnum.gmItem);
            }
        }
        else if (str.equals("stamina")) {
            if(arr.length == 2 ) {
                PlayerRole role = playerService.getPlayer(roleID);
                int count = Integer.parseInt(arr[1]);
                long stamina = role.getStamina() - count;
                if (stamina > 0) {
                    costStamina(roleID, stamina, ResourceBillEnum.gmItem);
                } else {
                    addStamina(roleID, -stamina, ResourceBillEnum.gmItem);
                }
            }
        }
        else if(str.equals("superman")) { // ?????????
        	gmCommandHandler(roleID, "level 60");
        	gmCommandHandler(roleID, "gold 1000000");
        	gmCommandHandler(roleID, "diamond 10000");
            Timer timer = new Timer();// ?????????Timer???
            timer.schedule(new TimerTask() {
                public void run() {
                    gmCommandHandler(roleID, "jump all");
                    this.cancel();
                }
            }, 1000);// ???????????????
        	//itemHandler.addSupermanItem(roleID);
        }
        else if (str.equals("jump")) {
            PlayerRole role = playerService.getPlayer(roleID);
            if(arr.length == 2 ) {
                if(arr[1].equals("all")){
                    List<PlayerTask1> tasks = playerTask1Dao.cacheLoadAll(roleID);
                    if((tasks != null)&&(tasks.size() > 0)) {
                        tasks.forEach(playerTask -> {
                            if (playerTask.getState() < TaskState.complete.getState()) {
                                playerTask.setState(TaskState.complete.getState());
                                playerTask1Dao.cacheUpdate(playerTask, roleID);
                            }
                        });
                    }
                    role = playerService.updateGuideTaskState(role.getRoleID(), 10028, TaskState.complete.getState());
                    playerRoleDao.cacheUpdate(role);
                }else {
                    int curTaskId = Integer.parseInt(arr[1]);
                    List<PlayerTask1> tasks = playerTask1Dao.cacheLoadAll(roleID);
                    if((tasks != null)&&(tasks.size() > 0)) {
                        tasks.forEach(playerTask -> {
                            if ((playerTask.getTaskID() <= curTaskId)&&(playerTask.getState() < TaskState.complete.getState())) {
                                playerTask.setState(TaskState.complete.getState());
                                playerTask1Dao.cacheUpdate(playerTask, roleID);
                            }
                        });
                    }
                    role = playerService.updateGuideTaskState(role.getRoleID(), curTaskId, TaskState.complete.getState());
                    playerRoleDao.cacheUpdate(role);
                }
            }
        }
        else if(str.equals("full")){
            if(arr.length == 2 ) {
                int count = Integer.parseInt(arr[1]);
                addAllItems(roleID, count);
            }
        }
        else if(str.equals("addall")){
            if(arr.length == 2 ) {
                int count = Integer.parseInt(arr[1]);
                ConfigItemsConf itemsConf = ConfManager.getInstance().getConfigItemsConf();
                if(itemsConf == null){
                    throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
                }
                Map<Integer, ConfigItems> itemMap = itemsConf.getItemMap();
                for(Map.Entry<Integer, ConfigItems> entry : itemMap.entrySet()) {
                    addItem(roleID, entry.getKey(), count, ResourceBillEnum.addAllItem, true, false);
                }
                List<PlayerItem5> items5 = playerItem5Dao.cacheLoadAll(roleID);
                if(items5 != null && items5.size() > 0) {
                    verifyService.initNewRoleVerify(roleID, items5);
                }
            }
        }
    }

    /**
     *	??????
     *
     * @param roleID
     * @param name   ?????????
     */
    public void changeName(long roleID, String name) {
        if (name.length() > 40) {
            throw new CommonException(ErrorID.INPUT_WORD_IS_TOO_LONG);
        }
        if (name.length() < 2) {
            throw new CommonException(ErrorID.INPUT_WORD_IS_TOO_SHORT);
        }
        if (!Checker.isValidNickName(name)) {
            throw new CommonException(ErrorID.INPUT_WORD_IS_NOT_RIGHT);
        }
        if (SensitivewordFilter.isContainSensitiveWord(name)) {
            throw new CommonException(ErrorID.INPUT_WORD_IS_ILLEGAL);
        }
        if (playerService.checkExitName(name)) {  // redis????????????
            throw new CommonException(ErrorID.PLAYER_NAME_IS_EXITS);
        }

        // 2023???2???3??? 15:10:58  ????????????????????????????????????
        PlayerAccount playerAccount = playerAccountDao.cacheLoad("id", roleID, roleID);
        if (playerAccount == null) {
            log.error("logout playerAccount == null");
            throw new CommonException(ErrorID.SYSTEM_REQUEST_ERROR);
        }
        // ??????account??????????????????
        playerAccount.setNickname(name);  // ????????????
        playerAccountDao.cacheUpdate(playerAccount, playerAccount.getId());  //

        // ???????????????
        //costItem(roleID, ConstantGame.CHANGE_NAME_CARD, 1, ResourceBillEnum.changeName, false);
        PlayerRole playerRole = playerService.changeName(roleID, name);
        playerRoleDao.cacheUpdate(playerRole);  // ????????????????????????

    }

    /**
     *	????????????
     *
     * @param roleID
     * @param signature
     */
    public void changeSignature(long roleID, String signature) {
        if (signature.length() > 200) {
            throw new CommonException(ErrorID.PLAYER_SIGNATURE_IS_TOO_LONG);
        }
        if (signature.length() < 2) {
            throw new CommonException(ErrorID.PLAYER_SIGNATURE_IS_TOO_SHORT);
        }
        //if (!Checker.isValidNickName(signature)) {
        //    throw new CommonException(ErrorID.PLAYER_SIGNATURE_IS_NOT_RIGHT);
        //}
        if (SensitivewordFilter.isContainSensitiveWord(signature)) {
            throw new CommonException(ErrorID.INPUT_WORD_IS_ILLEGAL);
        }
        signature = SensitivewordFilter.replaceSensitiveWord(signature);
        PlayerRole playerRole = playerService.changeSignature(roleID, signature);
        playerRoleDao.cacheUpdate(playerRole);
    }
    
    /**
     * 	???????????????
     * @param word
     */
    public void checkWord(String word, CheckWordRsp.Builder builder) {
    	// ??????????????????????????????
    	if(SensitivewordFilter.isContainSensitiveWord(word)) {
    		word = SensitivewordFilter.replaceSensitiveWord(word);
    		builder.setWord(word);
    		throw new CommonException(ErrorID.INPUT_WORD_IS_ILLEGAL);
    	}
    	builder.setWord(word);
    }

    /**
     *	??????????????????
     *
     * @param roleID
     * @param builder
     */
    public void monthCard(long roleID, MonthCardNtf.Builder builder) {
        MonthCard monthCard = buffService.getMonthCard(roleID);
        if (monthCard.getEndTime() < System.currentTimeMillis()) {
            builder.setLeftSeconds(0);
        } else {
            int leftSeconds = DateUtil.secondsBetween(DateUtil.getCurrentDate(), new Date(monthCard.getEndTime()));
            builder.setLeftSeconds(leftSeconds);
        }
        builder.setIsDrawedToday(monthCard.isDrawedToday());
        builder.setIsMonthCardDrawedToday(monthCard.isMonthCardDrawedToday());
    }

    /**
     *	??????????????????
     *
     * @param roleID
     */
    public void monthCardDraw(long roleID, MonthCardDrawReq req) {
    	// ????????????????????????
    	ConfigMonthCardConf conf = ConfManager.getInstance().getConfigMonthCardConf();
        if(conf == null){
            log.error("monthCardDraw ConfigMonthCardConf conf == null");
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
    	ConfigMonthCard config = conf.getMonthCard(1);
    	// ????????????????????????
		MonthCard monthCard = buffService.getMonthCard(roleID);
        if (req.getType() == EDrawTodayType.Login) {
        	// ????????????
        	if(monthCard.isDrawedToday()) {
        		throw new CommonException(ErrorID.REWARD_RECEIVED);
        	}
        	addItem(roleID, config.getItem1(), 2, ResourceBillEnum.monthCardDraw, false);
        	addItem(roleID, config.getItem2(), 2, ResourceBillEnum.monthCardDraw, false);
        	addItem(roleID, config.getItem3(), 0, ResourceBillEnum.monthCardDraw, false);
        }else if (req.getType() == EDrawTodayType.MonthCard) {
        	// ??????????????????
        	if(monthCard.isMonthCardDrawedToday()) {
        		throw new CommonException(ErrorID.REWARD_RECEIVED);
        	}
        	if (monthCard.getEndTime() < System.currentTimeMillis()) {
        		throw new CommonException(ErrorID.REWARD_DRAW_NEED_MONTH_CARD);
        	}
        	// ????????????
        	addItem(roleID, config.getItem1(), config.getItem1Num(), ResourceBillEnum.monthCardDraw, false);
        	addItem(roleID, config.getItem2(), config.getItem2Num(), ResourceBillEnum.monthCardDraw, false);
        	addItem(roleID, config.getItem3(), config.getItem3Num(), ResourceBillEnum.monthCardDraw, false);
        }
        buffService.updateMonthCardDraw(roleID, req.getType(), true);
    }

    /**
     *	????????????
     *
     * @param roleID
     */
    public void logout(long roleID) {
        PlayerAccount playerAccount = playerAccountDao.cacheLoad("id", roleID, roleID);
        if (playerAccount == null) {
            log.error("logout playerAccount == null");
            throw new CommonException(ErrorID.SYSTEM_REQUEST_ERROR);
        }
        if((playerAccount.getPi() != null) && (!playerAccount.getPi().isEmpty())) {
            BehaviorLoginOutItem item = new BehaviorLoginOutItem();
            item.setNo(1);
            item.setSi(playerAccount.getSi());
            item.setBt(0);
            item.setOt(System.currentTimeMillis() / 1000);
            item.setCt(0);
            item.setDi("");
            item.setPi(playerAccount.getPi());
            BehaviorLoginOutListRequest request = new BehaviorLoginOutListRequest();
            ArrayList<BehaviorLoginOutItem> collections = new ArrayList<>();
            collections.add(item);
            request.setCollections(collections);
            Response response = antiAddictionClient.behaviorLoginOut(request);
            if (response == null) {
                throw new CommonException(ErrorID.SYSTEM_REQUEST_ERROR);
            }
            if (response.getErrcode() != ResponseCode.OK.getCode().intValue()) {
                log.error(response.getErrmsg());
                throw new CommonException(ErrorID.SYSTEM_REQUEST_ERROR);
            }
        }
    	if(OnlineHelper.getInstance().checkOnline(roleID)) {
    		OnlineHelper.getInstance().removeOnline(roleID);
            // ??????????????????
    		PlayerRole playerRole = playerService.getPlayer(roleID);
            if (playerAccount.getLastLoginTime() != null) {
                Date nowDate = DateUtil.getCurrentDate();
                int onlineSeconds = DateUtil.secondsBetween(playerAccount.getLastLoginTime(), nowDate);
                if (onlineSeconds > 0) {
                    // ???????????????
                    playerRole.setTotalOnline(playerRole.getTotalOnline() + onlineSeconds);
                    // ??????????????????
                    if (DateUtil.isToday(playerAccount.getLastLoginTime().getTime())) {
                        playerRole.setTodayOnline(playerRole.getTodayOnline() + onlineSeconds);
                    } else {
                        // ???????????????????????????0???????????????????????????
                        Date todayStart = DateUtil.getDateBegin(nowDate);
                        onlineSeconds = DateUtil.secondsBetween(todayStart, nowDate);
                        if (onlineSeconds > 0) {
                            playerRole.setTodayOnline(onlineSeconds);
                        }
                    }
                }
            }
            playerRole.setOnline(false);
            playerRoleDao.cacheUpdate(playerRole);
            playerService.setPlayer(roleID, playerRole);
            // ?????????????????????
            MeetEggWorker.getWorker().removeRoom(roleID, null);
            // ????????????
            QueueHelper.getInstance().removeQueue(roleID);
            // ????????????
//            robHandler.removeRoleRob(roleID);
            // ????????????
            OnlineRole onlineRole = OnlineHelper.getInstance().removeOnline(roleID);
            if (onlineRole != null && StringUtil.isNotEmpty(onlineRole.getAccount())) {
                log.info("account:{}, password:{}, ip:{}, roleID:{}, type:logout", onlineRole.getAccount(), onlineRole.getPassword(), onlineRole.getIp(), roleID);
            }
            //WechatUtil.writeLogoutMsg(AbsServer.getServerConfig().getTag(), playerRole.getRoleName(), roleID, (int)Math.ceil(onlineSeconds/60d));
    	}
    }

    /**
     *	??????????????????
     *
     * @param roleID
     * @param builder
     */
    @SuppressWarnings("rawtypes")
	public void readPlayerItem(long roleID, int itemID, ReadPlayerItemRsp.Builder builder) {
        long count = ServiceManager.getItemService().getItemCount(roleID , itemID);
        builder.setData(String.valueOf(count));
    }

    /**
     *	?????????????????????
     *
     * @param roleID
     * @param req
     */
    public void changeClientData(long roleID, ChangeClientDataReq req) {
        commonService.changeClientData(roleID, req.getKey(), req.getValue());
    }

    /**
     *	????????????????????????
     * @param roleID
     * @param req
     */
	public void usePowerBarAddStamina(long roleID, UsePowerBarAddStaminaReq req) {
		costItem(roleID, ConstantGame.POWER_BAR, req.getCount(), ResourceBillEnum.usePowerBarAddStamina);
		addStamina(roleID, req.getCount()*1000, ResourceBillEnum.usePowerBarAddStamina);
	}

	/**
	 * ?????????????????????????????????
	 * @param roleID
	 * @param builder
	 */
	public void itemInteractHistory(long roleID, ItemInteractHistoryRsp.Builder builder) {
		List<PlayerItemInteractHistory> histories = playerItemInteractHistoryDao.cacheLoadAll(roleID);
		if(histories != null && histories.size() > 0) {
            int countLimit   = 20;
            ItemInteractHistory.Builder history = ItemInteractHistory.newBuilder();
            BaseRoleInfo.Builder baseRoleInfo = BaseRoleInfo.newBuilder();
            for (int i = histories.size() - 1; i >= 0; i--) {
                PlayerItemInteractHistory playerItemInteractHistory = histories.get(i);
                PlayerRole role = playerService.getPlayer(playerItemInteractHistory.getInteractRoleID());
                builder.addHistories(playerItemInteractHistory.toItemInteractHistory(history, role.toBaseRoleInfo(baseRoleInfo)));
                if (builder.getHistoriesCount() >= countLimit) {
                    break;
                }
            }
        }
	}

	/**
	 * ????????????????????????
	 * @param roleID
	 * @param type
	 * @param builder
	 */
	public void leaveHistory(long roleID, int type, LeaveHistoryRsp.Builder builder) {
		List<PlayerLeaveHistory> histories = playerLeaveHistoryDao.cacheLoadAll(roleID);
        if(histories != null && histories.size() > 0) {
            int countLimit = 20;
            LeaveHistory.Builder history = LeaveHistory.newBuilder();
            for (int i = histories.size() - 1; i >= 0; i--) {
                PlayerLeaveHistory playerLeaveHistory = histories.get(i);
                if(playerLeaveHistory.getType() == type) {
                    builder.addHistories(playerLeaveHistory.toLeaveHistory(history));
                    if (builder.getHistoriesCount() >= countLimit) {
                        break;
                    }
                }
            }
        }
	}

    public void gmShutdownCmdReq() {
        List<Long> roleIds = playerService.getAllPlayerRoleIds();
        for(Long roleId : roleIds){
            logout(roleId);
        }
        playerService.disposeCache();
    }

    public void createSmsCode(CreateSmsCodeReq req, String ip) {
        String sms = String.valueOf(RandomUtil.nextInt(1001,9999));
        SmsCode smsCode = new SmsCode();
        smsCode.setCreateTime(DateUtil.getCurrentDate());
        smsCode.setUpdateTime(DateUtil.getCurrentDate());
        smsCode.setPhone(req.getPhoneNum());
        smsCode.setCode(sms);
        smsCode.setIp(ip);
        smsCodeDao.cacheInsert(smsCode, GlobalRoleID.getRobot());
        //????????????????????????????????????
        SendSms(req.getPhoneNum(), sms, "3", req.getType());
    }

    public void verifySmsCode(VerifySmsCodeReq req) {
        QueryParamMap queryParams = new QueryParamMap();
        queryParams.put("phone",req.getPhoneNum());
        queryParams.put("code",req.getSmsCode());
        List<SmsCode> smsCodes = smsCodeDao.selectList(queryParams, GlobalRoleID.getRobot(), AccessType.DIRECT_DB);
        if(smsCodes == null || smsCodes.size() == 0){
            throw new CommonException(ErrorID.INPUT_WORD_IS_ILLEGAL);
        }
    }

    public void resetPassword(ResetPasswordReq req) {
        List<PlayerAccount>list = playerAccountDao.getAccountFromDB(req.getAccount(), null);
        if (list == null || list.size() == 0) {
            throw new CommonException(ErrorID.SYSTEM_MYSQL_ERROR);
        }
        PlayerAccount playerAccount = list.get(0);
        playerAccount.setPassword(Sha.getPassword(req.getPassword()));
        playerAccountDao.cacheUpdate(playerAccount, playerAccount.getId());
    }

    public void SendSms(String phone, String sms, String time, int type) {
        try {
            /* ???????????????
             * ????????????????????????????????????????????????????????????????????????secretId???secretKey???
             * ???????????????????????????????????????????????????????????????????????????????????????????????????
             * ??????????????????????????????????????????????????????????????????????????????????????????????????????????????????
             * ????????????????????????????????????????????????
             * CAM????????????: https://console.cloud.tencent.com/cam/capi*/
            Credential cred = new Credential("AKIDxoQlpc9QRCixwe5GBpBI9wShgOpzsUqv", "qQjlW1FDuLWQ2OSGn21jBNJ0RbV8UaPx");
            // ???????????????http????????????????????????????????????????????????
            HttpProfile httpProfile = new HttpProfile();
            // ????????????
            // httpProfile.setProxyHost("????????????ip");
            // httpProfile.setProxyPort(??????????????????);
            /* SDK????????????POST?????????
             * ????????????????????????GET?????????????????????????????????GET??????????????????????????????????????? */
            httpProfile.setReqMethod("POST");
            /* SDK?????????????????????????????????????????????????????????
             * ???????????????????????????????????????????????????????????? */
            httpProfile.setConnTimeout(60);
            /* SDK???????????????????????????????????????????????????????????????????????????????????????????????????????????????
             * ????????????????????????????????????sms??????????????????????????? sms.ap-shanghai-fsi.tencentcloudapi.com */
            httpProfile.setEndpoint("sms.tencentcloudapi.com");
            /* ???????????????:
             * ???????????????????????????????????????????????????????????????????????? */
            ClientProfile clientProfile = new ClientProfile();
            /* SDK?????????TC3-HMAC-SHA256????????????
             * ???????????????????????????????????? */
            clientProfile.setSignMethod("HmacSHA256");
            clientProfile.setHttpProfile(httpProfile);
            /* ????????????????????????(???sms??????)???client??????
             * ????????????????????????????????????????????????????????????ap-guangzhou?????????????????????????????? */
            SmsClient client = new SmsClient(cred, "ap-nanjing",clientProfile);
            /* ??????????????????????????????????????????????????????????????????????????????????????????????????????
             * ?????????????????????SDK?????????????????????????????????????????????
             * ?????????????????????????????????????????????????????????????????????
             * ????????????IDE???????????????????????????????????????????????????????????????????????????????????? */
            SendSmsRequest req = new SendSmsRequest();
            /* ??????????????????,??????request?????????????????????????????????????????????
             * ?????????????????????????????????????????????request?????????????????????????????????????????????
             * ?????????????????????:
             * ???????????????
             * ???????????????: https://console.cloud.tencent.com/smsv2
             * sms helper: https://cloud.tencent.com/document/product/382/3773 */
            /* ????????????ID: ??????SdkAppId??? [???????????????] ??????????????????????????????SdkAppId????????????1400006666 */
            String sdkAppId = "1400243541";
            req.setSmsSdkAppId(sdkAppId);
            /* ??????????????????: ?????? UTF-8 ????????????????????????????????????????????????????????????????????? [???????????????] ?????? */
            String signName = "??????????????????";
            req.setSignName(signName);
            /* ??????/??????????????? SenderId: ???????????????????????????????????????????????????????????? [sms helper] */
            String senderid = "";
            req.setSenderId(senderid);
            /* ????????? session ??????: ????????????????????? ID ?????????????????????server ??????????????? */
            String sessionContext = "";
            req.setSessionContext(sessionContext);
            /* ?????????????????????: ??????????????????????????????????????? [sms helper] */
            String extendCode = "";
            req.setExtendCode(extendCode);
            /* ??????????????????????????? E.164 ?????????+[??????????????????][?????????]
             * ????????????+8613711112222??? ?????????????????????+??? ???86???????????????13711112222?????????????????????????????????200???????????? */
            String[] phoneNumberSet = {phone};
            req.setPhoneNumberSet(phoneNumberSet);
            /* ?????? ID: ???????????????????????????????????? ID?????????ID????????? [???????????????] ?????? */
            if(type == 0) {
                req.setTemplateId("1103531");
                /* ????????????: ???????????????????????????????????? */
                String[] templateParamSet = {sms,time};
                req.setTemplateParamSet(templateParamSet);
            }else if(type == 1){
                req.setTemplateId("1113280");
                /* ????????????: ???????????????????????????????????? */
                String[] templateParamSet = {sms};
                req.setTemplateParamSet(templateParamSet);
            }
            /* ?????? client ???????????? SendSms ?????????????????????????????????????????????????????????????????????
             * ????????? res ????????? SendSmsResponse ???????????????????????????????????? */
            SendSmsResponse res = client.SendSms(req);
            // ??????json????????????????????????
            System.out.println(SendSmsResponse.toJsonString(res));
            // ????????????????????????????????????????????????????????????????????????response?????????????????????????????????????????????
            //System.out.println(res.getRequestId());
            //PullSmsSendStatus();
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
    }

    public void PullSmsSendStatus() {
        try {
            /* ???????????????
             * ????????????????????????????????????????????????????????????????????????secretId???secretKey???
             * ???????????????????????????????????????????????????????????????????????????????????????????????????
             * ??????????????????????????????????????????????????????????????????????????????????????????????????????????????????
             * ????????????????????????????????????????????????
             * CAM????????????: https://console.cloud.tencent.com/cam/capi*/
            Credential cred = new Credential("AKIDxoQlpc9QRCixwe5GBpBI9wShgOpzsUqv", "qQjlW1FDuLWQ2OSGn21jBNJ0RbV8UaPx");

            // ???????????????http????????????????????????????????????????????????
            HttpProfile httpProfile = new HttpProfile();
            // ????????????
            // httpProfile.setProxyHost("????????????ip");
            // httpProfile.setProxyPort(??????????????????);
            /* SDK????????????POST?????????
             * ????????????????????????GET?????????????????????????????????GET??????????????????????????????????????? */
            httpProfile.setReqMethod("POST");
            /* SDK?????????????????????????????????????????????????????????
             * ???????????????????????????????????????????????????????????? */
            httpProfile.setConnTimeout(60);
            /* SDK???????????????????????????????????????????????????????????????????????????????????????????????????????????????
             * ????????????????????????????????????sms??????????????????????????? sms.ap-shanghai-fsi.tencentcloudapi.com */
            httpProfile.setEndpoint("sms.tencentcloudapi.com");

            /* ???????????????:
             * ???????????????????????????????????????????????????????????????????????? */
            ClientProfile clientProfile = new ClientProfile();
            /* SDK?????????TC3-HMAC-SHA256????????????
             * ???????????????????????????????????? */
            clientProfile.setSignMethod("HmacSHA256");
            clientProfile.setHttpProfile(httpProfile);

            /* ????????????????????????(???sms??????)???client??????
             * ????????????????????????????????????????????????????????????ap-guangzhou?????????????????????????????? */
            SmsClient client = new SmsClient(cred, "ap-nanjing", clientProfile);

            /* ??????????????????????????????????????????????????????????????????????????????????????????????????????
             * ?????????????????????SDK?????????????????????????????????????????????
             * ?????????????????????????????????????????????????????????????????????
             * ????????????IDE???????????????????????????????????????????????????????????????????????????????????? */
            PullSmsSendStatusRequest req = new PullSmsSendStatusRequest();

            /* ??????????????????,??????request?????????????????????????????????????????????
             * ?????????????????????????????????????????????request?????????????????????????????????????????????
             * ?????????????????????:
             * ???????????????
             * ???????????????: https://console.cloud.tencent.com/smsv2
             * sms helper: https://cloud.tencent.com/document/product/382/3773 */

            /* ????????????ID: ??????SdkAppId??? [???????????????] ??????????????????????????????SdkAppId????????????1400006666 */
            String sdkAppId = "1400243541";
            req.setSmsSdkAppId(sdkAppId);

            // ?????????????????????????????????100???
            Long limit = 5L;
            req.setLimit(limit);

            /* ?????? client ???????????? PullSmsSendStatus ?????????????????????????????????????????????????????????????????????
             * ????????? res ????????? PullSmsSendStatusResponse ???????????????????????????????????? */
            PullSmsSendStatusResponse res = client.PullSmsSendStatus(req);

            // ??????json????????????????????????
            System.out.println(PullSmsSendStatusResponse.toJsonString(res));

        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
    }
    //QQ???????????? /auth/qq_check_token
    //??????????????????https://ysdk.qq.com/auth/qq_check_token
    //??????????????????https://ysdktest.qq.com/auth/qq_check_token
    //?timestamp=&appid=&sig=&openid=&openkey=&userip
    // ?????????????????? /auth/wx_check_token
    //??????????????????https://ysdk.qq.com/auth/wx_check_token
    //??????????????????https://ysdktest.qq.com/auth/wx_check_token
    //?timestamp=&appid=&sig=&openid=&openkey=&userip
    public boolean verifyAccessToken(int platform, String openid, String openkey, String userip) {
        try {
            String appid = "1112028599";
            String timestamp = System.currentTimeMillis() / 1000 + "";
            String sig = Md5Utils.md5To32(openkey + timestamp);
            Map<String, String> paras = new HashMap<>();
            paras.put("timestamp", timestamp);
            paras.put("appid", appid);
            paras.put("sig", sig);
            paras.put("openid", openid);
            paras.put("openkey", openkey);
            paras.put("userip", userip);
            String response;
            if (platform == 1) {
                response = OkHttpUtil.get("https://ysdk.qq.com/auth/qq_check_token", paras);
            } else {
                response = OkHttpUtil.get("https://ysdk.qq.com/auth/wx_check_token", paras);
            }
            JsonObject resObj = GsonUtil.toJsonObject(response);
            if ("0".equalsIgnoreCase((String) GsonUtil.fromJson(resObj, "ret", String.class))) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            log.error(e.toString());
        }
        return false;
    }
}
