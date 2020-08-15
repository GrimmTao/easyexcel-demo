/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.domain;

import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * @Author alex
 * @Created Dec 2020/7/30 16:01
 * @Description
 *              <p>
 */
@Data
public class AlgoInnerConfig {

	private Integer algoID;

	private String algoName;

	private Integer algoGrade;

	private ScriptType scriptType;

	private Map<AlgoTag, String> tagMap;

	private Boolean runingEnable;

	private Boolean storageEnable;

	/**
	 * 算法输入
	 * key:变量名称
	 * value:数据类型
	 */
	private Map<String, DataType> algoImportation;

	/**
	 * 算法内部输出集合
	 */
	private List<AlgoInnerOutput> algoInnerOutputs;

}
