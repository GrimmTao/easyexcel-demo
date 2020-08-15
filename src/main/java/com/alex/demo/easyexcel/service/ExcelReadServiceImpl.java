/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.demo.easyexcel.domain.AlgoTag;
import com.alex.demo.easyexcel.domain.DataType;
import com.alex.demo.easyexcel.domain.ScriptType;
import com.alex.demo.easyexcel.domain.sheet.AlgoInnerConfigSheet;
import com.alex.demo.easyexcel.domain.sheet.AlgoOut2OutSheet;
import com.alex.demo.easyexcel.listener.*;
import com.alex.demo.easyexcel.peoperty.ExcelProperties;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;

/**
 * @Author alex
 * @Created Dec 2020/7/30 11:23
 * @Description
 *              <p>
 */
@Service
public class ExcelReadServiceImpl implements ExcelReadService {

	@Autowired
	private ExcelProperties properties;

	@Override
	public void readExcel(File file) throws IOException {
		ExcelReader excelReader = EasyExcel.read(file).build();

		DataTypeListener dataTypeListener = new DataTypeListener();
		ReadSheet dataTypeSheet = EasyExcel.readSheet(properties.getDatatypeSheetname()).registerReadListener(dataTypeListener).build();
		dataTypeSheet.setHeadRowNumber(properties.getDatatypeHeadnum());

		ScriptTypeListener algoScriptTypeListener = new ScriptTypeListener();
		ReadSheet scriptTypeSheet = EasyExcel.readSheet(properties.getScripttypeSheetname()).registerReadListener(algoScriptTypeListener).build();
		scriptTypeSheet.setHeadRowNumber(properties.getScripttypeHeadnum());

		AlgoTagListener algoTagListener = new AlgoTagListener();
		ReadSheet algoTagSheet = EasyExcel.readSheet(properties.getAlgotagSheetname()).registerReadListener(algoTagListener).build();
		algoTagSheet.setHeadRowNumber(properties.getAlgotagHeadnum());

		AlgoInnerConfigListener algoInnerConfigListener = new AlgoInnerConfigListener();
		ReadSheet algoInnerConfigSheet = EasyExcel.readSheet(properties.getAlgoinnerconfigSheetname()).head(AlgoInnerConfigSheet.class)
				.registerReadListener(algoInnerConfigListener).build();
		algoInnerConfigSheet.setHeadRowNumber(properties.getAlgoinnerconfigHeadnum());

		AlgoOut2OutListener algoOut2OutListener = new AlgoOut2OutListener();
		ReadSheet algoOutput2OutSheet = EasyExcel.readSheet(properties.getAlgooutput2outSheetname()).head(AlgoOut2OutSheet.class)
				.registerReadListener(algoOut2OutListener).build();
		algoOutput2OutSheet.setHeadRowNumber(properties.getAlgooutput2outHeadnum());

		excelReader.read(dataTypeSheet, scriptTypeSheet, algoTagSheet, algoInnerConfigSheet, algoOutput2OutSheet);
		if (excelReader != null) {
			excelReader.finish();// 此步骤不能少，否则文件太大会导致崩溃
		}
		print();
		// System.out.println(JSON.toJSONString(algoOut2OutListener.getAlgoOut2Outs()));
	}

	private void print() {
		for (DataType type : DataType.values()) {
			System.out.println(type);
		}
		for (ScriptType scriptType : ScriptType.values()) {
			System.out.println(scriptType);
		}
		for (AlgoTag tag : AlgoTag.values()) {
			System.out.println(tag);
		}
		// System.out.println(JSON.toJSONString(algoInnerConfigListener.getAlgoInnerConfigs()));
	}

}
