package com.tly.mango.service;

import com.tly.mango.core.CurdService;
import com.tly.mango.entity.SysMenu;
import com.tly.mango.entity.SysRole;
import com.tly.mango.entity.SysRoleMenu;

import java.util.List;


/**
 * 角色管理
 * @author Louis
 * @date Jan 13, 2019
 */
public interface SysRoleService extends CurdService<SysRole> {

	/**
	 * 查询全部
	 * @return
	 */
	List<SysRole> findAll();

	/**
	 * 查询角色菜单集合
	 * @return
	 */
	List<SysMenu> findRoleMenus(Long roleId);

	/**
	 * 保存角色菜单
	 * @param records
	 * @return
	 */
	int saveRoleMenus(List<SysRoleMenu> records);

	/**
	 * 根据名称查询
	 * @param name
	 * @return
	 */
	List<SysRole> findByName(String name);

}
