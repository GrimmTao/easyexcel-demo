/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.alex.demo.easyexcel.domain.AlgoTag;
import com.alex.demo.easyexcel.domain.DataType;
import com.alex.demo.easyexcel.domain.ScriptType;
import com.alex.demo.easyexcel.domain.sheet.AlgoInnerConfigSheet;
import com.alex.demo.easyexcel.domain.sheet.AlgoOut2OutSheet;
import com.alex.demo.easyexcel.util.BeanConstants;

/**
 * @Author alex
 * @Created Dec 2020/7/31 10:25
 * @Description
 *              <p>
 */
@Component
public class MockData {

	@Bean(BeanConstants.OUTPUT2OUT_MOCK)
	public List<AlgoOut2OutSheet> mockAlgoOut2OutSheet() {
		List<AlgoOut2OutSheet> list = new ArrayList<>();
		AlgoOut2OutSheet model1 = new AlgoOut2OutSheet();
		model1.setComID(1001);
		model1.setSourceIP("127.0.0.1");
		model1.setBusVarName("aa");
		model1.setAlgoID(1);
		model1.setAlgoVarName("AA");

		AlgoOut2OutSheet model2 = new AlgoOut2OutSheet();
		model2.setComID(1001);
		model2.setSourceIP("127.0.0.1");
		model2.setBusVarName("bb");
		model2.setAlgoID(2);
		model2.setAlgoVarName("BB");

		AlgoOut2OutSheet model3 = new AlgoOut2OutSheet();
		model3.setComID(1001);
		model3.setSourceIP("127.0.0.1");
		model3.setBusVarName("cc");
		model3.setAlgoID(3);
		model3.setAlgoVarName("CC");

		AlgoOut2OutSheet model4 = new AlgoOut2OutSheet();
		model4.setComID(1002);
		model4.setSourceIP("127.0.0.1");
		model4.setBusVarName("cc");
		model4.setAlgoID(3);
		model4.setAlgoVarName("CC");

		AlgoOut2OutSheet model5 = new AlgoOut2OutSheet();
		model5.setComID(1002);
		model5.setSourceIP("127.0.0.1");
		model5.setBusVarName("cc");
		model5.setAlgoID(3);
		model5.setAlgoVarName("CC");

		list.add(model1);
		list.add(model2);
		list.add(model3);
		list.add(model4);
		list.add(model5);
		return list;
	}

	@Bean(BeanConstants.INNERCONFIG_MOCK)
	public List<AlgoInnerConfigSheet> mockAlgoInnerConfigSheet() {
		List<AlgoInnerConfigSheet> list = new ArrayList<>();

		for (int i = 0; i < 2; i++) {
			AlgoInnerConfigSheet model1 = new AlgoInnerConfigSheet();
			unifyAttrs(model1, i);
			model1.setTagkey(AlgoTag.列车号);
			model1.setTagValue("10010");
			model1.setInnerVarName("inputVar_1");
			model1.setInnerDataType(DataType.BOOL8);
			model1.setOutputVarName("outputVar_1");
			model1.setOutputByteoffset(1);
			model1.setOutputBitoffset(1);
			model1.setOutputLen(1);
			model1.setDataType(DataType.BITSET2.getDesc());
			model1.setDescription("这是内部输出变量1");
			model1.setJudgment(false);

			AlgoInnerConfigSheet model2 = new AlgoInnerConfigSheet();
			unifyAttrs(model2, i);
			model2.setTagkey(AlgoTag.供应商代码);
			model2.setTagValue("0x01");
			model2.setInnerVarName("inputVar_2");
			model2.setInnerDataType(DataType.INT8);
			model2.setOutputVarName("outputVar_2");
			model2.setOutputByteoffset(2);
			model2.setOutputBitoffset(2);
			model2.setOutputLen(2);
			model2.setDataType(DataType.TIMEDATE32.getDesc());
			model2.setDescription("这是内部输出变量2");
			model2.setJudgment(false);

			AlgoInnerConfigSheet model3 = new AlgoInnerConfigSheet();
			unifyAttrs(model3, i);
			model3.setInnerVarName("inputVar_3");
			model3.setInnerDataType(DataType.BITSET4);
			model3.setOutputVarName("outputVar_3");
			model3.setOutputByteoffset(3);
			model3.setOutputBitoffset(3);
			model3.setOutputLen(3);
			model3.setDataType(DataType.BITSET4.getDesc());
			model3.setDescription("这是内部输出变量3");
			model3.setJudgment(false);

			AlgoInnerConfigSheet model4 = new AlgoInnerConfigSheet();
			unifyAttrs(model4, i);
			model4.setOutputVarName("outputVar_4");
			model4.setOutputByteoffset(4);
			model4.setOutputBitoffset(4);
			model4.setOutputLen(4);
			model4.setDataType(DataType.UTF16.getDesc());
			model4.setDescription("这是内部输出变量4");
			model4.setJudgment(true);

			list.add(model1);
			list.add(model2);
			list.add(model3);
			list.add(model4);
		}
		return list;
	}

	private void unifyAttrs(AlgoInnerConfigSheet model, int algoID) {
		model.setAlgoID(algoID);
		model.setAlgoGrade(3);
		model.setAlgoName("三级算法");
		model.setScriptType(ScriptType.Python);
		model.setRunningEnable(true);
		model.setStorageEnable(true);
	}

	// @Bean
	// public void mockScriptType() {
	// DynamicEnumUtils.addEnum(ScriptType.class, "Python", new Class[] {}, new Object[] {});
	// DynamicEnumUtils.addEnum(ScriptType.class, "C++", new Class[] {}, new Object[] {});
	// DynamicEnumUtils.addEnum(ScriptType.class, "C", new Class[] {}, new Object[] {});
	// }

	// @Bean
	// public void mockAlgoTag() {
	// DynamicEnumUtils.addEnum(AlgoTag.class, "列车号", new Class[] {}, new Object[] {});
	// DynamicEnumUtils.addEnum(AlgoTag.class, "车辆号", new Class[] {}, new Object[] {});
	// DynamicEnumUtils.addEnum(AlgoTag.class, "端号", new Class[] {}, new Object[] {});
	// DynamicEnumUtils.addEnum(AlgoTag.class, "设备编号", new Class[] {}, new Object[] {});
	// DynamicEnumUtils.addEnum(AlgoTag.class, "子系统类型", new Class[] {}, new Object[] {});
	// DynamicEnumUtils.addEnum(AlgoTag.class, "供应商代码", new Class[] {}, new Object[] {});
	// DynamicEnumUtils.addEnum(AlgoTag.class, "算法版本", new Class[] {}, new Object[] {});
	// DynamicEnumUtils.addEnum(AlgoTag.class, "协议版本", new Class[] {}, new Object[] {});
	// }
}
