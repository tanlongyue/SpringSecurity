package com.tly.mango.controller;

import java.util.List;

import com.tly.mango.core.page.PageRequest;
import com.tly.mango.entity.SysLoginLog;
import com.tly.mango.http.HttpResult;
import com.tly.mango.service.SysLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录日志控制器
 * @author Louis
 * @date Jan 13, 2019
 */
@RestController
@RequestMapping("loginlog")
public class SysLoginLogController {

	@Autowired
	private SysLoginLogService sysLoginLogService;

	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) throws NoSuchMethodException {
		return HttpResult.buildSuccess(sysLoginLogService.findPage(pageRequest));
	}
	
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysLoginLog> records) {
		return HttpResult.buildSuccess(sysLoginLogService.delete(records));
	}
}
