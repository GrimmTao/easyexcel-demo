/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex
 ******************************************************************************/
package com.alex.demo.easyexcel.listener;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alex.demo.easyexcel.domain.AlgoTag;
import com.alex.demo.easyexcel.util.DynamicEnumUtils;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

/**
 * @Author alex
 * @Created Dec 2020/7/30 9:48
 * @Description
 *              <p>
 *              读取【算法标签】sheet页的 回调监听器
 */
public class AlgoTagListener extends AnalysisEventListener<Map<Integer, String>> {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	private int headerRowNo = 0;

	public AlgoTagListener() {
	}

	/**
	 * 每一条数据解析都会来调用
	 * 
	 * @param map
	 * @param analysisContext
	 */
	@Override
	public void invoke(Map<Integer, String> map, AnalysisContext analysisContext) {
		for (Integer index : map.keySet()) {
			if (index == 1 && !AlgoTag.contains(map.get(index))) {
				DynamicEnumUtils.addEnum(AlgoTag.class, map.get(index), new Class[] {}, new Object[] {});
			}
		}
	}

	/**
	 * 所有数据解析完了，会来调用
	 * 
	 * @param analysisContext
	 */
	@Override
	public void doAfterAllAnalysed(AnalysisContext analysisContext) {

	}

	@Override
	public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
		super.invokeHeadMap(headMap, context);
		headerRowNo++;
		// System.out.println("headerRowNo: " + headerRowNo);
		if (headerRowNo == 17) {
			// log.info("解析到一条头数据：{}", JSON.toJSONString(headMap));
			// TODO 可校验表头内容是否正确，不正确说明Excel模板有问题
		}
	}
}
