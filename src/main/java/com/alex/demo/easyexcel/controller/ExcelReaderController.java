/*******************************************************************************
 * Copyright (c) 2020, 2020 Alex.
 ******************************************************************************/
package com.alex.demo.easyexcel.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alex.demo.easyexcel.service.ExcelReadService;
import com.alex.demo.easyexcel.service.ExcelWriteService;

/**
 * @Author alex
 * @Created Dec 2020/7/30 11:21
 * @Description
 *              <p>
 */
@RestController
@RequestMapping("/excelreader")
public class ExcelReaderController {

	@Autowired
	private ExcelReadService readService;

	@Autowired
	private ExcelWriteService writeService;

	@PostMapping("upload")
	public String upload() throws IOException {
		File file = ResourceUtils.getFile("classpath:templates/easyexcel-import.xlsx");
		readService.readExcel(file);
		return "success";
	}

	@PostMapping("export")
	public String export() throws IOException {
		File templateFile = ResourceUtils.getFile("classpath:templates/easyexcel-exportTemplate.xlsx");
		writeService.writeExcel(templateFile);
		return "success";
	}
}
