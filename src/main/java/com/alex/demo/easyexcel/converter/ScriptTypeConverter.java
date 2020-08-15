/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.converter;

import com.alex.demo.easyexcel.domain.ScriptType;
import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 * @Author alex
 * @Created Dec 2020/7/30 19:00
 * @Description
 *              <p>
 *              算法主机内配置-算法基本信息-脚本类型 转换为 {@link ScriptType} 枚举类
 */
public class ScriptTypeConverter implements Converter<ScriptType> {

	@Override
	public Class supportJavaTypeKey() {
		return ScriptType.class;
	}

	@Override
	public CellDataTypeEnum supportExcelTypeKey() {
		return CellDataTypeEnum.STRING;
	}

	@Override
	public ScriptType convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration)
			throws Exception {
		String stringValue = cellData.getStringValue();
		for (ScriptType type : ScriptType.values()) {
			if (type.name().equals(stringValue)) {
				return type;
			}
		}
		return null;
	}

	@Override
	public CellData convertToExcelData(ScriptType algoScriptType, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration)
			throws Exception {
		return new CellData(algoScriptType.name());
	}
}
