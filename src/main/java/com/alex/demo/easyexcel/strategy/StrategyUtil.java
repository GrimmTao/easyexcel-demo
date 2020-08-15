/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alex.demo.easyexcel.domain.sheet.AlgoInnerConfigSheet;
import com.alex.demo.easyexcel.domain.sheet.AlgoOut2OutSheet;

/**
 * @Author alex
 * @Created Dec 2020/8/4 17:08
 * @Description
 *              <p>
 */
public class StrategyUtil {

	public static Map<String, List<RowRangeDto>> addInnerConfigMerStrategy(List<AlgoInnerConfigSheet> excelDtoList, int headNum) {
		Map<String, List<RowRangeDto>> strategyMap = new HashMap<>();
		AlgoInnerConfigSheet model = null;
		for (int i = 0; i < excelDtoList.size(); i++) {
			AlgoInnerConfigSheet currDto = excelDtoList.get(i);
			if (model != null) {
				// 从第二行开始判断是否需要合并
				if (currDto.getAlgoID() == model.getAlgoID()) {// 如果算法ID一样，则可合并算法ID一列
					fillStrategyMap(strategyMap, "1", i + headNum - 1);
					// 如果算法ID一样，且算法名称一样，则可合并算法名称一列
					if (currDto.getAlgoName().equals(model.getAlgoName())) {
						fillStrategyMap(strategyMap, "2", i + headNum - 1);
					}
					// 如果算法ID一样，且算法等级一样，则可合并算法等级一列
					if (currDto.getAlgoGrade() == model.getAlgoGrade()) {
						fillStrategyMap(strategyMap, "3", i + headNum - 1);
					}
					// 如果算法ID一样，且脚本类型一样，则可合并脚本类型一列
					if (currDto.getScriptType() == model.getScriptType()) {
						fillStrategyMap(strategyMap, "4", i + headNum - 1);
					}
					// 如果算法ID一样，且运行使能一样，则可合并运行使能一列
					if (currDto.getRunningEnable() == model.getRunningEnable()) {
						fillStrategyMap(strategyMap, "7", i + headNum - 1);
					}
					// 如果算法ID一样，且存储使能一样，则可合并存储使能一列
					if (currDto.getStorageEnable() == model.getStorageEnable()) {
						fillStrategyMap(strategyMap, "8", i + headNum - 1);
					}
				}
			}
			model = currDto;
		}
		return strategyMap;
	}

	public static Map<String, List<RowRangeDto>> addOut2OutMerStrategy(List<AlgoOut2OutSheet> excelDtoList, int headNum) {
		Map<String, List<RowRangeDto>> strategyMap = new HashMap<>();
		AlgoOut2OutSheet model = null;
		for (int i = 0; i < excelDtoList.size(); i++) {
			AlgoOut2OutSheet currDto = excelDtoList.get(i);
			if (model != null) {
				// 从第二行开始判断是否需要合并
				if (currDto.getComID().equals(model.getComID())) {// 如果comId一样，则可合并comId一列
					fillStrategyMap(strategyMap, "1", i + headNum - 1);
					// 如果comId一样，并且源ip一样，则可合并源ip一列
					if (currDto.getSourceIP().equals(model.getSourceIP())) {
						fillStrategyMap(strategyMap, "2", i + headNum - 1);
					}
				}
			}
			model = currDto;
		}
		return strategyMap;
	}

	private static void fillStrategyMap(Map<String, List<RowRangeDto>> strategyMap, String key, int index) {
		List<RowRangeDto> rowRangeDtoList = strategyMap.get(key) == null ? new ArrayList<>() : strategyMap.get(key);
		boolean flag = false;
		for (RowRangeDto dto : rowRangeDtoList) {
			// 分段list中是否有end索引是上一行索引的，如果有，则索引+1
			if (dto.getEnd() == index) {
				dto.setEnd(index + 1);
				flag = true;
			}
		}
		// 如果没有，则新增分段
		if (!flag) {
			rowRangeDtoList.add(new RowRangeDto(index, index + 1));
		}
		strategyMap.put(key, rowRangeDtoList);
	}
}
