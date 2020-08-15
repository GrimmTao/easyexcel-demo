/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.domain;

import lombok.Data;

/**
 * @Author alex
 * @Created Dec 2020/7/30 16:14
 * @Description
 *              <p>
 *              算法内部输出
 */
@Data
public class AlgoInnerOutput {

	private String varName;

	private Integer byteOffset;

	private Integer bitOffset;

	private Integer length;

	private DataType dataType;

	private String description;

	private Boolean judgment;
}
