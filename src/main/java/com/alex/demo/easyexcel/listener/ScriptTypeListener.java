/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.listener;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alex.demo.easyexcel.domain.ScriptType;
import com.alex.demo.easyexcel.util.DynamicEnumUtils;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

/**
 * @Author alex
 * @Created Dec 2020/7/30 11:02
 * @Description
 *              <p>
 *              读取【脚本类型】sheet页的 回调监听器
 */
public class ScriptTypeListener extends AnalysisEventListener<Map<Integer, String>> {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	public ScriptTypeListener() {

	}

	@Override
	public void invoke(Map<Integer, String> map, AnalysisContext analysisContext) {
		for (Integer index : map.keySet()) {
			if (index == 1 && !ScriptType.contains(map.get(index))) {
				DynamicEnumUtils.addEnum(ScriptType.class, map.get(index), new Class[] {}, new Object[] {});
			}
		}
	}

	@Override
	public void doAfterAllAnalysed(AnalysisContext analysisContext) {

	}
}
