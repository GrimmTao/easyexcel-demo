/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.alex.demo.easyexcel.domain.AlgoTag;
import com.alex.demo.easyexcel.domain.DataType;
import com.alex.demo.easyexcel.domain.ScriptType;
import com.alex.demo.easyexcel.domain.sheet.AlgoInnerConfigSheet;
import com.alex.demo.easyexcel.domain.sheet.AlgoOut2OutSheet;
import com.alex.demo.easyexcel.peoperty.ExcelProperties;
import com.alex.demo.easyexcel.strategy.AlgoInnerConfigMergeStrategy;
import com.alex.demo.easyexcel.strategy.AlgoOutput2OutMergeStrategy;
import com.alex.demo.easyexcel.strategy.RowRangeDto;
import com.alex.demo.easyexcel.strategy.StrategyUtil;
import com.alex.demo.easyexcel.util.BeanConstants;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;

/**
 * @Author Alex
 * @Created Dec 2020/7/31 14:54
 * @Description
 *              <p>
 */
@Service
public class ExcelWriteServiceImpl implements ExcelWriteService {

	@Autowired
	private ExcelProperties properties;

	@Autowired
	@Qualifier(BeanConstants.OUTPUT2OUT_MOCK)
	private List<AlgoOut2OutSheet> algoOut2OutSheetList;

	@Autowired
	@Qualifier(BeanConstants.INNERCONFIG_MOCK)
	private List<AlgoInnerConfigSheet> algoInnerConfigSheetList;

	private File destFile;

	@Override
	public void writeExcel(File templateFile) throws IOException {
		ExcelWriter excelWriter = null;
		File exportFolder = ResourceUtils.getFile("classpath:templates");

		try {
			destFile = new File(exportFolder.getAbsolutePath() + File.separator + System.currentTimeMillis() + ".xlsx");
			excelWriter = EasyExcel.write(destFile).needHead(Boolean.FALSE).withTemplate(templateFile).build();
			writeDataTypeSheet(excelWriter);
			writeScriptTypeSheet(excelWriter);
			writeAlgoTagSheet(excelWriter);
			writeAlgoInnerConfigSheet(excelWriter);
			writeAlgoIOutput2OutSheet(excelWriter);
		} finally {
			// 千万别忘记finish 会帮忙关闭流
			if (excelWriter != null) {
				excelWriter.finish();
			}
		}
	}

	/**
	 * 写【类型声明(TRDP)】Sheet页
	 */
	private void writeDataTypeSheet(ExcelWriter excelWriter) {
		WriteSheet dataTypeSheet = EasyExcel.writerSheet(properties.getDatatypeSheetname()).build();
		List<List<Object>> list = new ArrayList<>();
		for (DataType dataType : DataType.values()) {
			List<Object> aa = new ArrayList<>();
			aa.add(dataType.name());
			aa.add(dataType.getDesc());
			aa.add(dataType.getLength());
			list.add(aa);
		}
		excelWriter.write(list, dataTypeSheet);
	}

	/**
	 * 写【脚本类型】Sheet页
	 */
	private void writeScriptTypeSheet(ExcelWriter excelWriter) {
		WriteSheet scriptTypeSheet = EasyExcel.writerSheet(properties.getScripttypeSheetname()).build();
		List<List<String>> list = new ArrayList<>();
		for (ScriptType type : ScriptType.values()) {
			List<String> scriptTypes = new ArrayList<>();
			scriptTypes.add(type.name());
			list.add(scriptTypes);
		}
		excelWriter.write(list, scriptTypeSheet);
	}

	/**
	 * 写【算法标签】Sheet页
	 */
	private void writeAlgoTagSheet(ExcelWriter excelWriter) {
		WriteSheet algoTagSheet = EasyExcel.writerSheet(properties.getAlgotagSheetname()).build();
		List<List<String>> list = new ArrayList<>();
		for (AlgoTag tag : AlgoTag.values()) {
			List<String> algoTags = new ArrayList<>();
			algoTags.add(tag.name());
			list.add(algoTags);
		}
		excelWriter.write(list, algoTagSheet);
	}

	/**
	 * 写【算法主机内配置】sheet页
	 */
	private void writeAlgoInnerConfigSheet(ExcelWriter excelWriter) {
		Map<String, List<RowRangeDto>> algoInnerConfigStrategyMap = StrategyUtil.addInnerConfigMerStrategy(algoInnerConfigSheetList,
				properties.getAlgoinnerconfigHeadnum());
		AlgoInnerConfigMergeStrategy innerConfigMergeStrategy = new AlgoInnerConfigMergeStrategy(algoInnerConfigStrategyMap,
				properties.getAlgoinnerconfigHeadnum());
		WriteSheet algoInnerConfigSheet = EasyExcel.writerSheet(properties.getAlgoinnerconfigSheetname()).head(AlgoInnerConfigSheet.class)
				.registerWriteHandler(innerConfigMergeStrategy).build();
		excelWriter.write(algoInnerConfigSheetList, algoInnerConfigSheet);
	}

	/**
	 * 写【算法对外输出配置】sheet页
	 */
	private void writeAlgoIOutput2OutSheet(ExcelWriter excelWriter) {
		Map<String, List<RowRangeDto>> out2OutStrategyMap = StrategyUtil.addOut2OutMerStrategy(algoOut2OutSheetList,
				properties.getAlgooutput2outHeadnum());
		AlgoOutput2OutMergeStrategy outputMergeStrategy = new AlgoOutput2OutMergeStrategy(out2OutStrategyMap, properties.getAlgooutput2outHeadnum());
		WriteSheet algoOutput2OutSheet = EasyExcel.writerSheet(properties.getAlgooutput2outSheetname()).head(AlgoOut2OutSheet.class)
				.registerWriteHandler(outputMergeStrategy).build();
		excelWriter.write(algoOut2OutSheetList, algoOutput2OutSheet);
	}
}
