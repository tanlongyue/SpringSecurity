package com.tly.mango.service.impl;

import java.util.List;

import com.tly.mango.core.page.MyBatisPageHelper;
import com.tly.mango.core.page.PageRequest;
import com.tly.mango.core.page.PageResult;
import com.tly.mango.entity.SysConfig;
import com.tly.mango.repository.SysConfigMapper;
import com.tly.mango.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SysConfigServiceImpl  implements SysConfigService {

	@Autowired
	private SysConfigMapper sysConfigMapper;

	@Override
	public int save(SysConfig record) {
		if(record.getId() == 0) {
			return sysConfigMapper.insertSelective(record);
		}
		return sysConfigMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(SysConfig record) {
		return sysConfigMapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<SysConfig> records) {
		for(SysConfig record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysConfig findById(Long id) {
		return sysConfigMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) throws NoSuchMethodException {
		Object label = pageRequest.getParam("label");
		if(label != null) {
			return MyBatisPageHelper.findPage(pageRequest, sysConfigMapper, "findPageByLabel", label);
		}
		return MyBatisPageHelper.findPage(pageRequest, sysConfigMapper);
	}

	@Override
	public List<SysConfig> findByLable(String lable) {
		return sysConfigMapper.findByLable(lable);
	}

}
