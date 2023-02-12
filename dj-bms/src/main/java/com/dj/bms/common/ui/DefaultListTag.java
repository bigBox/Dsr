package com.dj.bms.common.ui;

import com.dj.bms.common.ui.support.TableTagTdSupport;
import com.dj.bms.common.ui.support.TableTagThSupport;

/**
 * 默认的表格标签
 * 
 * @author zcq
 * @date 2020-03-03
 * @since 3.0
 */
@SuppressWarnings("serial")
public class DefaultListTag extends AbstractListTag {

	@Override
	protected TableTagThSupport getTableTagThSupport() {
		return null;
	}

	protected TableTagTdSupport getTableTagTdSupport() {
		return null;
	}

}
