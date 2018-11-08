package com.winterchen.controller;


import com.winterchen.model.Withdraw;
import com.winterchen.service.user.WithdrawService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: WithdrawController
 * Description: 提现管理
 * Company: 装修项目
 * @author: fy
 * @date:   2018-10-03
 */
@RestController
@RequestMapping("/withdraw")
@Api(description = "提现接口", value = "写手项目后台接口")
@Scope("prototype")
@EnableAutoConfiguration
public class WithdrawController {

    @Autowired
	private WithdrawService withdrawService;

	/**
	 * 保存提现信息
	 *
	 * @return
	 */
	@ApiOperation(value = "保存提现信息")
	@ApiImplicitParams({
	})
	@PostMapping(value = "/saveWithdraw")
	public Map<String,Object> WithdrawInfo( @RequestBody Withdraw withdraw) throws Exception
	{

		Map<String,Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success",withdrawService.addWithdraw(withdraw));
		return modelMap;
	}


	/**
	 * 查询提现列表
	 *
	 * @return
	 */
	@ApiOperation(value = "查询提现列表")
	@ApiImplicitParams({
			//@ApiImplicitParam(paramType = "query", name = "funNameOrNo", value = "提现编号或名称(检索条件)", required = false, dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "pageNum", value = "当前页", required = true, dataType = "int"),
			@ApiImplicitParam(paramType = "query", name = "pageSize", value = "页面记录数", required = true, dataType = "int")
	})
	@PostMapping(value = "/listWithdraw.do")
	public Object selectWithdraws(@RequestParam(required = false) Map<String, Object> params) throws Exception
	{
		return withdrawService.getWithdrawList(params);
	}

	/**
	 * 更新提现信息
	 *
	 * @return
	 */
	@ApiOperation(value = "更新提现信息")
	@ApiImplicitParams({
	})
	@PostMapping(value = "/updateWithdraw")
	public Map<String,Object> updateWithdrawInfo(Withdraw withdraw) throws Exception
	{
		Map<String,Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success",withdrawService.updateWithdraw(withdraw));
		return modelMap;
	}
}
