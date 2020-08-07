package com.tly.mango.service.impl;

import com.tly.mango.entity.SysRoleDept;
import com.tly.mango.repository.SysRoleDeptMapper;
import com.tly.mango.service.SysRoleDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysRoleDeptServiceImpl")
public class SysRoleDeptServiceImpl implements SysRoleDeptService {

    @Autowired
    private SysRoleDeptMapper sysRoleDeptMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysRoleDeptMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysRoleDept record) {
        return sysRoleDeptMapper.insert(record);
    }

    @Override
    public SysRoleDept selectByPrimaryKey(Long id) {
        return sysRoleDeptMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SysRoleDept> selectAll() {
        return sysRoleDeptMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(SysRoleDept record) {
        return sysRoleDeptMapper.updateByPrimaryKey(record);
    }
}
