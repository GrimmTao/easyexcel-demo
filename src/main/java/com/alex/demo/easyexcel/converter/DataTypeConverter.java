/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.converter;

import com.alex.demo.easyexcel.domain.DataType;
import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 * @Author alex
 * @Created Dec 2020/7/30 19:26
 * @Description
 *              <p>
 */
public class DataTypeConverter implements Converter<DataType> {

	@Override
	public Class supportJavaTypeKey() {
		return DataType.class;
	}

	@Override
	public CellDataTypeEnum supportExcelTypeKey() {
		return CellDataTypeEnum.STRING;
	}

	@Override
	public DataType convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration)
			throws Exception {
		String stringValue = cellData.getStringValue();
		for (DataType type : DataType.values()) {
			if (type.getDesc().equals(stringValue)) {
				return type;
			}
		}
		return null;
	}

	@Override
	public CellData convertToExcelData(DataType dataType, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration)
			throws Exception {
		return new CellData(dataType.getDesc());
	}
}
