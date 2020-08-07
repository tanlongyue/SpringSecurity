package com.tly.mango.service.impl;

import com.tly.mango.entity.SysUserRole;
import com.tly.mango.repository.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysUserRoleServiceImpl")
public class SysUserRoleServiceImpl implements SysUserRoleMapper {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysUserRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysUserRole record) {
        return sysUserRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUserRole record) {
        return 0;
    }

    @Override
    public SysUserRole selectByPrimaryKey(Long id) {
        return sysUserRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUserRole record) {
        return 0;
    }

    @Override
    public List<SysUserRole> selectAll() {
        return sysUserRoleMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(SysUserRole record) {
        return sysUserRoleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SysUserRole> findUserRoles(Long userId) {
        return null;
    }

    @Override
    public int deleteByUserId(Long userId) {
        return 0;
    }
}
