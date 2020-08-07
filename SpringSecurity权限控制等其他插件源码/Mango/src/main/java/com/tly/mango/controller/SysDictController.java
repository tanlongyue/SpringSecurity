package com.tly.mango.controller;

import java.util.List;

import com.tly.mango.core.page.PageRequest;
import com.tly.mango.entity.SysDict;
import com.tly.mango.http.HttpResult;
import com.tly.mango.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 字典控制器
 * @author Louis
 * @date Jan 13, 2019
 */
@RestController
@RequestMapping("dict")
public class SysDictController {

	@Autowired
	private SysDictService sysDictService;

	@PreAuthorize("hasAuthority('sys:dict:add') and hasAuthority('sys:dict:edit')")
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody SysDict record) {
		return HttpResult.buildSuccess(sysDictService.save(record));
	}

	@PreAuthorize("hasAuthority('sys:ditc:delete')")
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysDict> records) {
		return HttpResult.buildSuccess(sysDictService.delete(records));
	}

	@PreAuthorize("hasAuthority('sys:dict:view')")
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) throws NoSuchMethodException {
		return HttpResult.buildSuccess(sysDictService.findPage(pageRequest));
	}

	@PreAuthorize("hasAuthority('sys:dict:view')")
	@GetMapping(value="/findByLable")
	public HttpResult findByLable(@RequestParam String lable) {
		return HttpResult.buildSuccess(sysDictService.findByLable(lable));
	}


}
