package com.winterchen.controller;


import com.winterchen.model.Bulletin;
import com.winterchen.service.user.BulletinService;
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
 * Title: BulletinController
 * Description: 留言管理
 * Company: 写手项目
 * @author: fy
 * @date:   2018-10-03
 */
@RestController
@RequestMapping("/bulletin")
@Api(description = "留言接口", value = "写手项目接口")
@Scope("prototype")
@EnableAutoConfiguration
public class BulletinController
{

    @Autowired
    private BulletinService bulletinService;

    /**
     * 保存留言信息
     *
     * @return
     */
    @ApiOperation(value = "保存留言信息")
    @ApiImplicitParams({
    })
    @PostMapping(value = "/saveBulletin")
    public Map<String,Object> WithdrawInfo(@RequestBody Bulletin bulletin) throws Exception
    {
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",bulletinService.addBulletin(bulletin));
        return modelMap;
    }


    /**
     * 查询留言列表
     *
     * @return
     */
    @ApiOperation(value = "查询留言列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "serId", value = "当前用户id", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "articleId", value = "文章id", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "当前页", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "页面记录数", required = true, dataType = "int")
    })
    @PostMapping(value = "/listBulletin")
    public Object selectWithdraws(@RequestBody(required = false) Map<String, Object> params) throws Exception
    {
        return bulletinService.getBulletinList(params);
    }

    /**
     * 更新留言信息（回复）
     *
     * @return
     */
    @ApiOperation(value = "更新留言信息（回复）")
    @ApiImplicitParams({
    })
    @PostMapping(value = "/updateBulletin")
    public Map<String,Object> updateBulletinInfo(Bulletin bulletin) throws Exception
    {
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",bulletinService.updateBulletin(bulletin));
        return modelMap;
    }
}
