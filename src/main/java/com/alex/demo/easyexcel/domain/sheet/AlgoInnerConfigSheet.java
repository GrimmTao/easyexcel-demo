/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.domain.sheet;

import com.alex.demo.easyexcel.converter.*;
import com.alex.demo.easyexcel.domain.AlgoTag;
import com.alex.demo.easyexcel.domain.DataType;
import com.alex.demo.easyexcel.domain.ScriptType;
import com.alibaba.excel.annotation.ExcelProperty;

import lombok.Data;

/**
 * @Author alex
 * @Created Dec 2020/7/30 15:41
 * @Description
 *              <p>
 *              【算法主机内配置】Sheet页
 */
@Data
public class AlgoInnerConfigSheet {

	/**
	 * 算法基本信息-算法ID
	 */
	@ExcelProperty(value = { "算法基本信息", "算法ID" }, index = 1)
	private Integer algoID;

	/**
	 * 算法基本信息-算法名称
	 */
	@ExcelProperty(value = { "算法基本信息", "算法名称" }, index = 2)
	private String algoName;

	/**
	 * 算法基本信息-算法等级
	 */
	@ExcelProperty(value = { "算法基本信息", "算法等级" }, index = 3)
	private Integer algoGrade;

	/**
	 * 算法基本信息-脚本类型
	 */
	@ExcelProperty(value = { "算法基本信息", "脚本类型" }, index = 4, converter = ScriptTypeConverter.class)
	private ScriptType scriptType;

	/**
	 * 算法描述-标签
	 */
	@ExcelProperty(value = { "算法描述", "标签" }, index = 5, converter = AlgoTagConverter.class)
	private AlgoTag tagkey;

	/**
	 * 算法描述-标签值
	 */
	@ExcelProperty(value = { "算法描述", "标签值" }, index = 6)
	private String tagValue;

	/**
	 * 算法控制-运行使能
	 */
	@ExcelProperty(value = { "算法控制", "运行使能" }, index = 7, converter = AlgoControlConverter.class)
	private Boolean runningEnable;

	/**
	 * 算法控制-存储使能
	 */
	@ExcelProperty(value = { "算法控制", "存储使能" }, index = 8, converter = AlgoControlConverter.class)
	private Boolean storageEnable;

	/**
	 * 算法输入-变量名称
	 */
	@ExcelProperty(value = { "算法输入", "变量名称" }, index = 9)
	private String innerVarName;

	/**
	 * 算法输入-数据类型
	 */
	@ExcelProperty(value = { "算法输入", "数据类型" }, index = 10, converter = DataTypeConverter.class)
	private DataType innerDataType;

	/**
	 * 算法内部输出-变量名称
	 */
	@ExcelProperty(value = { "算法内部输出", "变量名称" }, index = 11)
	private String outputVarName;

	/**
	 * 算法内部输出-字节偏移
	 */
	@ExcelProperty(value = { "算法内部输出", "字节偏移" }, index = 12)
	private Integer outputByteoffset;

	/**
	 * 算法内部输出-位偏移
	 */
	@ExcelProperty(value = { "算法内部输出", "位偏移" }, index = 13)
	private Integer outputBitoffset;

	/**
	 * 算法内部输出-长度（bit）
	 */
	@ExcelProperty(value = { "算法内部输出", "长度（bit）" }, index = 14)
	private Integer outputLen;

	/**
	 * 算法内部输出-数据类型
	 */
	@ExcelProperty(value = { "算法内部输出", "数据类型" }, index = 15)
	private String dataType;

	/**
	 * 算法内部输出-描述
	 */
	@ExcelProperty(value = { "算法内部输出", "描述" }, index = 16)
	private String description;

	/**
	 * 算法内部输出-判定变量
	 */
	@ExcelProperty(value = { "算法内部输出", "判定变量" }, index = 17, converter = AlgoInnerOutputConverter.class)
	private Boolean judgment;
}
