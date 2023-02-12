package com.dj.servertool.module.warpper;

import java.util.List;

import com.dj.servertool.core.common.node.TreeviewNode;

/**
 * 部门列表树的包装
 */
public class DeptTreeWrapper {

	public static void clearNull(List<TreeviewNode> list) {
		if (list == null) {
			return;
		} else {
			if (list.size() == 0) {
				return;
			} else {
				for (TreeviewNode node : list) {
					if (node.getNodes() != null) {
						if (node.getNodes().size() == 0) {
							node.setNodes(null);
						} else {
							clearNull(node.getNodes());
						}
					}
				}
			}
		}
	}
}
