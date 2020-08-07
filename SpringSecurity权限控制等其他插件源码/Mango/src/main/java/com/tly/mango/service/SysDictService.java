package com.tly.mango.service;

import com.tly.mango.core.CurdService;
import com.tly.mango.entity.SysDict;

import java.util.List;


/**
 * 字典管理
 * @author Louis
 * @date Jan 13, 2019
 */
public interface SysDictService extends CurdService<SysDict> {

	/**
	 * 根据名称查询
	 * @param lable
	 * @return
	 */
	List<SysDict> findByLable(String lable);
}
