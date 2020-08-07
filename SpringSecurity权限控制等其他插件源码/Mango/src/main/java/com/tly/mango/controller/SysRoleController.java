package com.tly.mango.controller;

import java.util.List;

import com.tly.mango.constant.SysConstants;
import com.tly.mango.core.page.PageRequest;
import com.tly.mango.entity.SysRole;
import com.tly.mango.entity.SysRoleMenu;
import com.tly.mango.http.HttpResult;
import com.tly.mango.repository.SysRoleMapper;
import com.tly.mango.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 角色控制器
 * @author Louis
 * @date Jan 13, 2019
 */
@RestController
@RequestMapping("role")
public class SysRoleController {

	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody SysRole record) {
		SysRole role = sysRoleService.findById(record.getId());
		if(role != null) {
			if(SysConstants.ADMIN.equalsIgnoreCase(role.getName())) {
				return HttpResult.buildError("超级管理员不允许修改!");
			}
		}
		// 新增角色
		if((record.getId() ==0) && !sysRoleService.findByName(record.getName()).isEmpty()) {
			return HttpResult.buildError("角色名已存在!");
		}
		return HttpResult.buildSuccess(sysRoleService.save(record));
	}

	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysRole> records) {
		return HttpResult.buildSuccess(sysRoleService.delete(records));
	}

	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) throws NoSuchMethodException {
		return HttpResult.buildSuccess(sysRoleService.findPage(pageRequest));
	}
	
	@GetMapping(value="/findAll")
	public HttpResult findAll() {
		return HttpResult.buildSuccess(sysRoleService.findAll());
	}
	
	@GetMapping(value="/findRoleMenus")
	public HttpResult findRoleMenus(@RequestParam Long roleId) {
		return HttpResult.buildSuccess(sysRoleService.findRoleMenus(roleId));
	}
	
	@PostMapping(value="/saveRoleMenus")
	public HttpResult saveRoleMenus(@RequestBody List<SysRoleMenu> records) {
		for(SysRoleMenu record:records) {
			SysRole sysRole = sysRoleMapper.selectByPrimaryKey(record.getRoleId());
			if(SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())) {
				// 如果是超级管理员，不允许修改
				return HttpResult.buildError("超级管理员拥有所有菜单权限，不允许修改！");
			}
		}
		return HttpResult.buildSuccess(sysRoleService.saveRoleMenus(records));
	}
}
