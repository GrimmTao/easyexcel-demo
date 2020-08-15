/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.domain;

/**
 * @Author alex
 * @Created Dec 2020/7/30 19:17
 * @Description
 *              <p>
 *              数据类型的枚举类
 */
public enum DataType {

	BOOL8("bool", 1), //
	BITSET2("B2", 2), //
	BITSET3("B3", 3), //
	BITSET4("B4", 4), //
	BITSET5("B5", 5), //
	BITSET6("B6", 6), //
	BITSET7("B7", 7), //
	BITSET8("B8", 8), //
	CHAR8("CHA8", 8), //
	UTF16("UTF16", 16), //
	INT8("INT8", 8), //
	INT16("INT16", 16), //
	INT32("INT32", 32), //
	INT64("INT64", 64), //
	UINT8("UN8", 8), //
	UINT16("UN16", 16), //
	UINT32("UN32", 32), //
	UINT64("UN64", 64), //
	REAL32("RL32", 32), //
	REAL64("RL64", 64), //
	TIMEDATE32("TD32", 32), //
	TIMEDATE48("TD48", 48), //
	TIMEDATE64("TD64", 64);//

	/**
	 * 填表类型
	 */
	private final String desc;

	private final Integer length;

	DataType(String desc, Integer length) {
		this.desc = desc;
		this.length = length;
	}

	public String getDesc() {
		return desc;
	}

	public Integer getLength() {
		return length;
	}

	public static boolean contains(String type) {
		for (DataType dataType : DataType.values()) {
			if (dataType.name().equals(type)) {
				return true;
			}
		}
		return false;
	}

}
