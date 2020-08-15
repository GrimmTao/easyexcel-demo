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
 * @Created Dec 2020/7/30 16:30
 * @Description
 *              <p>
 *              算法主机内配置-算法内部输出-判定变量 NO、YES转换为布尔值
 */
public class AlgoInnerOutputConverter implements Converter<Boolean> {

	private static final String NO = "NO";

	private static final String YES = "YES";

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
		if (NO.equals(stringValue)) {
			return false;
		}
		if (YES.equals(stringValue)) {
			return true;
		}
		return null;
	}

	@Override
	public CellData convertToExcelData(Boolean aBoolean, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration)
			throws Exception {
		return new CellData(aBoolean ? YES : NO);
	}
}
