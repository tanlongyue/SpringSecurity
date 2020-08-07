package com.tly.mango.service;

import com.tly.mango.core.CurdService;
import com.tly.mango.entity.SysConfig;

import java.util.List;


/**
 * 系统配置管理
 * @author Louis
 * @date Jan 13, 2019
 */
public interface SysConfigService extends CurdService<SysConfig> {

	/**
	 * 根据名称查询
	 * @param lable
	 * @return
	 */
	List<SysConfig> findByLable(String lable);
}
