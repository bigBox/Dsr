package com.dj.domain.enums;

import com.dj.domain.constant.ConstantSource;

/**
 * @author zcq
 * @description 物品账单
 * @date 2019年5月28日
 */
public enum ResourceBillEnum {

    initNewRoleItem("玩家出生时就有的物品", ConstantSource.Birth),
    addSupermanItem("添加超级人物品", ConstantSource.Birth),
    addAllItem("添加所有物品", ConstantSource.Birth),
    firstLogin("第一次登陆", ConstantSource.Birth),
    repairLoginData("修复登陆数据"),
    initXiaoXunItem("小寻出生的物品", ConstantSource.Birth),
    farmActionHarvest("农场收获"),
    mallBuy("商城购买", ConstantSource.Shop),
    gmItem("gm命令添加道具"),
    monthCardDraw("领取月卡奖励"),
    changeName("玩家改名字"),
    changeGuildName("修改商会名称"),
    manufactureAction("制作领取"),
    manufactureBatchPickup("批量拾取制作物品"),
    meetDrop("接鸡蛋获得物品"),
    robUseSkill("盗墓获得物品", ConstantSource.Rob),
    robBombMonster("消灭毒虫"),
    outsideCost("户外探险消耗物品"),
    outsideBatchCost("户外批量探险消耗物品"),
    outsideReward("户外探险获得物品", ConstantSource.Outside),
    outsideBatchReward("户外批量探险获得物品", ConstantSource.Outside),
    outsideGuideCost("户外探险引导消耗物品"),
    outsideGuideReward("户外探险引导获得物品"),
    showTablePutDown("从展厅拿下来"),
    showTableAutoPutDown("展厅自动下架"),
    showTablePutOn("放入展厅"),
    verifyEequeue("放入鉴定"),
    antiqueCompose("展厅合成"),
    showTableSupport("好友点赞"),
    verifyDequeue("把鉴定好的物品放回背包", ConstantSource.Verify),
    summonMailReward("领取精灵邮件奖励", ConstantSource.Summon),
    verifyItem("帮朋友鉴定"),
    dayAutoVerifyItem("每天自动鉴定"),
    tradeEnqueueSale("交易-卖"),
    tradeEnqueuePurchase("交易-买"),
    manufactureActionCost("制作消耗"),
    manufactureActionReward("制作奖励"),
    obstaclesOpenup("开垦荒地"),
    summonCost("召唤精灵消耗", true),
    summonReward("召唤精灵奖励"),
    summonSend("精灵原型"),
    summonInvest("投资精灵消耗"),
    summonPickupInvestReward("精灵投资奖励捡漏"),
    taskRewardCost("领取任务奖励消耗"),
    taskReward("领取任务奖励", ConstantSource.Task),
    manufactureSpeedup("制作队列加速"),
    farmActionPlaint("农场种植"),
    parkPlaceCrops("放置庄稼"),
    parkPlacePlant("放置植物"),
    parkPlaceTree("放置树木"),
    parkPlaceAnimal("放置动物"),
    parkPlaceFish("鱼塘放置鱼"),
    parkHarvestCrops("收获庄稼"),
    parkHarvestPlant("收获植物"),
    parkHarvestTree("收获树木"),
    parkHarvestAnimal("收获动物"),
    parkHarvestFish("鱼塘收获鱼"),
    parkDrawHoney("领取蜂蜜奖励"),
    parkDrawPrize("生态园结算"),
    parkAnimalFeed("动物喂食"),
    robJoinMap("进入盗墓消耗", true),
    robDoorOpen("盗墓开门"),
    joinSceneFriend("进好友矿区消耗"),
    mineReward("挖矿获得", ConstantSource.Mine),
    mineCost("挖矿消耗"),
    tradeDequeueSale("交易卖-拿出队列"),
    tradeDequeuePurchase("交易买-拿出队列"),
    tradeUseSellCost("交易卖扣物品"),
    tradeUseSellReward("交易卖获得物品"),
    tradeUseBuyReward("交易买获得物品", ConstantSource.Trade),
    tradeUseBuyCost("交易买扣物品"),
    useItem2Count("使用父道具增加使用数量"),
    parkClearWitherPlant("清除枯萎植物消耗物品"),
    parkClearWitherAnimal("清除枯萎动物消耗物品"),
    sceneUseSkillCost("挖矿使用技能消耗"),
    useMonthCard("使用月卡"),
    getGuideReward("获取新手引导奖励"),
    meetEggGrantReward("发放单机接鸡蛋奖励"),
    animalEatPlant("动物吃草"),
    showTableDrawPrize("领取展厅的奖励"),
    createGuild("创建商会"),
    signUpGuildBattle("商会战斗报名"),
    guildApply("申请加入商会"),
    guildTaskSpeedUp("商会任务加速消耗"),
    itemRemove("删除物品"),
    itemInteract("和好友互动物品"),
    staminaRecover("恢复体力"),
    usePowerBarAddStamina("使用能量棒加体力"),
    verifyUseCard("使用鉴定卡鉴定"),
    verifySpeedup("鉴定加速消耗"),
    npcVisit("拜访npc"),
    npcWantThing("向npc要东西"),
	npcSkill1("所有宝藏图最少的3个地图碎片各补2张"),
	npcSkill3("所有关卡全开---免五行石，并给一组大宝（和大宝的规则相同，至少一个稀有，最多9个）"),
	npcSkill12("给玩家的宝贝套装补齐两套"),
	collectionExchangeReward("兑换收集奖励"),
	bookReward("领取图鉴标志新的奖励");

    /**
     * 说明
     */
    private String desc;

    /**
     * 记录来源
     */
    private int source;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public boolean isCommitEvent() {
        return commitEvent;
    }

    public void setCommitEvent(boolean commitEvent) {
        this.commitEvent = commitEvent;
    }

    /**
     * 是否直接提交事件
     */
    private boolean commitEvent;

    ResourceBillEnum(String desc) {
        this.desc = desc;
        this.source = 0;
    }

    ResourceBillEnum(String desc, int source) {
        this.desc = desc;
        this.source = source;
    }

    ResourceBillEnum(String desc, boolean commitEvent) {
        this.desc = desc;
        this.commitEvent = commitEvent;
    }
}
