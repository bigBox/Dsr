package com.dj.serverplayer.action;

import com.dj.protobuf.Module;
import com.dj.domain.entity.player.PlayerAccount;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.alipay.AliPayPreReq;
import com.dj.protobuf.alipay.AliPayPreRsp;
import com.dj.protobuf.alipay.AliPayQueryReq;
import com.dj.protobuf.alipay.AliPayQueryRsp;
import com.dj.protobuf.forward.ForwardPlayerInitReq;
import com.dj.protobuf.forward.ForwardPlayerInitRsp;
import com.dj.protobuf.forward.LogoutReq;
import com.dj.protobuf.login.*;
import com.dj.protobuf.server.ReadPlayerItemReq;
import com.dj.protobuf.server.ReadPlayerItemRsp;
import com.dj.protobuf.wxpay.WxPayQueryReq;
import com.dj.protobuf.wxpay.WxPayQueryRsp;
import com.dj.protobuf.wxpay.WxPrePayReq;
import com.dj.protobuf.wxpay.WxPrePayRsp;
import com.dj.servercore.action.base.BaseAction;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.action.base.IFieldHandler;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.serverplayer.handler.AliPayHandler;
import com.dj.serverplayer.handler.InitHandler;
import com.dj.serverplayer.handler.WxPayHandler;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.Utility;
import com.dj.domain.util.lib.DataPair;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageV3;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zcq
 * @ClassName: PlayerInitAction
 * @Description: 玩家初始化
 * @date 2019年6月25日
 */
@Data
@Slf4j
@EqualsAndHashCode(callSuper = false)
@IActionModule(module = Module.PLAYER_INIT)
public class PlayerInitAction extends BaseAction {

    @IFieldHandler
    private InitHandler   initHandler;
    @IFieldHandler
    private WxPayHandler  wxPayHandler;
    @IFieldHandler
    private AliPayHandler aliPayHandler;

    @IActionCmd(cmd = ProtobufCmd.SERVER_FORWARD_PLAYER_INIT_REQ)
    public Long forwardPlayerInitReq(MyMsg msg) {
        ForwardPlayerInitReq forward = msg.getContent(ForwardPlayerInitReq.class);
        long roleID = forward.getRoleID();
        try {
            String reqClz = forward.getReqClz();
            GeneratedMessageV3 req = (GeneratedMessageV3) Class.forName(reqClz).getMethod("parseFrom", ByteString.class).invoke(null, forward.getReq());
            log.debug("roleID 【{}】, req:{}, content:{}", roleID, req.getClass().getSimpleName(), StringUtil.msg2Json(req));
            GeneratedMessageV3 rspContent = null;
            String ps = "";
            if (req instanceof CreateSmsCodeReq) {
                // 玩家手机号注册获取验证码
                rspContent = createCodeReq((CreateSmsCodeReq) req, forward.getPs());
            }
            else if (req instanceof VerifySmsCodeReq) {
                // 手机短信验证码校验
                rspContent = verifySmsCodeReq((VerifySmsCodeReq) req);
            }
            else if (req instanceof ResetPasswordReq) {
                // 重置密码
                rspContent = resetPasswordReq((ResetPasswordReq) req);
            }
            else if (req instanceof CreateAccountReq) {
                // 玩家注册
                rspContent = createAccountReq(msg.getServerID(), (CreateAccountReq) req, forward.getPs());
                roleID = ((CreateAccountRsp) rspContent).getRoleID();
            }else if (req instanceof RealNameAuthReq) {
                // 实名认证
                rspContent = RealNameAuthReq(msg.getServerID(), (RealNameAuthReq) req);
                roleID = ((RealNameAuthRsp) rspContent).getRoleID();
            } else if (req instanceof UserLoginReq) {
                // 玩家登陆
                rspContent = userLoginReq(msg.getServerID(), (UserLoginReq) req, forward.getPs(), forward.getChannelID());
                roleID = ((UserLoginRsp) rspContent).getRoleID();
            } else if (req instanceof ReloginReq) {
                // 重新登录
                DataPair<GeneratedMessageV3, String> dataPair = reloginReq(msg.getServerID(), (ReloginReq) req, forward.getPs(), forward.getChannelID());
                rspContent = dataPair.getObj1();
                ps = dataPair.getObj2();
                roleID = ((ReloginRsp) rspContent).getRoleId();
            } else if (req instanceof LogoutReq) {
                // 玩家退出
                rspContent = logoutReq((LogoutReq) req);
            } else if (req instanceof WxPrePayReq) {
                // 微信支付
                rspContent = wechatPrePayReq(roleID, (WxPrePayReq) req);
            } else if (req instanceof WxPayQueryReq) {
                // 微信支付结果查询
                rspContent = wechatPayQueryReq(roleID, (WxPayQueryReq) req);
            } else if (req instanceof AliPayPreReq) {
                // 支付宝支付
                rspContent = aliPayPreReq(roleID, (AliPayPreReq) req);
            } else if (req instanceof AliPayQueryReq) {
                // 支付宝支付结果查询
                rspContent = aliPayQueryReq(roleID, (AliPayQueryReq) req);
            }
            if (rspContent != null) {
                ForwardPlayerInitRsp.Builder builder = msg.getResultBuilder(ForwardPlayerInitRsp.class);
                builder.setRoleID(roleID);
                builder.setRsp(rspContent.toByteString());
                builder.setRspClz(rspContent.getClass().getName());
                builder.setPs(ps);
                log.debug("roleID 【{}】, rsp:{}, content:{}", forward.getRoleID(), rspContent.getClass().getSimpleName(), StringUtil.msg2Json(rspContent));
            }
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
        }
        return roleID;
    }

    private GeneratedMessageV3 createCodeReq(CreateSmsCodeReq req, String ip) {
        CreateSmsCodeRsp.Builder builder = CreateSmsCodeRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            initHandler.createSmsCode(req, ip);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 玩家手机号验证码校验接口
    private GeneratedMessageV3 verifySmsCodeReq(VerifySmsCodeReq req) {
        VerifySmsCodeRsp.Builder builder = VerifySmsCodeRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            initHandler.verifySmsCode(req);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    private GeneratedMessageV3 resetPasswordReq(ResetPasswordReq req) {
        ResetPasswordRsp.Builder builder = ResetPasswordRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            initHandler.resetPassword(req);
        });
        builder.setErrorID(result);
        return builder.build();
    }
    // 玩家注册
    private GeneratedMessageV3 createAccountReq(int gateServerID, CreateAccountReq req, String ip) {
        CreateAccountRsp.Builder builder = CreateAccountRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            PlayerAccount playerAccount = initHandler.createPlayer(gateServerID, req, ip);
            builder.setRoleID(playerAccount.getId());
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 身份验证
    private GeneratedMessageV3 RealNameAuthReq(int gateServerID, RealNameAuthReq req) {
        RealNameAuthRsp.Builder builder = RealNameAuthRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            PlayerAccount playerAccount = initHandler.realNameCertification(gateServerID, req);
            builder.setRoleID(playerAccount.getId());
        });
        builder.setErrorID(result);
        return builder.build();
    }
    // 客户端发起支付
    public GeneratedMessageV3 wechatPrePayReq(long roleID, WxPrePayReq req) {
        WxPrePayRsp.Builder builder = WxPrePayRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            wxPayHandler.wxPrePay(roleID, req, builder);
        });
        builder.setAccount(req.getAccount());
        builder.setErrorID(result);
        return builder.build();
    }

    // 客户端发起支付
    public GeneratedMessageV3 wechatPayQueryReq(long roleID, WxPayQueryReq req) {
        WxPayQueryRsp.Builder builder = WxPayQueryRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            wxPayHandler.wxPayQuery(roleID, req, builder);
        });
        builder.setAccount(req.getAccount());
        builder.setErrorID(result);
        return builder.build();
    }

    private GeneratedMessageV3 aliPayPreReq(long roleID, AliPayPreReq req) {
        AliPayPreRsp.Builder builder = AliPayPreRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            aliPayHandler.aliPayPre(roleID, req, builder);
        });
        builder.setAccount(req.getAccount());
        builder.setErrorID(result);
        return builder.build();
    }

    private GeneratedMessageV3 aliPayQueryReq(long roleID, AliPayQueryReq req) {
        AliPayQueryRsp.Builder builder = AliPayQueryRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            aliPayHandler.aliPayQuery(roleID, req, builder);
        });
        builder.setAccount(req.getAccount());
        builder.setErrorID(result);
        return builder.build();
    }
    // 玩家登陆
    private GeneratedMessageV3 userLoginReq(int gateServerID, UserLoginReq req, String ip, String channelID) {
        UserLoginRsp.Builder builder = UserLoginRsp.newBuilder();
        builder.setReq(req);
        ErrorID result = handleService(() -> {
            builder.setAccount(req.getAccount());
            initHandler.loginPlayer(gateServerID, req, builder, ip, channelID);
        });
        builder.setErrorID(result);
        return builder.build();
    }

    // 重新登录
    private DataPair<GeneratedMessageV3, String> reloginReq(int gateServerID, ReloginReq req, String ip, String channelID) {
        ReloginRsp.Builder builder = ReloginRsp.newBuilder();
        ErrorID result = handleService(() -> {
            log.info(StringUtil.msg2Json(req));
            String reqAccount = req.getAccount().toLowerCase();
            initHandler.reLoginPlayer(gateServerID, reqAccount, req.getPassword(), builder, ip, channelID);
        });
        builder.setErrorID(result);
        return new DataPair<>(builder.build(), req.getAccount());
    }

    // 玩家退出
    public GeneratedMessageV3 logoutReq(LogoutReq req) {
        log.info("roleID {} ", req.getRoleID());
        if (req.getRoleID() > 0) {
            long roleID = req.getRoleID();
            initHandler.logout(roleID);
            initHandler.playerCacheManager.flushSyncAllData(roleID, true);
        }
        return null;
    }

    // 获取玩家道具
    @IActionCmd(cmd = ProtobufCmd.SERVER_READ_PLAYER_ITEM_REQ)
    public Long readPlayerItemReq(MyMsg msg) {
        ReadPlayerItemReq req = msg.getContent(ReadPlayerItemReq.class);
        log.info("roleID {}, itemID {}", req.getRoleID(), req.getItemID());
        ReadPlayerItemRsp.Builder builder = msg.getResultBuilder(ReadPlayerItemRsp.class);
        builder.setReq(req);
        handleService(() -> {
            initHandler.readPlayerItem(req.getRoleID(), req.getItemID(), builder);
        });
        return req.getRoleID();
    }
}
