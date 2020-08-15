/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alex.demo.easyexcel.domain.AlgoOut2Out;
import com.alex.demo.easyexcel.domain.AlgoOutMapping;
import com.alex.demo.easyexcel.domain.sheet.AlgoOut2OutSheet;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import lombok.Getter;

/**
 * @Author alex
 * @Created Dec 2020/7/30 14:25
 * @Description
 *              <p>
 */
public class AlgoOut2OutListener extends AnalysisEventListener<AlgoOut2OutSheet> {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Getter
	private List<AlgoOut2Out> algoOut2Outs = new ArrayList<>();

	@Override
	public void invoke(AlgoOut2OutSheet model, AnalysisContext analysisContext) {
		if (model.getComID() != null && model.getSourceIP() != null) {
			AlgoOut2Out algoOut2Out = new AlgoOut2Out();
			algoOut2Out.setComID(model.getComID());
			algoOut2Out.setSourceIP(model.getSourceIP());
			List<Map<String, AlgoOutMapping>> list = new ArrayList<>();
			Map<String, AlgoOutMapping> map = new HashMap<>();
			map.put(model.getBusVarName(), new AlgoOutMapping(model.getAlgoID(), model.getAlgoVarName()));
			list.add(map);
			algoOut2Out.setList(list);
			algoOut2Outs.add(algoOut2Out);
		} else {
			Map<String, AlgoOutMapping> map = new HashMap<>();
			map.put(model.getBusVarName(), new AlgoOutMapping(model.getAlgoID(), model.getAlgoVarName()));
			AlgoOut2Out algoOut2Out = algoOut2Outs.get(algoOut2Outs.size() - 1);
			algoOut2Out.getList().add(map);
		}
	}

	@Override
	public void doAfterAllAnalysed(AnalysisContext analysisContext) {

	}

	@Override
	public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
		super.invokeHeadMap(headMap, context);
		// TODO 校验表头正误
	}
}
