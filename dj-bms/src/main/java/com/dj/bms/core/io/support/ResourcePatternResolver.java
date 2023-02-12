package com.dj.bms.core.io.support;

import java.io.IOException;

import com.dj.bms.core.io.Resource;
import com.dj.bms.core.io.ResourceLoader;

/**
 * @author zcq
 * @date 2019-11-22
 */
public interface ResourcePatternResolver extends ResourceLoader {

	String CLASSPATH_ALL_URL_PREFIX = "classpath*:";
	
	Resource[] getResources(String locationPattern) throws IOException;
}
