package com.alex.demo.easyexcel.strategy;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.merge.AbstractMergeStrategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlgoInnerConfigMergeStrategy extends AbstractMergeStrategy {

	/**
	 * 表头行数
	 */
	private int headNum;

	private Map<String, List<RowRangeDto>> strategyMap;

	public AlgoInnerConfigMergeStrategy(Map<String, List<RowRangeDto>> strategyMap, int headNum) {
		this.strategyMap = strategyMap;
		this.headNum = headNum;
	}

	@Override
	protected void merge(Sheet sheet, Cell cell, Head head, Integer relativeRowIndex) {
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
