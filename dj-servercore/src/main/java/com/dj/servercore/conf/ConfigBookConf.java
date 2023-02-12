package com.dj.servercore.conf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dj.domain.config.ConfigBook;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class ConfigBookConf extends BaseConfigConf<ConfigBook> {

	public ConfigBookConf() {
		super(IConfProvider.CONFIG_BOOK);
	}

	private ImmutableMap<Integer, ConfigBook> bookMap;
	private Map<Integer, List<ConfigBook>> bookTypeMap = new HashMap<Integer, List<ConfigBook>>();
	private Map<Integer, Integer> itemBookMap = Maps.newHashMap();
	
	@Override
	public void onLoadOver() {
		bookMap = MapUtil.listToImmMap(dataList, obj -> obj.getBookID());
		bookTypeMap.clear();
		itemBookMap.clear();
		for(ConfigBook book : dataList) {
			List<ConfigBook> list = bookTypeMap.get(book.getType());
			if(list == null) {
				list = Lists.newArrayList();
				bookTypeMap.put(book.getType(), list);
			}
			list.add(book);
			itemBookMap.put(book.getBookID() + 1, book.getBookID());
			itemBookMap.put(book.getBookID() + 2, book.getBookID());
			if(book.getType() == 10) {
				itemBookMap.put(book.getBookID() + 3, book.getBookID());
			}
		}
	}

	public ImmutableMap<Integer, ConfigBook> getBookMap() {
		return getConfig(bookMap);
	}

	public ConfigBook getBook(int id) {
		if(bookMap.containsKey(id)) {
			return getConfig(id, bookMap, false);
		}else {
			return null;
		}
	}
	
	public List<ConfigBook> getBookType(int type){
		if(bookTypeMap.containsKey(type)) {
			return bookTypeMap.get(type);
		}else {
			return new ArrayList<>();
		}
	}

	public int getItemBook(int itemID){
		if(itemID > 0) {
			return MapUtil.getIntValue(itemBookMap, itemID);
		}else{
			return 0;
		}
	}
}
