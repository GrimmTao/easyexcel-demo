/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.domain.sheet;

import com.alibaba.excel.annotation.ExcelProperty;

import lombok.Data;

/**
 * @Author alex
 * @Created Dec 2020/7/30 13:59
 * @Description
 *              <p>
 *              【算法对外输出配置】sheet页
 */
@Data
public class AlgoOut2OutSheet {

	@ExcelProperty(value = { "总线报文", "ComId" }, index = 1)
	private Integer comID;

	/**
	 * 源IP
	 */
	@ExcelProperty(value = { "总线报文", "源ip" }, index = 2)
	private String sourceIP;

	/**
	 * 总线变量名称
	 */
	@ExcelProperty(value = { "总线报文", "变量名称" }, index = 3)
	private String busVarName;

	/**
	 * 算法ID
	 */
	@ExcelProperty(value = { "算法输出映射", "算法ID" }, index = 4)
	private Integer algoID;

	/**
	 * 算法变量名称
	 */
	@ExcelProperty(value = { "算法输出映射", "变量名称" }, index = 5)
	private String algoVarName;
}
