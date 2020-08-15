/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.converter;

import com.alex.demo.easyexcel.domain.AlgoTag;
import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 * @Author alex
 * @Created Dec 2020/7/30 19:09
 * @Description
 *              <p>
 *              算法主机内配置-算法描述-标签 转换为 {@link AlgoTag} 枚举类
 */
public class AlgoTagConverter implements Converter<AlgoTag> {

	@Override
	public Class supportJavaTypeKey() {
		return AlgoTag.class;
	}

	@Override
	public CellDataTypeEnum supportExcelTypeKey() {
		return CellDataTypeEnum.STRING;
	}

	@Override
	public AlgoTag convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration)
			throws Exception {
		String stringValue = cellData.getStringValue();
		for (AlgoTag tag : AlgoTag.values()) {
			if (tag.name().equals(stringValue)) {
				return tag;
			}
		}
		return null;
	}

	@Override
	public CellData convertToExcelData(AlgoTag algoTag, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration)
			throws Exception {
		return new CellData(algoTag.name());
	}
}
