/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.service;

import java.io.File;
import java.io.IOException;

/**
 * @Author alex
 * @Created Dec 2020/7/31 14:53
 * @Description
 *              <p>
 */
public interface ExcelWriteService {

	void writeExcel(File templateFile) throws IOException;
}
