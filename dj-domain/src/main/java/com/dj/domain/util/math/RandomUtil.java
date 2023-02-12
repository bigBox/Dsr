package com.dj.domain.util.math;

import java.awt.Color;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.dj.domain.util.inf.IArgumentRunnable;
import com.dj.domain.util.inf.IDataProvider;
import com.dj.domain.util.lib.DataPair;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RandomUtil {
    private static final int seedLength = 20;

    public static SecureRandom random;

    // public static Random random = new Random();
    static {
        try {
            random = SecureRandom.getInstance("SHA1PRNG", "SUN");
            random.setSeed(random.generateSeed(seedLength));
            // byte seed[] = random.generateSeed(seedLength);
            // random.nextBytes(seed);
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            //logger.error(Utility.getTraceString(e));
        }
    }

    private final static String ASC_II = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";

    private final static char[] seed1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private final static char[] seed2 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /**
     *	随机获得一个字符
     *
     * @return
     */
    public static char nextChar() {
        return ASC_II.charAt(random.nextInt(ASC_II.length()));
    }

    public static String getChinese(int length) throws Exception {
        if (length < 1) {
            return "";
        }
        if (length == 1) {
            return getChinese();
        }
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stb.append(getChinese());
        }
        return stb.toString();
    }

    /**
     *	随机生成中文字
     *
     * @return
     * @throws Exception
     */
    public static String getChinese() throws Exception {
        Integer highPos = 176 + Math.abs(random.nextInt(39));
        Integer lowPos = 161 + Math.abs(random.nextInt(93));
        byte[] b = new byte[2];
        b[0] = highPos.byteValue();
        b[1] = lowPos.byteValue();
        return new String(b, "GB2312");
    }

    /**
     *	随机获得一个字符串
     *
     * @param number
     * @return
     */
    public static String nextString(int number) {
        StringBuilder buf = new StringBuilder();
        buf.append(number);
        for (int j = 1; j < number; j++) {
            buf.append(nextChar());
        }
        return buf.toString();
    }

    public static int nextInt() {
        return random.nextInt();
    }

    public static int nextInt(int n) {
        try {
            return random.nextInt(n);
        } finally {
            random.setSeed(random.generateSeed(seedLength));
        }
    }

    public static float nextFloat(float n) {
        return random.nextFloat() * n;
    }

    public static boolean nextBoolean() {
        return random.nextBoolean();
    }

    /**
     *	计算概率是否成功， 参数应该是一个 0-100 之内的数字
     *
     * @param value
     * @return
     */
    public static boolean shakeIn100(int value) {
        return shakeInNum(value, 100);
    }

    /**
     *	计算概率
     *
     * @param value
     * @param num
     * @return
     */
    public static boolean shakeInNum(int value, int num) {
        if (value < -1) {
            throw new UnsupportedOperationException("value only can 0-" + num + ", " + value + " is a error value.");
        }
        if (value >= num) {
            return true;
        }
        if (value <= 0) {
            return false;
        }
        boolean ret = random.nextInt(num) <= value;
        random.setSeed(random.generateSeed(seedLength));
        return ret;
    }

    /**
     *	计算是否在概率范围内， 详情可见 {@link #shakeIn100(int)}
     *
     * @param bigInteger
     * @return
     */
    public static boolean shakeIn100(BigInteger bigInteger) {
        if (bigInteger == null) {
            return false;
        }
        return shakeIn100(bigInteger.intValue());
    }

    /**
     *	在10000内随机
     *
     * @param value
     * @return
     */
    public static boolean shakeIn10000(int value) {
        return shakeInNum(value, 10000);
    }

    /**
     *	在10000内随机
     *
     * @param value
     * @return
     */
    public static boolean shakeIn10000(BigInteger value) {
        if (value == null) {
            return false;
        }
        return shakeInNum(value.intValue(), 10000);
    }

    public static int nextInt(BigInteger min, BigInteger max) {
        return nextInt(min.intValue(), max.intValue());
    }

    /**
     *	得到指定去区间的int值
     *
     * @param min 包含
     * @param max 包含
     * @return
     */
    public static int nextInt(int min, int max) {
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        random.setSeed(random.generateSeed(seedLength));
        return random.nextInt(max - min + 1) + min;
    }

    /**
     *	标准高斯正态分布 参数是可能取到的最大值 返回的数值在0到最大值之间 中间值的概率最高 最大(小)值的概率约千分之1.5
     */
    public static final int nextGaussianInt(int max) {
        random.setSeed(random.generateSeed(seedLength));
        double ret = random.nextGaussian();
        ret = ret > 3 ? 3 : ret < -3 ? -3 : ret;
        double half = (double) max / 2;
        return (int) Math.round(half + half * ret / 3);
    }

    /**
     *	以string的形式获得定长的随机数字
     *
     * @param n
     * @return
     */
    public static String nextIntAsStringByLength(int n) {
        StringBuilder buf = new StringBuilder();
        for (int j = 0; j < n; j++) {
            buf.append(nextInt(10));
        }
        return buf.toString();
    }

    public static int nextIntByLength(int n) {
        if (n > 9 || n < 1) {
            n = 9;
        }
        StringBuilder buf = new StringBuilder();
        for (int j = 0; j < n; j++) {
            int value = nextInt(10);
            // 首位不能为0，保证最终形成的int位数符号参数要求
            if (j == 0 && value == 0) {
                j--;
                continue;
            }
            buf.append(value);
        }
        return NumberUtil.parseInt(buf.toString());
    }

    /**
     *	随机事件在设定概率内是否发生 <br>
     *
     * @param persent
     * @return
     */
    public static boolean isRandomThingHappen(float persent) {
        if (persent >= 100) {
            return true;
        }
        if (persent == 0) {
            return false;
        }
        int max = 1000000;
        persent = persent * 10000;
        if (System.currentTimeMillis() % 2 == 0) {
            return random.nextInt(max) < persent;
        } else {
            return random.nextInt(max) >= max - persent;
        }
    }

    /**
     *	随机取个颜色
     *
     * @return
     */
    public static Color nextColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }

    /**
     *	给定范围获得随机颜色
     *
     * @param ac range 0-255
     * @param bc range 0-255
     * @return Color
     * @see Color#Color(int, int, int)
     */
    public static Color nextColor(int ac, int bc) {
        int tmp = Math.abs(bc - ac);
        if (tmp > 256) {
            tmp = 256;
        }
        if (tmp <= 0) {
            tmp = 1;
        }
        int min = Math.min(Math.abs(ac), Math.abs(bc));
        int r = min + random.nextInt(tmp);
        int g = min + random.nextInt(tmp);
        int b = min + random.nextInt(tmp);
        return new Color(r, g, b);
    }

    public static String getRandomNameByLength(int length) {
        StringBuilder newRandom = new StringBuilder();
        for (int i = 0; i < length; i++) {
            newRandom.append(seed1[random.nextInt(seed1.length)]);
        }
        return newRandom.toString();
    }

    public static String getRandomPasswordByLength(int length) {
        StringBuilder newRandom = new StringBuilder();
        for (int i = 0; i < length; i++) {
            newRandom.append(seed2[random.nextInt(seed2.length)]);
        }
        return newRandom.toString();
    }

    public static int randomByHashCodeAndNano() {
        int seed = (System.identityHashCode(new Object()) ^ (int) System.nanoTime());
        return xorShift(seed);
    }

    public static int xorShift(int x) {
        x ^= (x << 6);
        x ^= (x >>> 21);
        x ^= (x << 7);
        return x;
    }

    /**
     *	获取列表中随机一项 列表空则返回null
     */
    public static final <T> T getRandomListElement(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(random.nextInt(list.size()));
    }

    /**
     *	获取MAP中随机的key 【效率低 只适合少量数据 】 列表空则返回null
     */
    public static final <T> T getRandomMapKey(Map<T, ?> map) {
        if (map.isEmpty()) {
            return null;
        }
        List<T> list = Lists.newArrayList(map.keySet());
        return getRandomListElement(list);
    }

    /**
     *	获取列表中随机取出并移除一项 列表空则返回null
     */
    public static final <T> T getAndRemoveRandomListElement(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(random.nextInt(list.size()));
    }

    /**
     *	从最小值和最大值间随机一个数字【包含最小/大值】
     */
    public static final int random(int min, int max) {
        if (min == max) {
            return min;
        }
        return (random.nextInt(max - min + 1) + min);
    }

    /**
     *	可见 {@link #random(int, int)}
     *
     * @param start
     * @param end
     * @return
     */
    public static int random(BigInteger start, BigInteger end) {
        return random(start.intValue(), end.intValue());
    }

    /**
     *	标准高斯正态分布 参数是可能取到的最大值 返回的数值在0到最大值之间 中间值的概率最高 最大(小)值的概率约千分之1.5
     */
    public static final int gaussianRandom(int max) {
        double randomInt = random.nextGaussian();
        randomInt = randomInt > 3 ? 3 : randomInt < -3 ? -3 : randomInt;
        double half = (double) max / 2;
        return (int) Math.round(half + half * randomInt / 3);
    }

    /**
     *	是否命中某个概率
     */
    public static final boolean hit(float probability) {
        boolean ret = random.nextFloat() < probability;
        random.setSeed(random.generateSeed(seedLength));
        return ret;
    }

    /**
     *	是否命中某个概率
     */
    public static final boolean hit(SecureRandom random, float probability) {
        random.setSeed(random.generateSeed(seedLength));
        return random.nextFloat() < probability;
    }

    /**
     *	是否命中某个概率
     */
    public static final boolean hit(double probability) {
        boolean ret = random.nextDouble() < probability;
        random.setSeed(random.generateSeed(seedLength));
        return ret;
    }

    public static final boolean hit(SecureRandom random, double probability) {
        random.setSeed(random.generateSeed(seedLength));
        return random.nextDouble() < probability;
    }

    public static final float randomByPercent(float base, DataPair<Integer, Integer> dataPair) {
        if (dataPair == null) {
            return base;
        }
        return randomByPercent(base, dataPair.getObj1(), dataPair.getObj2());
    }

    /**
     *	浮点数版本的
     *
     * @param base
     * @param top
     * @param bottom
     * @return
     */
    public static final float randomByPercent(float base, int top, int bottom) {
        int scale = 10000;
        int tmp1 = (int) (base * scale);
        int tmp2 = randomByPercent(tmp1, top, bottom);
        return tmp2 * 1.0F / scale;
    }

    /**
     *	根据百分比浮动计算值
     *
     * @param base
     * @param top    上限 比如 110
     * @param bottom 下限 比如 90
     * @return
     */
    public static final int randomByPercent(int base, int top, int bottom) {
        float baseRate = 100F;
        if (top == baseRate && bottom == baseRate) {
            return base;
        }
        int topNum = (int) (base * (top / baseRate));
        int bottomNum = (int) (base * (bottom / baseRate));
        return nextInt(bottomNum, topNum);
    }

    public static final int randomByPercent(int base, DataPair<Integer, Integer> dataPair) {
        if (dataPair == null) {
            return base;
        }
        return randomByPercent(base, dataPair.getObj1(), dataPair.getObj2());
    }

    /**
     * @param list
     * @param weightProvider
     * @param callback
     * @param <T>
     * @return
     */
    public static final <T> T weightedRandom(Collection<T> list, IDataProvider<Integer, T> weightProvider, IArgumentRunnable<T> callback) {
        return weightedRandom(random, list, weightProvider, callback);
    }

    /**
     * @param list
     * @param weightProvider 提供一个元素的权重
     * @param callback
     */
    public static final <T> T weightedRandom(SecureRandom random, Collection<T> list, IDataProvider<Integer, T> weightProvider, IArgumentRunnable<T> callback) {
        if (list == null || list.isEmpty()) {
            if (callback != null) {
                callback.run(null);
            }
            return null;
        }
        int total = 0;
        for (T item : list) {
            total += weightProvider.getData(item);
        }
        random.setSeed(random.generateSeed(seedLength));
        int rand = random.nextInt(total) + 1;
        int cursor = 0;
        for (T item : list) {
            int weight = weightProvider.getData(item);
            if (weight < 1)
                continue;
            cursor += weight;
            if (cursor >= rand) {
                if (callback != null) {
                    callback.run(item);
                }
                return item;
            }
        }
        return null;
    }


    /**
     *	加权随机-根据total生成随机数，循环概率，当大于随机数时命中（不会循环到所有的概率）
     *
     * @param weightedMap ID=>权重
     * @return 返回 ID 无法随机则返回null
     */
    public static final <K> K weightedRandom(Map<K, Integer> weightedMap) {
//		log.info(GsonUtil.toJson(weightedMap));
        if(weightedMap == null || weightedMap.size() == 0){
            return null;
        }
        int total = 0;
        for (int weight : weightedMap.values()) {
            if (weight < 1)
                continue;
            total += weight;
        }
        if (total < 1)
            return null;
        random.setSeed(random.generateSeed(seedLength));
        int rand = random.nextInt(total) + 1;
        int cursor = 0;
        for (Entry<K, Integer> entry : weightedMap.entrySet()) {
            int weight = entry.getValue();
            if (weight < 1)
                continue;
            cursor += weight;
            if (cursor >= rand) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     *	加权随机-指定总概率
     *
     * @param weightedMap ID=>权重
     * @return 返回 ID 无法随机则返回null
     */
    public static final <K> K weightedRandom(Map<K, Integer> weightedMap, int top) {
        if(weightedMap == null || weightedMap.size() == 0){
            return null;
        }
        int total = 0;
        for (int weight : weightedMap.values()) {
            if (weight < 1)
                continue;
            total += weight;
        }
        if (total < 1)
            return null;
        random.setSeed(random.generateSeed(seedLength));
        int rand = random.nextInt(top);
        if (rand > total)
            return null;
        int cursor = 0;
        for (Entry<K, Integer> entry : weightedMap.entrySet()) {
            int weight = entry.getValue();
            if (weight < 1)
                continue;
            cursor += weight;
            if (cursor > rand)
                return entry.getKey();
        }
        return null;
    }

    /**
     * @param weightedMap-一键多值权重表
     * @return WeightRet 返回类型
     * @Title: weightedRandom
     * @Description: 加权随机-根据total生成随机数，循环概率，当大于随机数时命中（不会循环到所有的概率）
     */
    public static final <K> WeightRet<K> weightedRandom(ArrayListMultimap<K, Integer> weightedMap) {
        if(weightedMap == null || weightedMap.size() == 0){
            return null;
        }
        int total = 0;
        for (int weight : weightedMap.values()) {
            if (weight < 1)
                continue;
            total += weight;
        }
        if (total < 1)
            return null;
        random.setSeed(random.generateSeed(seedLength));
        int rand = random.nextInt(total) + 1;
        int cursor = 0;
        for (Entry<K, Collection<Integer>> entry : weightedMap.asMap().entrySet()) {
            for (int weight : entry.getValue()) {
                if (weight < 1)
                    continue;
                cursor += weight;
                if (cursor > rand)
                    return new WeightRet<>(entry.getKey(), weight);
            }
        }
        return null;
    }

    public static void swap(int[] I_cun, int[] I_rus, int a, int b) {
        int temp;
        temp = I_cun[a];
        I_cun[a] = I_rus[b];
        I_rus[b] = temp;
    }

    public static double random() {
        try {
            return random.nextDouble();
        } finally {
            random.setSeed(random.generateSeed(20));
        }
    }

//    public static void main(String[] args) {
//        while (true) {
//            System.out.println(nextInt(100, 10000));
//            ThreadUtil.sleep(1000);
//        }
//    }
}
