package com.tly.mango.service.impl;

import java.util.List;

import com.tly.mango.core.page.MyBatisPageHelper;
import com.tly.mango.core.page.PageRequest;
import com.tly.mango.core.page.PageResult;
import com.tly.mango.entity.SysLog;
import com.tly.mango.repository.SysLogMapper;
import com.tly.mango.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SysLogServiceImpl  implements SysLogService {

	@Autowired
	private SysLogMapper sysLogMapper;

	@Override
	public int save(SysLog record) {
		if(record.getId() == null || record.getId() == 0) {
			return sysLogMapper.insertSelective(record);
		}
		return sysLogMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(SysLog record) {
		return sysLogMapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<SysLog> records) {
		for(SysLog record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysLog findById(Long id) {
		return sysLogMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) throws NoSuchMethodException {
		Object label = pageRequest.getParam("userName");
		if(label != null) {
			return MyBatisPageHelper.findPage(pageRequest, sysLogMapper, "findPageByUserName", label);
		}
		return MyBatisPageHelper.findPage(pageRequest, sysLogMapper);
	}
	
}
