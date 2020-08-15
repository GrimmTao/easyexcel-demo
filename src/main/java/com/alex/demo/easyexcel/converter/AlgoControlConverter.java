/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 * @Author Alex
 * @Created Dec 2020/7/30 16:24
 * @Description
 *              <p>
 *              算法主机内配置-算法控制 ON、OFF转换为布尔值
 */
public class AlgoControlConverter implements Converter<Boolean> {

	private static final String ON = "ON";

	private static final String OFF = "OFF";

	@Override
	public Class supportJavaTypeKey() {
		return Boolean.class;
	}

	@Override
	public CellDataTypeEnum supportExcelTypeKey() {
		return CellDataTypeEnum.STRING;
	}

	@Override
	public Boolean convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration)
			throws Exception {
		String stringValue = cellData.getStringValue();
		if (ON.equals(stringValue)) {
			return true;
		}
		if (OFF.equals(stringValue)) {
			return false;
		}
		return null;
	}

	@Override
	public CellData convertToExcelData(Boolean aBoolean, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration)
			throws Exception {
		return new CellData(aBoolean ? ON : OFF);
	}

}
