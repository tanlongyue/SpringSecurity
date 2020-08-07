package com.tly.mango.controller;

import java.util.List;

import com.tly.mango.core.page.PageRequest;
import com.tly.mango.entity.SysLog;
import com.tly.mango.http.HttpResult;
import com.tly.mango.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 操作日志控制器
 * @author Louis
 * @date Jan 13, 2019
 */
@RestController
@RequestMapping("log")
public class SysLogController {

	@Autowired
	private SysLogService sysLogService;

	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest)  throws NoSuchMethodException{
		return HttpResult.buildSuccess(sysLogService.findPage(pageRequest));
	}
	
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysLog> records) {
		return HttpResult.buildSuccess(sysLogService.delete(records));
	}
}
