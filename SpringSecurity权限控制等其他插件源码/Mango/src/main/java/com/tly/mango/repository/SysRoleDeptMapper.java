package com.tly.mango.repository;


import com.tly.mango.entity.SysRoleDept;

import java.util.List;

public interface SysRoleDeptMapper {

    List<SysRoleDept> selectAll();

    int deleteByPrimaryKey(Long id);

    int insert(SysRoleDept record);

    int insertSelective(SysRoleDept record);

    SysRoleDept selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleDept record);

    int updateByPrimaryKey(SysRoleDept record);
}