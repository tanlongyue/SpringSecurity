package com.tly.mango.repository;

import java.util.List;

import com.tly.mango.entity.SysRoleMenu;
import org.apache.ibatis.annotations.Param;


public interface SysRoleMenuMapper {

    List<SysRoleMenu> selectAll();

    int deleteByPrimaryKey(Long id);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

    SysRoleMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleMenu record);

    int updateByPrimaryKey(SysRoleMenu record);

	List<SysRoleMenu> findRoleMenus(@Param(value = "roleId") Long roleId);
	
	List<SysRoleMenu> findAll();

	int deleteByRoleId(@Param(value = "roleId") Long roleId);
}