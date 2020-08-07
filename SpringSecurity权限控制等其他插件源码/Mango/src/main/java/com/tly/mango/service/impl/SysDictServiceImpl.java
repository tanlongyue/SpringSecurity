package com.tly.mango.service.impl;

import java.util.List;

import com.tly.mango.core.page.MyBatisPageHelper;
import com.tly.mango.core.page.PageRequest;
import com.tly.mango.core.page.PageResult;
import com.tly.mango.entity.SysDict;
import com.tly.mango.repository.SysDictMapper;
import com.tly.mango.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SysDictServiceImpl  implements SysDictService {

	@Autowired
	private SysDictMapper sysDictMapper;

	@Override
	public int save(SysDict record) {
		if(record.getId() == null || record.getId() == 0) {
			return sysDictMapper.insertSelective(record);
		}
		return sysDictMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(SysDict record) {
		return sysDictMapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<SysDict> records) {
		for(SysDict record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysDict findById(Long id) {
		return sysDictMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) throws NoSuchMethodException {
		Object label = pageRequest.getParam("label");
		if(label != null) {
			return MyBatisPageHelper.findPage(pageRequest, sysDictMapper, "findPageByLabel", label);
		}
		return MyBatisPageHelper.findPage(pageRequest, sysDictMapper);
	}

	@Override
	public List<SysDict> findByLable(String lable) {
		return sysDictMapper.findByLable(lable);
	}

}
