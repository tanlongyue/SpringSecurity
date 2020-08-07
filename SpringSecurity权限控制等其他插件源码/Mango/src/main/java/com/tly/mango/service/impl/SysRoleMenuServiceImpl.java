package com.tly.mango.service.impl;

import com.tly.mango.entity.SysRoleMenu;
import com.tly.mango.repository.SysRoleMenuMapper;
import com.tly.mango.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysRoleMenuServiceImpl")
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysRoleMenuMapper.deleteByPrimaryKey(id);

    }

    @Override
    public int insert(SysRoleMenu record) {
        return sysRoleMenuMapper.insert(record);
    }

    @Override
    public SysRoleMenu selectByPrimaryKey(Long id) {
        return sysRoleMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SysRoleMenu> selectAll() {
        return sysRoleMenuMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(SysRoleMenu record) {
        return sysRoleMenuMapper.updateByPrimaryKey(record);
    }
}
