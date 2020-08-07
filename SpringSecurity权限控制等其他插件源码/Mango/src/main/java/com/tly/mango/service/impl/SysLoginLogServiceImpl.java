package com.tly.mango.service.impl;

import java.util.List;

import com.tly.mango.core.page.MyBatisPageHelper;
import com.tly.mango.core.page.PageRequest;
import com.tly.mango.core.page.PageResult;
import com.tly.mango.entity.SysLoginLog;
import com.tly.mango.repository.SysLoginLogMapper;
import com.tly.mango.service.SysLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SysLoginLogServiceImpl  implements SysLoginLogService {

	@Autowired
	private SysLoginLogMapper sysLoginLogMapper;

	@Override
	public int save(SysLoginLog record) {
		if(record.getId() == null || record.getId() == 0) {
			return sysLoginLogMapper.insertSelective(record);
		}
		return sysLoginLogMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(SysLoginLog record) {
		return sysLoginLogMapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<SysLoginLog> records) {
		for(SysLoginLog record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysLoginLog findById(Long id) {
		return sysLoginLogMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) throws NoSuchMethodException {
		Object userName = pageRequest.getParam("userName");
		if(userName != null) {
			return MyBatisPageHelper.findPage(pageRequest, sysLoginLogMapper, "findPageByUserName", userName);
		}
		Object status = pageRequest.getParam("status");
		if(status != null) {
			return MyBatisPageHelper.findPage(pageRequest, sysLoginLogMapper, "findPageByStatus", status);
		}
		return MyBatisPageHelper.findPage(pageRequest, sysLoginLogMapper);
	}
	
}
