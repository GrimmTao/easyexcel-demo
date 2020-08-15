/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.strategy;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.merge.AbstractMergeStrategy;

/**
 * @Author alex
 * @Created Dec 2020/7/31 16:18
 * @Description
 *              <p>
 *              自定义【算法对外输出配置】Sheet页 单元格合并策略
 */
public class AlgoOutput2OutMergeStrategy extends AbstractMergeStrategy {

	/**
	 * 表头行数
	 */
	private int headNum;

	private Map<String, List<RowRangeDto>> strategyMap;

	public AlgoOutput2OutMergeStrategy(Map<String, List<RowRangeDto>> strategyMap, int headNum) {
		this.strategyMap = strategyMap;
		this.headNum = headNum;
	}

	@Override
	protected void merge(Sheet sheet, Cell cell, Head head, Integer integer) {
		if (cell.getRowIndex() == headNum && cell.getColumnIndex() == 1) {
			/**
			 * 保证每个cell被合并一次，如果不加上面的判断，因为是一个cell一个cell操作的，
			 * 例如合并A2:A3,当cell为A2时，合并A2,A3，但是当cell为A3时，又是合并A2,A3，
			 * 但此时A2,A3已经是合并的单元格了
			 */
			for (Map.Entry<String, List<RowRangeDto>> entry : strategyMap.entrySet()) {
				Integer columnIndex = Integer.valueOf(entry.getKey());
				entry.getValue().forEach(rowRange -> {
					// 添加一个合并请求
					CellRangeAddress cellRangeAddress = new CellRangeAddress(rowRange.getStart(), rowRange.getEnd(), columnIndex, columnIndex);
					sheet.addMergedRegionUnsafe(cellRangeAddress);
				});
			}
		}
	}

}
