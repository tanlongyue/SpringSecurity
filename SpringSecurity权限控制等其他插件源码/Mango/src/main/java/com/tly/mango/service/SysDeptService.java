package com.tly.mango.service;

import com.tly.mango.core.CurdService;
import com.tly.mango.entity.SysDept;

import java.util.List;



/**
 * 机构管理
 * @author Louis
 * @date Jan 13, 2019
 */
public interface SysDeptService extends CurdService<SysDept> {

	/**
	 * 查询机构树
	 */
	List<SysDept> findTree();
}
