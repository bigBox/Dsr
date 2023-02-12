package com.dj.serverplayer.action;

import com.dj.domain.util.StringUtil;
import com.dj.domain.util.Utility;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.Module;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.city.*;
import com.dj.protobuf.forward.ForwardPlayerSingleReq;
import com.dj.protobuf.forward.ForwardPlayerSingleRsp;
import com.dj.protobuf.meetEgg.*;
import com.dj.protobuf.outside.*;
import com.dj.protobuf.park.*;
import com.dj.protobuf.rob.*;
import com.dj.servercore.action.base.BaseAction;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.action.base.IFieldHandler;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.serverplayer.handler.*;
import com.google.protobuf.GeneratedMessageV3;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: PlayerSingleAction
 * @Description: 单人游戏
 * @author zcq
 * @date 2019年6月25日
 */
@Data
@Slf4j
@EqualsAndHashCode(callSuper = false)
@IActionModule(module = Module.PLAYER_SINGLE)
@SuppressWarnings("deprecation")
public class PlayerSingleAction extends BaseAction {

	@IFieldHandler
	private RobHandler robHandler;
	@IFieldHandler
	private SingleHandler singleHandler;
	@IFieldHandler
	private TopicHandler topicHandler;
	@IFieldHandler
	private ParkHandler parkHandler;
	@IFieldHandler
	private MeetEggHandler meetEggHandler;
	@IFieldHandler
	private CityHandler cityHandler;

	@IActionCmd(cmd = ProtobufCmd.SERVER_FORWARD_PLAYER_SINGLE_REQ)
	public Long forwardPlayerSingleReq(MyMsg msg) {
		ForwardPlayerSingleReq forward = msg.getContent(ForwardPlayerSingleReq.class);
		try {
			GeneratedMessageV3 rspContent = doReqHandler(forward.getRoleID(), forward.getReqClz(), forward.getReq());
			if (rspContent != null) {
				ForwardPlayerSingleRsp.Builder builder = msg.getResultBuilder(ForwardPlayerSingleRsp.class);
				builder.setRoleID(forward.getRoleID());
				builder.setRsp(rspContent.toByteString());
				builder.setRspClz(rspContent.getClass().getName());
				log.debug("roleID 【{}】, rsp:{}, content:{}", forward.getRoleID(), rspContent.getClass().getSimpleName(), StringUtil.msg2Json(rspContent));
			}
		} catch (Exception e) {
			log.error(Utility.getTraceString(e));
		}
		return forward.getRoleID();
	}

	// 盗墓地图
	public GeneratedMessageV3 robMapReq(long roleID, RobMapReq req) {
		RobMapRsp.Builder builder = RobMapRsp.newBuilder();
		ErrorID result = handleService(() -> {
			robHandler.robJoinMap(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}
	
	// 挖去地貌表皮，漏出宝物， 开门也用这个协议
	public GeneratedMessageV3 robLookItemReq(long roleID, RobLookItemReq req) {
		RobLookItemRsp.Builder builder = RobLookItemRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			robHandler.robLookItem(roleID, req.getTargetX(), req.getTargetY(), builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 盗墓使用技能
	public GeneratedMessageV3 robUseSkillReq(long roleID, RobUseSkillReq req) {
		RobUseSkillRsp.Builder builder = RobUseSkillRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			robHandler.robUseSkill(roleID, req.getTargetX(), req.getTargetY(), req.getRobFlag(), builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 盗墓怪物碰撞
	public GeneratedMessageV3 robMonsterOnCollisionReq(long roleID, RobMonsterOnCollisionReq req) {
		RobMonsterOnCollisionRsp.Builder builder = RobMonsterOnCollisionRsp.newBuilder();
		ErrorID result = handleService(() -> {
			robHandler.robMonsterOnCollision(roleID, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}
	
	// 消灭毒虫
	public GeneratedMessageV3 robBombMonsterReq(long roleID, RobBombMonsterReq req) {
		RobBombMonsterRsp.Builder builder = RobBombMonsterRsp.newBuilder();
		ErrorID result = handleService(() -> {
		});
		builder.setErrorID(result);
		return builder.build();
	}

	public GeneratedMessageV3 robCompleteGuideReq(long roleID, RobCompleteGuideReq req) {
		RobCompleteGuideRsp.Builder builder = RobCompleteGuideRsp.newBuilder();
		ErrorID result = handleService(() -> {
			robHandler.robCompleteGuide(roleID);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 野外
	public GeneratedMessageV3 outsideReq(long roleID, OutsideReq req) {
		OutsideRsp.Builder builder = OutsideRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			singleHandler.outside(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 野外新手引导
	public GeneratedMessageV3 outsideGuideReq(long roleID, OutsideGuideReq req) {
		OutsideGuideRsp.Builder builder = OutsideGuideRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			singleHandler.outsideGuide(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 批量采集
	public GeneratedMessageV3 outsideBatchReq(long roleID, OutsideBatchReq req) {
		OutsideBatchRsp.Builder builder = OutsideBatchRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			singleHandler.outsideBatch(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

//	// 交易放入队列
//	public GeneratedMessageV3 tradeEnqueueReq(long roleID, TradeEnqueueReq req) {
//		TradeEnqueueRsp.Builder builder = TradeEnqueueRsp.newBuilder();
//		builder.setReq(req);
//		ErrorID result = handleService(() -> {
//			topicHandler.tradeEnqueue(roleID, req);
//		});
//		builder.setErrorID(result);
//		return builder.build();
//	}

//	// 交易买卖
//	public GeneratedMessageV3 tradeUseReq(long roleID, TradeUseReq req) {
//		TradeUseRsp.Builder builder = TradeUseRsp.newBuilder();
//		builder.setReq(req);
//		ErrorID result = handleService(() -> {
//			topicHandler.tradeUse(roleID, req);
//		});
//		builder.setErrorID(result);
//		return builder.build();
//	}

	// 放置庄稼
	public GeneratedMessageV3 parkPlaceCropsReq(long roleID, ParkPlaceCropsReq req) {
		ParkPlaceCropsRsp.Builder builder = ParkPlaceCropsRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			parkHandler.parkPlaceCrops(roleID, req);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 放置植物
	public GeneratedMessageV3 parkPlacePlantReq(long roleID, ParkPlacePlantReq req) {
		ParkPlacePlantRsp.Builder builder = ParkPlacePlantRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			parkHandler.parkPlacePlant(roleID, req);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 放置树木
	public GeneratedMessageV3 parkPlaceTreeReq(long roleID, ParkPlaceTreeReq req) {
		ParkPlaceTreeRsp.Builder builder = ParkPlaceTreeRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			parkHandler.parkPlaceTree(roleID, req);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 生态园放置动物
	public GeneratedMessageV3 parkPlaceAnimalReq(long roleID, ParkPlaceAnimalReq req) {
		ParkPlaceAnimalRsp.Builder builder = ParkPlaceAnimalRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			parkHandler.parkPlaceAnimal(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}
	// 动物园放置动物
	public GeneratedMessageV3 zooPlaceAnimalReq(long roleID, ZooPlaceAnimalReq req) {
		ZooPlaceAnimalRsp.Builder builder = ZooPlaceAnimalRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			parkHandler.zooPlaceAnimal(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}
	// 收获庄稼
	public GeneratedMessageV3 parkHarvestCropsReq(long roleID, ParkHarvestCropsReq req) {
		ParkHarvestCropsRsp.Builder builder = ParkHarvestCropsRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			parkHandler.parkHarvestCrops(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 收获植物
	public GeneratedMessageV3 parkHarvestPlantReq(long roleID, ParkHarvestPlantReq req) {
		ParkHarvestPlantRsp.Builder builder = ParkHarvestPlantRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			parkHandler.parkHarvestPlant(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 收获树木
	public GeneratedMessageV3 parkHarvestTreeReq(long roleID, ParkHarvestTreeReq req) {
		ParkHarvestTreeRsp.Builder builder = ParkHarvestTreeRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			parkHandler.parkHarvestTree(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 收获动物
	public GeneratedMessageV3 parkHarvestAnimalReq(long roleID, ParkHarvestAnimalReq req) {
		ParkHarvestAnimalRsp.Builder builder = ParkHarvestAnimalRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			parkHandler.parkHarvestAnimal(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 鱼塘放置鱼
	public GeneratedMessageV3 parkPlaceFishReq(long roleID, ParkPlaceFishReq req) {
		ParkPlaceFishRsp.Builder builder = ParkPlaceFishRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			parkHandler.parkPlaceFish(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 鱼塘收获鱼
	public GeneratedMessageV3 parkHarvestFishReq(long roleID, ParkHarvestFishReq req) {
		ParkHarvestFishRsp.Builder builder = ParkHarvestFishRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			parkHandler.parkHarvestFish(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 清除枯萎动物
	public GeneratedMessageV3 parkDrawHoneyReq(long roleID, ParkDrawHoneyReq req) {
		ParkDrawHoneyRsp.Builder builder = ParkDrawHoneyRsp.newBuilder();
		ErrorID result = handleService(() -> {
			parkHandler.parkDrawHoney(roleID, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 生态园动物喂食
	public GeneratedMessageV3 parkAnimalFeedReq(long roleID, ParkAnimalFeedReq req) {
		ParkAnimalFeedRsp.Builder builder = ParkAnimalFeedRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			parkHandler.parkAnimalFeed(roleID, req);
		});
		builder.setErrorID(result);
		return builder.build();
	}
	
	// 生态园结算
	public GeneratedMessageV3 parkDrawPrizeReq(long roleID, ParkDrawPrizeReq req) {
		ParkDrawPrizeRsp.Builder builder = ParkDrawPrizeRsp.newBuilder();
		ErrorID result = handleService(() -> {
			parkHandler.parkDrawPrize(roleID, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 加速收获生态园动物
	public GeneratedMessageV3 parkAnimalSpeedupReq(long roleID, ParkAnimalSpeedupReq req) {
		ParkAnimalSpeedupRsp.Builder builder = ParkAnimalSpeedupRsp.newBuilder();
		ErrorID result = handleService(() -> {
			parkHandler.parkAnimalSpeedup(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 加速收获生态园鱼
	public GeneratedMessageV3 parkFishSpeedupReq(long roleID, ParkFishSpeedupReq req) {
		ParkFishSpeedupRsp.Builder builder = ParkFishSpeedupRsp.newBuilder();
		ErrorID result = handleService(() -> {
			parkHandler.parkFishSpeedup(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 加速收获庄家/植物/树木
	public GeneratedMessageV3 parkPlantSpeedupReq(long roleID, ParkPlantSpeedupReq req) {
		ParkPlantSpeedupRsp.Builder builder = ParkPlantSpeedupRsp.newBuilder();
		ErrorID result = handleService(() -> {
			parkHandler.parkPlantSpeedup(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 开始接鸡蛋
	public GeneratedMessageV3 startMeetEggReq(long roleID, StartMeetEggReq req) {
		StartMeetEggRsp.Builder builder = StartMeetEggRsp.newBuilder();
		ErrorID result = handleService(() -> {
			meetEggHandler.startMeetEgg(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 变化平底锅的位置
	public GeneratedMessageV3 changeMeetXReq(long roleID, ChangeMeetXReq req) {
		ChangeMeetXRsp.Builder builder = ChangeMeetXRsp.newBuilder();
		ErrorID result = handleService(() -> {
			meetEggHandler.changeMeetX(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 接到了掉落物
	public GeneratedMessageV3 meetDropReq(long roleID, MeetDropReq req) {
		MeetDropRsp.Builder builder = MeetDropRsp.newBuilder();
		ErrorID result = handleService(() -> {
			meetEggHandler.meetDrop(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 退出接鸡蛋
	public GeneratedMessageV3 exitMeetEggReq(long roleID, ExitMeetEggReq req) {
		ExitMeetEggRsp.Builder builder = ExitMeetEggRsp.newBuilder();
		ErrorID result = handleService(() -> {
			//MeetEggWorker.getWorker().removeRoom(roleID, builder);
			meetEggHandler.exitMeetEgg(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 暂停开始
	public GeneratedMessageV3 meetEggPauseStartReq(long roleID, MeetEggPauseStartReq req) {
		MeetEggPauseStartRsp.Builder builder = MeetEggPauseStartRsp.newBuilder();
		ErrorID result = handleService(() -> {
			meetEggHandler.meetEggPauseStart(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}
	
	// 拜访npc
	public GeneratedMessageV3 npcVisitReq(long roleID, NpcVisitReq req) {
		NpcVisitRsp.Builder builder = NpcVisitRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			cityHandler.npcVisit(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}
	
	// 对诗，并获取后续题目
	public GeneratedMessageV3 npcOnPoetryReq(long roleID, NpcOnPoetryReq req) {
		NpcOnPoetryRsp.Builder builder = NpcOnPoetryRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			cityHandler.npcOnPoetry(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}
	
	// 要东西
	public GeneratedMessageV3 npcWantThingReq(long roleID, NpcWantThingReq req) {
		NpcWantThingRsp.Builder builder = NpcWantThingRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			cityHandler.npcWantThing(roleID, req);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 赌马
	public GeneratedMessageV3 npcRaceHorsesReq (long roleID, NpcRaceHorsesReq req) {
		NpcRaceHorsesRsp.Builder builder = NpcRaceHorsesRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			cityHandler.npcRaceHorses(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 小混混抢劫
	public GeneratedMessageV3 npcRobberyReq (long roleID, NpcRobberyReq req) {
		NpcRobberyRsp.Builder builder = NpcRobberyRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			cityHandler.npcRobbery(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 赞美NPC
	public GeneratedMessageV3 npcPraiseReq (long roleID, NpcPraiseReq req) {
		NpcPraiseRsp.Builder builder = NpcPraiseRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			cityHandler.npcPraise(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}
}
