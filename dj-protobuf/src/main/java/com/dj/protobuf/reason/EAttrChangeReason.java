// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Reason.proto

package com.dj.protobuf.reason;

/**
 * Protobuf enum {@code Protocols.EAttrChangeReason}
 */
public enum EAttrChangeReason
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   * 没有原因默认值
   * </pre>
   *
   * <code>None = 0;</code>
   */
  None(0),
  /**
   * <pre>
   * GM修改值
   * </pre>
   *
   * <code>GmSet = 1;</code>
   */
  GmSet(1),
  /**
   * <pre>
   * 成就系统修改
   * </pre>
   *
   * <code>Achievement = 2;</code>
   */
  Achievement(2),
  /**
   * <pre>
   * 充值活动
   * </pre>
   *
   * <code>ActivityAccRecharge = 3;</code>
   */
  ActivityAccRecharge(3),
  /**
   * <pre>
   * 首充活动
   * </pre>
   *
   * <code>ActivityFirstRecharge = 4;</code>
   */
  ActivityFirstRecharge(4),
  /**
   * <pre>
   * 等级礼包活动
   * </pre>
   *
   * <code>ActivityGradeUpGift = 5;</code>
   */
  ActivityGradeUpGift(5),
  /**
   * <pre>
   * 过关奖励活动
   * </pre>
   *
   * <code>ActivityLevelReward = 6;</code>
   */
  ActivityLevelReward(6),
  /**
   * <pre>
   * 在线奖励
   * </pre>
   *
   * <code>ActivityOnlineReward = 7;</code>
   */
  ActivityOnlineReward(7),
  /**
   * <pre>
   * VIP礼包活动
   * </pre>
   *
   * <code>ActivityVipGiftBag = 8;</code>
   */
  ActivityVipGiftBag(8),
  /**
   * <pre>
   * 男友模块
   * </pre>
   *
   * <code>BoyFriend = 9;</code>
   */
  BoyFriend(9),
  /**
   * <pre>
   * 角色模块
   * </pre>
   *
   * <code>Character = 10;</code>
   */
  Character(10),
  /**
   * <pre>
   * 工会模块
   * </pre>
   *
   * <code>Guild = 11;</code>
   */
  Guild(11),
  /**
   * <pre>
   * 制作模块
   * </pre>
   *
   * <code>Manufacture = 12;</code>
   */
  Manufacture(12),
  /**
   * <pre>
   * 任务模块
   * </pre>
   *
   * <code>Quest = 13;</code>
   */
  Quest(13),
  /**
   * <pre>
   * 时尚搭配赛
   * </pre>
   *
   * <code>FashionMatch = 14;</code>
   */
  FashionMatch(14),
  /**
   * <pre>
   * Item模块
   * </pre>
   *
   * <code>Item = 15;</code>
   */
  Item(15),
  /**
   * <pre>
   * 剧情关卡模块
   * </pre>
   *
   * <code>Level = 16;</code>
   */
  Level(16),
  /**
   * <pre>
   * 聊天模块
   * </pre>
   *
   * <code>Chat = 17;</code>
   */
  Chat(17),
  /**
   * <pre>
   * PK模块
   * </pre>
   *
   * <code>Competition = 18;</code>
   */
  Competition(18),
  /**
   * <pre>
   * 奇怪的模块
   * </pre>
   *
   * <code>ExpandValuePurchase = 19;</code>
   */
  ExpandValuePurchase(19),
  /**
   * <pre>
   * 好友模块
   * </pre>
   *
   * <code>Friend = 20;</code>
   */
  Friend(20),
  /**
   * <pre>
   * 签到
   * </pre>
   *
   * <code>SignIn = 21;</code>
   */
  SignIn(21),
  /**
   * <pre>
   * 许愿
   * </pre>
   *
   * <code>TreasureBox = 22;</code>
   */
  TreasureBox(22),
  /**
   * <pre>
   * 邮件
   * </pre>
   *
   * <code>Mail = 23;</code>
   */
  Mail(23),
  /**
   * <pre>
   * 支付模块
   * </pre>
   *
   * <code>Pay = 24;</code>
   */
  Pay(24),
  /**
   * <pre>
   * 商城
   * </pre>
   *
   * <code>Mall = 25;</code>
   */
  Mall(25),
  /**
   * <pre>
   * 脚本
   * </pre>
   *
   * <code>Scripts = 26;</code>
   */
  Scripts(26),
  /**
   * <pre>
   * 七天登录活动
   * </pre>
   *
   * <code>ActivitySevenDayLogin = 27;</code>
   */
  ActivitySevenDayLogin(27),
  /**
   * <pre>
   * 活动总称
   * </pre>
   *
   * <code>Activity = 28;</code>
   */
  Activity(28),
  /**
   * <pre>
   * 社交分享
   * </pre>
   *
   * <code>SocialShare = 29;</code>
   */
  SocialShare(29),
  /**
   * <pre>
   * 答题
   * </pre>
   *
   * <code>Quiz = 30;</code>
   */
  Quiz(30),
  /**
   * <pre>
   * 特殊关卡
   * </pre>
   *
   * <code>Level2 = 31;</code>
   */
  Level2(31),
  /**
   * <pre>
   * 礼包售卖
   * </pre>
   *
   * <code>GiftBagSell = 32;</code>
   */
  GiftBagSell(32),
  /**
   * <pre>
   * 钻石翻翻翻
   * </pre>
   *
   * <code>DiamondReturn = 33;</code>
   */
  DiamondReturn(33),
  /**
   * <pre>
   * 场景派对
   * </pre>
   *
   * <code>Scene = 34;</code>
   */
  Scene(34),
  /**
   * <pre>
   * 开宝箱
   * </pre>
   *
   * <code>GiftBag = 35;</code>
   */
  GiftBag(35),
  /**
   * <pre>
   * 七夕
   * </pre>
   *
   * <code>DoubleSeventh = 36;</code>
   */
  DoubleSeventh(36),
  /**
   * <pre>
   * 兑换活动
   * </pre>
   *
   * <code>ActivityExchange = 37;</code>
   */
  ActivityExchange(37),
  /**
   * <pre>
   * 限时排名
   * </pre>
   *
   * <code>LimitTimeRank = 38;</code>
   */
  LimitTimeRank(38),
  /**
   * <pre>
   * 主线任务
   * </pre>
   *
   * <code>Task = 39;</code>
   */
  Task(39),
  ;

  /**
   * <pre>
   * 没有原因默认值
   * </pre>
   *
   * <code>None = 0;</code>
   */
  public static final int None_VALUE = 0;
  /**
   * <pre>
   * GM修改值
   * </pre>
   *
   * <code>GmSet = 1;</code>
   */
  public static final int GmSet_VALUE = 1;
  /**
   * <pre>
   * 成就系统修改
   * </pre>
   *
   * <code>Achievement = 2;</code>
   */
  public static final int Achievement_VALUE = 2;
  /**
   * <pre>
   * 充值活动
   * </pre>
   *
   * <code>ActivityAccRecharge = 3;</code>
   */
  public static final int ActivityAccRecharge_VALUE = 3;
  /**
   * <pre>
   * 首充活动
   * </pre>
   *
   * <code>ActivityFirstRecharge = 4;</code>
   */
  public static final int ActivityFirstRecharge_VALUE = 4;
  /**
   * <pre>
   * 等级礼包活动
   * </pre>
   *
   * <code>ActivityGradeUpGift = 5;</code>
   */
  public static final int ActivityGradeUpGift_VALUE = 5;
  /**
   * <pre>
   * 过关奖励活动
   * </pre>
   *
   * <code>ActivityLevelReward = 6;</code>
   */
  public static final int ActivityLevelReward_VALUE = 6;
  /**
   * <pre>
   * 在线奖励
   * </pre>
   *
   * <code>ActivityOnlineReward = 7;</code>
   */
  public static final int ActivityOnlineReward_VALUE = 7;
  /**
   * <pre>
   * VIP礼包活动
   * </pre>
   *
   * <code>ActivityVipGiftBag = 8;</code>
   */
  public static final int ActivityVipGiftBag_VALUE = 8;
  /**
   * <pre>
   * 男友模块
   * </pre>
   *
   * <code>BoyFriend = 9;</code>
   */
  public static final int BoyFriend_VALUE = 9;
  /**
   * <pre>
   * 角色模块
   * </pre>
   *
   * <code>Character = 10;</code>
   */
  public static final int Character_VALUE = 10;
  /**
   * <pre>
   * 工会模块
   * </pre>
   *
   * <code>Guild = 11;</code>
   */
  public static final int Guild_VALUE = 11;
  /**
   * <pre>
   * 制作模块
   * </pre>
   *
   * <code>Manufacture = 12;</code>
   */
  public static final int Manufacture_VALUE = 12;
  /**
   * <pre>
   * 任务模块
   * </pre>
   *
   * <code>Quest = 13;</code>
   */
  public static final int Quest_VALUE = 13;
  /**
   * <pre>
   * 时尚搭配赛
   * </pre>
   *
   * <code>FashionMatch = 14;</code>
   */
  public static final int FashionMatch_VALUE = 14;
  /**
   * <pre>
   * Item模块
   * </pre>
   *
   * <code>Item = 15;</code>
   */
  public static final int Item_VALUE = 15;
  /**
   * <pre>
   * 剧情关卡模块
   * </pre>
   *
   * <code>Level = 16;</code>
   */
  public static final int Level_VALUE = 16;
  /**
   * <pre>
   * 聊天模块
   * </pre>
   *
   * <code>Chat = 17;</code>
   */
  public static final int Chat_VALUE = 17;
  /**
   * <pre>
   * PK模块
   * </pre>
   *
   * <code>Competition = 18;</code>
   */
  public static final int Competition_VALUE = 18;
  /**
   * <pre>
   * 奇怪的模块
   * </pre>
   *
   * <code>ExpandValuePurchase = 19;</code>
   */
  public static final int ExpandValuePurchase_VALUE = 19;
  /**
   * <pre>
   * 好友模块
   * </pre>
   *
   * <code>Friend = 20;</code>
   */
  public static final int Friend_VALUE = 20;
  /**
   * <pre>
   * 签到
   * </pre>
   *
   * <code>SignIn = 21;</code>
   */
  public static final int SignIn_VALUE = 21;
  /**
   * <pre>
   * 许愿
   * </pre>
   *
   * <code>TreasureBox = 22;</code>
   */
  public static final int TreasureBox_VALUE = 22;
  /**
   * <pre>
   * 邮件
   * </pre>
   *
   * <code>Mail = 23;</code>
   */
  public static final int Mail_VALUE = 23;
  /**
   * <pre>
   * 支付模块
   * </pre>
   *
   * <code>Pay = 24;</code>
   */
  public static final int Pay_VALUE = 24;
  /**
   * <pre>
   * 商城
   * </pre>
   *
   * <code>Mall = 25;</code>
   */
  public static final int Mall_VALUE = 25;
  /**
   * <pre>
   * 脚本
   * </pre>
   *
   * <code>Scripts = 26;</code>
   */
  public static final int Scripts_VALUE = 26;
  /**
   * <pre>
   * 七天登录活动
   * </pre>
   *
   * <code>ActivitySevenDayLogin = 27;</code>
   */
  public static final int ActivitySevenDayLogin_VALUE = 27;
  /**
   * <pre>
   * 活动总称
   * </pre>
   *
   * <code>Activity = 28;</code>
   */
  public static final int Activity_VALUE = 28;
  /**
   * <pre>
   * 社交分享
   * </pre>
   *
   * <code>SocialShare = 29;</code>
   */
  public static final int SocialShare_VALUE = 29;
  /**
   * <pre>
   * 答题
   * </pre>
   *
   * <code>Quiz = 30;</code>
   */
  public static final int Quiz_VALUE = 30;
  /**
   * <pre>
   * 特殊关卡
   * </pre>
   *
   * <code>Level2 = 31;</code>
   */
  public static final int Level2_VALUE = 31;
  /**
   * <pre>
   * 礼包售卖
   * </pre>
   *
   * <code>GiftBagSell = 32;</code>
   */
  public static final int GiftBagSell_VALUE = 32;
  /**
   * <pre>
   * 钻石翻翻翻
   * </pre>
   *
   * <code>DiamondReturn = 33;</code>
   */
  public static final int DiamondReturn_VALUE = 33;
  /**
   * <pre>
   * 场景派对
   * </pre>
   *
   * <code>Scene = 34;</code>
   */
  public static final int Scene_VALUE = 34;
  /**
   * <pre>
   * 开宝箱
   * </pre>
   *
   * <code>GiftBag = 35;</code>
   */
  public static final int GiftBag_VALUE = 35;
  /**
   * <pre>
   * 七夕
   * </pre>
   *
   * <code>DoubleSeventh = 36;</code>
   */
  public static final int DoubleSeventh_VALUE = 36;
  /**
   * <pre>
   * 兑换活动
   * </pre>
   *
   * <code>ActivityExchange = 37;</code>
   */
  public static final int ActivityExchange_VALUE = 37;
  /**
   * <pre>
   * 限时排名
   * </pre>
   *
   * <code>LimitTimeRank = 38;</code>
   */
  public static final int LimitTimeRank_VALUE = 38;
  /**
   * <pre>
   * 主线任务
   * </pre>
   *
   * <code>Task = 39;</code>
   */
  public static final int Task_VALUE = 39;


  public final int getNumber() {
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static EAttrChangeReason valueOf(int value) {
    return forNumber(value);
  }

  public static EAttrChangeReason forNumber(int value) {
    switch (value) {
      case 0: return None;
      case 1: return GmSet;
      case 2: return Achievement;
      case 3: return ActivityAccRecharge;
      case 4: return ActivityFirstRecharge;
      case 5: return ActivityGradeUpGift;
      case 6: return ActivityLevelReward;
      case 7: return ActivityOnlineReward;
      case 8: return ActivityVipGiftBag;
      case 9: return BoyFriend;
      case 10: return Character;
      case 11: return Guild;
      case 12: return Manufacture;
      case 13: return Quest;
      case 14: return FashionMatch;
      case 15: return Item;
      case 16: return Level;
      case 17: return Chat;
      case 18: return Competition;
      case 19: return ExpandValuePurchase;
      case 20: return Friend;
      case 21: return SignIn;
      case 22: return TreasureBox;
      case 23: return Mail;
      case 24: return Pay;
      case 25: return Mall;
      case 26: return Scripts;
      case 27: return ActivitySevenDayLogin;
      case 28: return Activity;
      case 29: return SocialShare;
      case 30: return Quiz;
      case 31: return Level2;
      case 32: return GiftBagSell;
      case 33: return DiamondReturn;
      case 34: return Scene;
      case 35: return GiftBag;
      case 36: return DoubleSeventh;
      case 37: return ActivityExchange;
      case 38: return LimitTimeRank;
      case 39: return Task;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<EAttrChangeReason>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      EAttrChangeReason> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<EAttrChangeReason>() {
          public EAttrChangeReason findValueByNumber(int number) {
            return EAttrChangeReason.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return com.dj.protobuf.reason.Reason.getDescriptor()
        .getEnumTypes().get(0);
  }

  private static final EAttrChangeReason[] VALUES = values();

  public static EAttrChangeReason valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private EAttrChangeReason(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:Protocols.EAttrChangeReason)
}
