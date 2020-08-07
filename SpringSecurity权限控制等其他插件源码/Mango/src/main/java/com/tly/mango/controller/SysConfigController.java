package com.tly.mango.controller;

import java.util.List;

import com.tly.mango.core.page.PageRequest;
import com.tly.mango.entity.SysConfig;
import com.tly.mango.http.HttpResult;
import com.tly.mango.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 系统配置控制器
 * @author Louis
 * @date Jan 13, 2019
 */
@RestController
@RequestMapping("config")
public class SysConfigController {

	@Autowired
	private SysConfigService sysConfigService;
	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody SysConfig record) {
		return HttpResult.buildSuccess(sysConfigService.save(record));
	}

	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysConfig> records) {
		return HttpResult.buildSuccess(sysConfigService.delete(records));
	}

	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) throws NoSuchMethodException {
		return HttpResult.buildSuccess(sysConfigService.findPage(pageRequest));
	}
	
	@GetMapping(value="/findByLable")
	public HttpResult findByLable(@RequestParam String lable) {
		return HttpResult.buildSuccess(sysConfigService.findByLable(lable));
	}
}
