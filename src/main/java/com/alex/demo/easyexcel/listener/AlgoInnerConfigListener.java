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

import com.alex.demo.easyexcel.domain.*;
import com.alex.demo.easyexcel.domain.sheet.AlgoInnerConfigSheet;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import lombok.Getter;

/**
 * @Author Alex
 * @Created Dec 2020/7/30 15:55
 * @Description
 *              <p>
 */
public class AlgoInnerConfigListener extends AnalysisEventListener<AlgoInnerConfigSheet> {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Getter
	private List<AlgoInnerConfig> algoInnerConfigs = new ArrayList<>();

	@Override
	public void invoke(AlgoInnerConfigSheet model, AnalysisContext analysisContext) {
		Integer algoID = model.getAlgoID();
		Integer algoGrade = model.getAlgoGrade();
		String algoName = model.getAlgoName();
		ScriptType scriptType = model.getScriptType();
		Boolean runningEnable = model.getRunningEnable();
		Boolean storageEnable = model.getStorageEnable();
		AlgoTag tagkey = model.getTagkey();
		String tagValue = model.getTagValue();
		String innerVarName = model.getInnerVarName();
		DataType innerDataType = model.getInnerDataType();
		String outputVarName = model.getOutputVarName();
		Integer outputByteoffset = model.getOutputByteoffset();
		Integer outputBitoffset = model.getOutputBitoffset();
		Integer outputLen = model.getOutputLen();
		String description = model.getDescription();
		Boolean judgment = model.getJudgment();
		boolean b1 = tagkey != null && tagValue != null;
		boolean b2 = innerVarName != null && innerDataType != null;
		boolean b3 = outputVarName != null && outputByteoffset != null && outputBitoffset != null && outputLen != null && description != null
				&& judgment != null;
		if (algoID != null && algoGrade != null && algoName != null && scriptType != null && runningEnable != null && storageEnable != null) {
			AlgoInnerConfig innerConfig = new AlgoInnerConfig();
			innerConfig.setAlgoID(algoID);
			innerConfig.setAlgoGrade(algoGrade);
			innerConfig.setAlgoName(algoName);
			innerConfig.setScriptType(scriptType);
			innerConfig.setRuningEnable(runningEnable);
			innerConfig.setStorageEnable(storageEnable);
			Map<AlgoTag, String> tagMap = new HashMap<>();
			if (b1) {
				tagMap.put(tagkey, tagValue);
			}
			Map<String, DataType> algoImportation = new HashMap<>();
			if (b2) {
				algoImportation.put(innerVarName, innerDataType);
			}
			List<AlgoInnerOutput> algoInnerOutputs = new ArrayList<>();
			if (b3) {
				AlgoInnerOutput algoInnerOutput = new AlgoInnerOutput();
				algoInnerOutput.setVarName(outputVarName);
				algoInnerOutput.setByteOffset(outputByteoffset);
				algoInnerOutput.setBitOffset(outputBitoffset);
				algoInnerOutput.setLength(outputLen);
				algoInnerOutput.setDescription(description);
				algoInnerOutput.setJudgment(judgment);
				algoInnerOutputs.add(algoInnerOutput);
			}
			innerConfig.setTagMap(tagMap);
			innerConfig.setAlgoImportation(algoImportation);
			innerConfig.setAlgoInnerOutputs(algoInnerOutputs);
			algoInnerConfigs.add(innerConfig);
		} else {
			AlgoInnerConfig innerConfig = algoInnerConfigs.get(algoInnerConfigs.size() - 1);
			if (b1) {
				innerConfig.getTagMap().put(tagkey, tagValue);
			}
			if (b2) {
				innerConfig.getAlgoImportation().put(innerVarName, innerDataType);
			}
			if (b3) {
				AlgoInnerOutput algoInnerOutput = new AlgoInnerOutput();
				algoInnerOutput.setVarName(outputVarName);
				algoInnerOutput.setByteOffset(outputByteoffset);
				algoInnerOutput.setBitOffset(outputBitoffset);
				algoInnerOutput.setLength(outputLen);
				algoInnerOutput.setDescription(description);
				algoInnerOutput.setJudgment(judgment);
				innerConfig.getAlgoInnerOutputs().add(algoInnerOutput);
			}
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
