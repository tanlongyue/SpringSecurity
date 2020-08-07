package com.tly.mango.repository;

import java.util.List;

import com.tly.mango.entity.SysUserRole;
import org.apache.ibatis.annotations.Param;


public interface SysUserRoleMapper {

    List<SysUserRole> selectAll();

    int deleteByPrimaryKey(Long id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);

	List<SysUserRole> findUserRoles(@Param(value = "userId") Long userId);

	int deleteByUserId(@Param(value = "userId") Long userId);
}