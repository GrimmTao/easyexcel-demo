/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.domain;

import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * @Author alex
 * @Created Dec 2020/7/30 15:04
 * @Description
 *              <p>
 *              供程序使用的“算法对外输出配置”模型
 */
@Data
public class AlgoOut2Out {

	private Integer comID;

	/**
	 * 源IP
	 */
	private String sourceIP;

	private List<Map<String, AlgoOutMapping>> list;

}
