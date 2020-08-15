/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author alex
 * @Created Dec 2020/8/4 17:09
 * @Description
 *              <p>
 *              合并行的起止位置DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RowRangeDto {

	private int start;

	private int end;
}
