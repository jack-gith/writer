package com.winterchen.controller;

import com.winterchen.model.CapitalDetail;
import com.winterchen.service.user.CapitalDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: CapitalDetailController
 * Description: 资金明细
 * Company: 装修项目
 * @author: fy
 * @date:   2018-10-03
 */
@RestController
@RequestMapping("/capitalDetail")
@Api(description = "资金明细接口", value = "写手项目后台接口")
@Scope("prototype")
@EnableAutoConfiguration
public class CapitalDetailController {

    @Autowired
	private CapitalDetailService capitalDetailService;


	/**
	 * 保存资金明细信息
	 *
	 * @return
	 */
	@ApiOperation(value = "保存资金明细信息")
	@ApiImplicitParams({
	})
	@PostMapping(value = "/saveCapitalDetail")
	public Map<String,Object> CapitalDetailInfo(CapitalDetail capitalDetail) throws Exception
	{
		Map<String,Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success",capitalDetailService.addCapitalDetail(capitalDetail));
		return modelMap;
	}


	/**
	 * 查询资金明细列表
	 *
	 * @return
	 */
	@ApiOperation(value = "查询资金明细列表")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "openId", value = "检索条件（用户id）", required = false, dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "pageNum", value = "当前页", required = true, dataType = "int"),
			@ApiImplicitParam(paramType = "query", name = "pageSize", value = "页面记录数", required = true, dataType = "int")
	})
	@PostMapping(value = "/listCapitalDetail")
	public Object selectCapitalDetails(@RequestParam(required = false) Map<String, Object> params) throws Exception
	{
		Map<String,Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success",capitalDetailService.getCapitalDetailList(params));
		return modelMap;
	}
}
