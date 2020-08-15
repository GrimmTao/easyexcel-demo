/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.domain;

/**
 * @Author alex
 * @Created Dec 2020/7/30 17:46
 * @Description
 *              <p>
 *              算法脚本类型的枚举类
 */
public enum ScriptType {

	Python, C;

	public static boolean contains(String name) {
		for (ScriptType type : ScriptType.values()) {
			if (type.name().equals(name)) {
				return true;
			}
		}
		return false;
	}
}
