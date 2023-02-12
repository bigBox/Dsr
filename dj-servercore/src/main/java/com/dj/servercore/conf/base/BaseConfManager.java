package com.dj.servercore.conf.base;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import com.dj.servercore.conf.*;
import com.dj.servercore.server.SocketServer;
import com.dj.domain.util.GsonUtil;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.Utility;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@SuppressWarnings({"unchecked", "rawtypes"})
public abstract class BaseConfManager implements IConfProvider {

    private static final String CONFIG_URL = SocketServer.getServerConfig().getServerCdnUrl() + "json/%s";

    /**
     *	建筑总表_Factory
     */
    protected ConfigFactoryConf configFactoryConf = new ConfigFactoryConf();
    /**
     *	物品总表_items
     */
    protected ConfigItemsConf configItemsConf = new ConfigItemsConf();
    /**
     *	物品子物品对应的个数_Item2Count
     */
    protected ConfigItem2CountConf configItem2CountConf = new ConfigItem2CountConf();
    /**
     *	可交易物品_TradeItems
     */
    protected ConfigTradeItemsConf configTradeItemsConf = new ConfigTradeItemsConf();
    /**
     *	交易K线_TradeKLine
     */
    //protected ConfigTradeKLineConf configTradeKLineConf = new ConfigTradeKLineConf();
    /**
     *	体力_StaminaCfg
     */
    protected ConfigStaminaCfgConf configStaminaCfgConf = new ConfigStaminaCfgConf();
    /**
     *	月卡_MonthCard
     */
    protected ConfigMonthCardConf configMonthCardConf = new ConfigMonthCardConf();
    /**
     *	物品商店_MiniMall
     */
    protected ConfigMiniMallConf configMiniMallConf = new ConfigMiniMallConf();
    /**
     *	鉴定功能表_VerifyFunc
     */
    protected ConfigVerifyFuncConf configVerifyFuncConf = new ConfigVerifyFuncConf();
    /**
     *	挖矿矿产初始表_MineInit
     */
    protected ConfigMineInitConf configMineInitConf = new ConfigMineInitConf();
    /**
     *	挖矿产出表_DigGold
     */
    protected ConfigDigGoldConf configDigGoldConf = new ConfigDigGoldConf();
    /**
     *	地图碎片产出表_MapPiece
     */
    protected ConfigMapPieceConf configMapPieceConf = new ConfigMapPieceConf();
    /**
     *	玩家出生时就有的物品_NewRoleItem
     */
    protected ConfigNewRoleItemConf configNewRoleItemConf = new ConfigNewRoleItemConf();
    /**
     *	玩家出生时农田动物初始化_NewRoleFarm
     */
    protected ConfigNewRoleFarmConf configNewRoleFarmConf = new ConfigNewRoleFarmConf();
    /**
     *	玩家出生时生态园初始化_NewRolePark
     */
    protected ConfigNewRoleParkConf configNewRoleParkConf = new ConfigNewRoleParkConf();
    /**
     *	玩家出生时展架上就有的物品_NewRoleShowTableItem
     */
    protected ConfigNewRoleShowTableItemConf configNewRoleShowTableItemConf = new ConfigNewRoleShowTableItemConf();
    /**
     *	玩家出生时展架上就有的物品_NewRoleShowTableItem
     */
    protected ConfigNewRoleShowTableInfoConf configNewRoleShowTableInfoConf = new ConfigNewRoleShowTableInfoConf();
    /**
     *	户外采集事件表_EventList
     */
    protected ConfigEventListConf configEventListConf = new ConfigEventListConf();
    /**
     *	户外采集功能表_OutsidesFunc
     */
    protected ConfigOutsidesFuncConf configOutsidesFuncConf = new ConfigOutsidesFuncConf();
    /**
     *	户外产出表_Outsides
     */
    protected ConfigOutsidesConf configOutsidesConf = new ConfigOutsidesConf();
    /**
     *	宝藏配置表_RobCfg
     */
    protected ConfigRobCfgConf configRobCfgConf = new ConfigRobCfgConf();
    /**
     *	宝藏初始表(坐标标的)_RobInit
     */
    protected ConfigRobInitConf configRobInitConf = new ConfigRobInitConf();
    /**
     *	宝藏产出表_RobEvent
     */
    //protected ConfigRobEventConf configRobEventConf = new ConfigRobEventConf();
    /**
     *	宝藏探险功能表_RobFunc
     */
    protected ConfigRobFuncConf configRobFuncConf = new ConfigRobFuncConf();
    /**
     *	宝藏大宝点产出表_RobTreasure
     */
    //protected ConfigRobTreasureConf configRobTreasureConf = new ConfigRobTreasureConf();
    /**
     *	宝藏大宝坐标_RobTreasurePosition
     */
    protected ConfigRobTreasurePositionConf configRobTreasurePositionConf = new ConfigRobTreasurePositionConf();
    /**
     *	宝藏地图门功能表_RobDoor
     */
    //protected ConfigRobDoorConf configRobDoorConf = new ConfigRobDoorConf();
    /**
     *	地图未开垦表_Obstacles
     */
    protected ConfigObstaclesConf configObstaclesConf = new ConfigObstaclesConf();
    /**
     *	地图未开垦元素表_ObstacleCell
     */
    protected ConfigObstacleCellConf configObstacleCellConf = new ConfigObstacleCellConf();
    /**
     *	新手任务_GuideTask
     */
    protected ConfigGuideTaskConf configGuideTaskConf = new ConfigGuideTaskConf();
    /**
     *	任务_Tasks
     */
    protected ConfigTasksConf configTasksConf = new ConfigTasksConf();
    /**
     *	制作配方表_ManufactureMakeData
     */
    protected ConfigManufactureMakeDataConf configManufactureMakeDataConf = new ConfigManufactureMakeDataConf();
    /**
     *	升级经验_ExpLevelCfg
     */
    protected ConfigExpLevelCfgConf configExpLevelCfgConf = new ConfigExpLevelCfgConf();
    /**
     *	升级声望_ReputationLevel
     */
    protected ConfigReputationLevelConf configReputationLevelConf = new ConfigReputationLevelConf();
    /**
     *	升级馆藏_ShowTableLevel
     */
    protected ConfigShowTableLevelConf configShowTableLevelConf = new ConfigShowTableLevelConf();
    /**
     *	生态园功能植物表_FarmParkPlant
     */
    protected ConfigFarmParkPlantConf configFarmParkPlantConf = new ConfigFarmParkPlantConf();
    /**
     *	生态园功能树木表_FarmParkTree
     */
    protected ConfigFarmParkTreeConf configFarmParkTreeConf = new ConfigFarmParkTreeConf();
    /**
     *	生态园功能动物表_FarmParkAnimal
     */
    protected ConfigFarmParkAnimalConf configFarmParkAnimalConf = new ConfigFarmParkAnimalConf();
    /**
     *	动物园功能动物表_FarmZooAnimal
     */
    protected ConfigFarmZooAnimalConf configFarmZooAnimalConf = new ConfigFarmZooAnimalConf();
    /**
     *	农场功能表_FarmCulture
     */
    protected ConfigFarmCultureConf configFarmCultureConf = new ConfigFarmCultureConf();
    /**
     *	鱼塘功能表_PoolFishs
     */
    protected ConfigPoolFishsConf configPoolFishsConf = new ConfigPoolFishsConf();
    /**
     *	杂项表_Sundry
     */
    protected ConfigSundryConf configSundryConf = new ConfigSundryConf();
    /**
     *	小游戏_MiniGame
     */
    protected ConfigMiniGameConf configMiniGameConf = new ConfigMiniGameConf();
    /**
     *	小游戏接鸡蛋掉落物品表_MeetEggDropItems
     */
    protected ConfigMeetEggDropItemsConf configMeetEggDropItemsConf = new ConfigMeetEggDropItemsConf();
    /**
     *	小游戏接鸡蛋精灵表_MeetEggGhostData
     */
    protected ConfigMeetEggGhostDataConf configMeetEggGhostDataConf = new ConfigMeetEggGhostDataConf();
    /**
     *	套装ID_Antique
     */
    protected ConfigAntiqueConf configAntiqueConf = new ConfigAntiqueConf();
    /**
     *	商会升级经验_GuildLevel
     */
    protected ConfigGuildLevelConf configGuildLevelConf = new ConfigGuildLevelConf();
    /**
     *	收集_CollectionData
     */
    protected ConfigCollectionDataConf configCollectionDataConf = new ConfigCollectionDataConf();
    /**
     *	宝贝套装内容表_CollectionItems
     */
    protected ConfigCollectionItemsConf configCollectionItemsConf = new ConfigCollectionItemsConf();
    /**
     *	各种探险产出表
     */
    protected ConfigCollectionEventConf configCollectionEventConf = new ConfigCollectionEventConf();
    /**
     *	城市列表_CityList
     */
    protected ConfigCityListConf     configCityListConf     = new ConfigCityListConf();
    /**
     *	城市建筑_CityScene
     */
    protected ConfigCitySceneConf    configCitySceneConf    = new ConfigCitySceneConf();
    /**
     *	城市建筑_CitySceneEvent
     */
    protected ConfigCitySceneEventConf   configCitySceneEventConf    = new ConfigCitySceneEventConf();
    /**
     *	城市npc事件_CityNpcEvent
     */
    protected ConfigCityNpcEventConf    configCityNpcEventConf    = new ConfigCityNpcEventConf();
    /**
     *	城市npc技能_CityNpcSkill
     */
    protected ConfigCityNpcSkillConf configCityNpcSkillConf = new ConfigCityNpcSkillConf();
    /**
     *	城市对诗_OnPoetry
     */
    protected ConfigOnPoetryConf configOnPoetryConf = new ConfigOnPoetryConf();
    /**
     *	成就_Achievement
     */
    protected ConfigAchievementConf configAchievementConf = new ConfigAchievementConf();
    /**
     *	图鉴_Book
     */
    protected ConfigBookConf configBookConf = new ConfigBookConf();
    /**
     *	精灵召唤消耗_Summons
     */
    protected ConfigSummonsConf       configSummonsConf       = new ConfigSummonsConf();
    /**
     *	精灵旅行获得奖励邮件_SummonMail
     */
    //protected ConfigSummonMailConf    configSummonMailConf   = new ConfigSummonMailConf();
    /**
     * 精灵探险功能表_SummonExplore
     */
    protected ConfigSummonsExploreConf configSummonsExploreConf = new ConfigSummonsExploreConf();
    /**
     * 精灵探险产出表_SummonOutput
     */
    //protected ConfigSummonsOutputConf configSummonsOutputConf = new ConfigSummonsOutputConf();
    /**
     * 精灵召唤成功概率表_SummonsRate
     */
    protected ConfigSummonsRateConf configSummonsRateConf = new ConfigSummonsRateConf();
    /**
     *	精灵包裹数量_SummonPackageCount
     */
    protected ConfigSummonPackageCountConf  configSummonPackageCountConf   = new ConfigSummonPackageCountConf();
    /**
     * 虚拟物品表_VirtualItems
     */
    protected ConfigVirtualItemsConf configVirtualItemsConf = new ConfigVirtualItemsConf();


    protected ConfigTrapEventConf configTrapEventConf = new ConfigTrapEventConf();

    protected Map<String, BaseConfigConf<?>> confMap = Maps.newHashMapWithExpectedSize(55);

    private static BaseConfManager instance;

    protected static void setInstance(BaseConfManager instance) {
        BaseConfManager.instance = instance;
    }

    public static BaseConfManager getInstance() {
        return instance;
    }

    public boolean load(boolean romote) throws Exception {
        String jsonPath = "";
        if (romote) {
            log.info(CONFIG_URL);
        }else{
            if(System.getProperty("os.name").toLowerCase().contains("windows")){
                String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
                String[] pathSplit = path.split("/");
                String jarName = pathSplit[pathSplit.length - 2] + "/"+pathSplit[pathSplit.length - 1] + "/";
                String jarPath = path.replace(jarName, "");
                jsonPath = jarPath+"src/main/resources/json/";
            }else{
                jsonPath = SocketServer.getServerConfig().getJsonPath();
            }
            log.info("jsonPath = {}", jsonPath);
        }
        boolean flag;
        List<BaseConfigConf<?>> list = getConfigConfs();
        try {
            for (BaseConfigConf<?> conf : list) {
                if (conf != null) {
                    if (romote) {
                        flag = loadRemoteConfig(conf);
                    } else {
                        flag = loadLocalConfig(conf, jsonPath);
                    }
                    if (!flag) {
                        return false;
                    }
                    confMap.put(conf.getConfig(), conf);
                }
            }
        } catch (Exception e) {
            log.error("Load error={}", Utility.getTraceString(e));
            throw e;
        } finally {
            onLoadOver();
        }
        return true;
    }

    public <TConf extends BaseConfigConf> boolean loadLocalConfig(TConf conf, String jsonPath) throws Exception {
        WriteLock wlock = conf.getConfigRWLock().writeLock();
        try {
            wlock.lock();
            // 拼接全路径配置文件名
            if (!StringUtil.isEmpty(conf.getConfig())) {
                jsonPath = jsonPath + conf.getConfig();
                InputStream inputStream = new FileInputStream(jsonPath);
                log.info("Load {} Config ...", conf.getConfig());
                ParameterizedType type = (ParameterizedType) conf.getClass().getGenericSuperclass();
                Class clz = (Class) type.getActualTypeArguments()[0];
                StringBuilder json = new StringBuilder();
                BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                String line;
                while ((line = bf.readLine()) != null) {
                    json.append(line);
                }
                inputStream.close();
                List<String> jsonList = GsonUtil.fromJson(json.toString(), List.class);
                List list = new ArrayList(jsonList.size());
                for (String s : jsonList) {
                    list.add(GsonUtil.fromJson(s, clz));
                }
                conf.setDataList(list);
                conf.onLoadOver();
            } else {
                throw new RuntimeException(conf.getClass().getName() + " is not have configFilePath .");
            }
            log.info("{} Config initialized success!", conf.getClass().getSimpleName());
        } catch (Exception e) {
            log.error("{} Config initialized fail! Cause of={}", conf.getClass().getSimpleName(), Utility.getTraceString(e));
            throw e;
        } finally {
            wlock.unlock();
        }
        return true;
    }

    public <TConf extends BaseConfigConf> boolean loadRemoteConfig(TConf conf) throws Exception {
        WriteLock wlock = conf.getConfigRWLock().writeLock();
        try {
            wlock.lock();
            if (StringUtil.isNotEmpty(conf.getConfig())) {
                //log.info("Load {} Config ...", conf.getClass().getSimpleName());
                ParameterizedType type = (ParameterizedType) conf.getClass().getGenericSuperclass();
                Class clz = (Class) type.getActualTypeArguments()[0];
                StringBuilder json = new StringBuilder();
                log.info("Load {} Config ...", conf.getConfig());
                InputStream inputStream = getRemoteJsonInputStream(conf.getConfig());
                if(inputStream != null) {
                    BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                    String line;
                    while ((line = bf.readLine()) != null) {
                        json.append(line);
                    }
                    inputStream.close();
                }else{
                    log.info("Load {} Config Error! inputStream==null !!!", conf.getConfig());
                }
                List<String> jsonList = GsonUtil.fromJson(json.toString(), List.class);
                if(jsonList.size() > 0) {
                    List list = new ArrayList(jsonList.size());
                    for (String s : jsonList) {
                        list.add(GsonUtil.fromJson(s, clz));
                    }
                    conf.setDataList(list);
                    conf.onLoadOver();
                }
            } else {
                throw new RuntimeException(conf.getClass().getName() + " is not have configFilePath .");
            }
            log.info("{} Config initialized success!", conf.getClass().getSimpleName());
        } catch (Exception e) {
            log.error("{} Config initialized fail! Cause of={}", conf.getClass().getSimpleName(), Utility.getTraceString(e));
            throw e;
        } finally {
            wlock.unlock();
        }
        return true;
    }

    private InputStream getRemoteJsonInputStream(String configFilePath) {
        try {
            String address = String.format(CONFIG_URL, configFilePath);
            URL url = new URL(address);
            URLConnection conn = url.openConnection();
            HttpURLConnection httpUrlConnection = (HttpURLConnection) conn;
            if (httpUrlConnection.getResponseCode() == 200) {
                return conn.getInputStream();
            }
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
        }
        return null;
    }

    protected List<BaseConfigConf<?>> getConfigConfs() {
        Class superClass = getClass().getSuperclass();
        List<Field> fields = Lists.newArrayList(superClass.getDeclaredFields());
        List<Field> subFields = Lists.newArrayList(getClass().getDeclaredFields());
        fields.addAll(subFields);
        List<BaseConfigConf<?>> list = Lists.newArrayList();
        for (Field field : fields) {
            if (field.getType().toString().contains("conf.Config")) {
                ParameterizedType type = (ParameterizedType) field.getType().getGenericSuperclass();
                if (type.getRawType().getTypeName().equals(BaseConfigConf.class.getName())) {
                    BaseConfigConf<?> value = (BaseConfigConf<?>) getFieldValueByName(field.getName(), this);
                    if (value != null) {
                        list.add(value);
                    }
                }
            }
        }
        return list;
    }

    private Object getFieldValueByName(String fieldName, Object obj) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = obj.getClass().getMethod(getter);
            return method.invoke(obj);
        } catch (Exception e) {
            log.error("get field error={}", Utility.getTraceString(e));
            return null;
        }
    }

    protected abstract void onLoadOver();

    @Override
    public <X, T extends BaseConfigConf<X>> T getConfigConf(String name) {
        if (StringUtil.isEmpty(name)) {
            return null;
        }
        return (T) confMap.get(name);
    }

    @Override
    public <X, T extends BaseConfigConf<X>> void setConfigConf(String configName, T conf) {
        if (StringUtil.isEmpty(configName)) {
            return;
        }
        confMap.put(conf.getConfig(), conf);
    }

    public void updateConfig(String configName) {
        try {
            log.info(configName);
            BaseConfigConf conf = getConfigConf(configName);
            loadRemoteConfig(conf);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
        }
    }
}
