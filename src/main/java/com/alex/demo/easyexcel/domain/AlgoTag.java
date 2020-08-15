/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.domain;

/**
 * @Author alex
 * @Created Dec 2020/7/29 19:32
 * @Description
 *              <p>
 *              【算法标签】的枚举类
 */
public enum AlgoTag {

	列车号, 车辆号, 端号, 设备编号, 子系统类型, 供应商代码, 算法版本, 协议版本;

	public static boolean contains(String tag) {
		for (AlgoTag algoTag : AlgoTag.values()) {
			if (algoTag.name().equals(tag)) {
				return true;
			}
		}
		return false;
	}

}
