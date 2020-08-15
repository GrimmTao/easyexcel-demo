/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.listener;

import java.util.Map;

import com.alex.demo.easyexcel.domain.DataType;
import com.alex.demo.easyexcel.util.DynamicEnumUtils;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

/**
 * @Author alex
 * @Created Dec 2020/7/30 19:27
 * @Description
 *              <p>
 */
public class DataTypeListener extends AnalysisEventListener<Map<Integer, String>> {

	@Override
	public void invoke(Map<Integer, String> map, AnalysisContext analysisContext) {
		if (!DataType.contains(map.get(2))) {
			DynamicEnumUtils.addEnum(DataType.class, map.get(2), new Class[] { java.lang.String.class, java.lang.Integer.class },
					new Object[] { map.get(3), Integer.valueOf(map.get(4)) });
		}
	}

	@Override
	public void doAfterAllAnalysed(AnalysisContext analysisContext) {

	}

	@Override
	public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
		super.invokeHeadMap(headMap, context);
		// TODO 校验表头内容是否正确
	}
}
