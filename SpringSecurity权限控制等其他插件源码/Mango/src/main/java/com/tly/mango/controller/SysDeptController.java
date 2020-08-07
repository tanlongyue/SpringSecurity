package com.tly.mango.controller;

import java.util.List;

import com.tly.mango.entity.SysDept;
import com.tly.mango.http.HttpResult;
import com.tly.mango.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 机构控制器
 * @author Louis
 * @date Jan 13, 2019
 */
@RestController
@RequestMapping("dept")
public class SysDeptController {

	@Autowired
	private SysDeptService sysDeptService;
	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody SysDept record) {
		return HttpResult.buildSuccess(sysDeptService.save(record));
	}

	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysDept> records) {
		return HttpResult.buildSuccess(sysDeptService.delete(records));
	}

	@GetMapping(value="/findTree")
	public HttpResult findTree() {
		return HttpResult.buildSuccess(sysDeptService.findTree());
	}

}
