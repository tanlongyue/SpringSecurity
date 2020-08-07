package com.tly.mango.controller;

import java.util.List;

import com.tly.mango.entity.SysMenu;
import com.tly.mango.http.HttpResult;
import com.tly.mango.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 菜单控制器
 * @author Louis
 * @date Jan 13, 2019
 */
@RestController
@RequestMapping("menu")
public class SysMenuController {

	@Autowired
	private SysMenuService sysMenuService;
	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody SysMenu record) {
		return HttpResult.buildSuccess(sysMenuService.save(record));
	}

	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysMenu> records) {
		return HttpResult.buildSuccess(sysMenuService.delete(records));
	}

	@GetMapping(value="/findNavTree")
	public HttpResult findNavTree(@RequestParam String userName) {
		return HttpResult.buildSuccess(sysMenuService.findTree(userName, 1));
	}
	
	@GetMapping(value="/findMenuTree")
	public HttpResult findMenuTree() {
		return HttpResult.buildSuccess(sysMenuService.findTree(null, 0));
	}
}
