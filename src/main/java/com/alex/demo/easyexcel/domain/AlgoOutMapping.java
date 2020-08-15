/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author alex
 * @Created Dec 2020/7/30 14:01
 * @Description
 *              <p>
 *              算法输出映射
 */
@Data
@AllArgsConstructor
public class AlgoOutMapping {

	/**
	 * 算法ID
	 */
	private Integer algoID;

	/**
	 * 变量名称
	 */
	private String varName;
}
