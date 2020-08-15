/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.service;

import java.io.File;
import java.io.IOException;

/**
 * @Author alex
 * @Created Dec 2020/7/30 11:23
 * @Description
 *              <p>
 */
public interface ExcelReadService {

	void readExcel(File file) throws IOException;

}
