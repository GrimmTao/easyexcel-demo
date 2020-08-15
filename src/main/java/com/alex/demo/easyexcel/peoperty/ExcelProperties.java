/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.peoperty;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @Author Alex
 * @Created Dec 2020/8/14 10:55
 * @Description
 *              <p>
 */
@Data
@ConfigurationProperties("easyexcel.demo")
@Component
public class ExcelProperties {

	private String datatypeSheetname;

	private String scripttypeSheetname;

	private String algotagSheetname;

	private String algoinnerconfigSheetname;

	private String algooutput2outSheetname;

	private int datatypeHeadnum;

	private int scripttypeHeadnum;

	private int algotagHeadnum;

	private int algoinnerconfigHeadnum;

	private int algooutput2outHeadnum;
}
