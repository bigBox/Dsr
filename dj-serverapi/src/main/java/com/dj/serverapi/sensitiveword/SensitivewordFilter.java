package com.dj.serverapi.sensitiveword;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Maps;

import lombok.Setter;

/**
 * @Description: 敏感词过滤
 */
@SuppressWarnings({"rawtypes", "unchecked","deprecation"})
public class SensitivewordFilter {
	@Setter
	private static Map sensitiveWordMap = Maps.newHashMap();
	public static int minMatchTYpe = 1; // 最小匹配规则
	public static int maxMatchType = 2; // 最大匹配规则

	public static void init() {
		reload();
	}

	private SensitivewordFilter() {
	}

	/**
	 *	初始化敏感词库
	 */
	public static void reload() {
		synchronized (sensitiveWordMap) {
			sensitiveWordMap = new SensitiveWordInit().initKeyWord();
		}
	}

	public static boolean isContainSensitiveWord(String txt) {
		// 删除无用的干扰字符-大小写字母、数字以及标点符号等
		String txtTmp = StringUtils.removePattern(txt,"[a-zA-Z\\d+\\s*|\t|\r|\n`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]");
		return isContainSensitiveWord(txtTmp, 2);
	}

	/**
	 *	判断文字是否包含敏感字符
	 * @param txt  文字
	 * @param matchType  匹配规则&nbsp;1：最小匹配规则，2：最大匹配规则
	 * @return 若包含返回true，否则返回false
	 */
	public static boolean isContainSensitiveWord(String txt, int matchType) {
		String txtTmp = StringUtils.removePattern(txt,"[a-zA-Z\\d+\\s*|\t|\r|\n`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]");
		boolean flag = false;
		for (int i = 0; i < txtTmp.length(); i++) {
			int matchFlag = CheckSensitiveWord(txtTmp, i, matchType); // 判断是否包含敏感字符
			if (matchFlag > 0) { // 大于0存在，返回true
				flag = true;
			}
		}
		return flag;
	}

	/**
	 *	获取文字中的敏感词
	 * @param txt    文字
	 * @param matchType   匹配规则&nbsp;1：最小匹配规则，2：最大匹配规则
	 * @return
	 */
	public static Set<String> getSensitiveWord(String txt, int matchType) {
		Set<String> sensitiveWordList = new HashSet<String>();
		for (int i = 0; i < txt.length(); i++) {
			int length = CheckSensitiveWord(txt, i, matchType); // 判断是否包含敏感字符
			if (length > 0) { // 存在,加入list中
				sensitiveWordList.add(txt.substring(i, i + length));
				i = i + length - 1; // 减1的原因，是因为for会自增
			}
		}
		return sensitiveWordList;
	}

	/**
	 *	替换敏感字字符
	 * 
	 * @param txt
	 * @param matchType
	 * @param replaceChar  替换字符，默认*
	 */
	public static String replaceSensitiveWord(String txt, int matchType, String replaceChar) {
		for (int i = 0; i < txt.length(); i++) {
			int length = CheckSensitiveWord(txt, i, matchType); // 判断是否包含敏感字符
			if (length > 0) { // 存在,加入list中
				txt = txt.replace(txt.substring(i, i + length), getReplaceChars(replaceChar, length));
				i = i + length - 1; // 减1的原因，是因为for会自增
			}
		}
		return txt;
	}

	/**
	 *	获取替换字符串
	 * @param replaceChar
	 * @param length
	 * @return
	 */
	private static String getReplaceChars(String replaceChar, int length) {
		String resultReplace = replaceChar;
		for (int i = 1; i < length; i++) {
			resultReplace += replaceChar;
		}
		return resultReplace;
	}

	/**
	 *	检查文字中是否包含敏感字符，检查规则如下：<br>
	 * 
	 * @param txt
	 * @param beginIndex
	 * @param matchType
	 * @return，如果存在，则返回敏感词字符的长度，不存在返回0
	 */
	public static int CheckSensitiveWord(String txt, int beginIndex, int matchType) {
		boolean flag = false; // 敏感词结束标识位：用于敏感词只有1位的情况
		int matchFlag = 0; // 匹配标识数默认为0
		char word;
		Map nowMap = sensitiveWordMap;
		for (int i = beginIndex; i < txt.length(); i++) {
			word = txt.charAt(i);
			if (nowMap != null) {
				nowMap = (Map) nowMap.get(word); // 获取指定key
				if (nowMap != null) { // 存在，则判断是否为最后一个
					matchFlag++; // 找到相应key，匹配标识+1
					if ("1".equals(nowMap.get("isEnd"))) { // 如果为最后一个匹配规则,结束循环，返回匹配标识数
						flag = true; // 结束标志位为true
						if (SensitivewordFilter.minMatchTYpe == matchType) { // 最小规则，直接返回,最大规则还需继续查找
							break;
						}
					}
				} else { // 不存在，直接返回
					break;
				}
			} else {
				matchFlag++;
			}
		}
		if (matchFlag < 2 || !flag) { // 长度必须大于等于1，为词
			matchFlag = 0;
		}
		return matchFlag;
	}

	/**
	 *	直接替换成“*”
	 * 
	 * @param str
	 * @return
	 */
	public static String replaceSensitiveWord(String str) {
		try {
			// 最小规则(1)，直接返回,最大规则还需继续查找
			return SensitivewordFilter.replaceSensitiveWord(str, 2, "*");
		} catch (Exception e) {
			e.printStackTrace();
			return str;
		}
	}

	public static String toString(Map<String, Object> map) {
		Set<Entry<String, Object>> s = map.entrySet();
		StringBuffer sb = new StringBuffer("{");
		int i = 0;
		for (Entry<String, Object> e : s) {
			sb.append("[\"");
			sb.append(String.valueOf(e.getKey()));
			sb.append("\"]");
			sb.append("=");
			if (e.getValue() instanceof Map) {
				String mapS = toString((Map) e.getValue());
				sb.append(mapS);
			} else {
				sb.append("\"");
				sb.append(e.getValue());
				sb.append("\"");
			}
			i++;
			if (i != s.size())// 最后一个循环
				sb.append(",");
		}
		sb.append("}");
		return sb.toString();
	}
}
