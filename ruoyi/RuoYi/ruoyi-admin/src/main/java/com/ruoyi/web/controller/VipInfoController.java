package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.VipInfo;
import com.ruoyi.system.service.IVipInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 会员信息管理Controller
 * 
 * @author ruoyi
 * @date 2021-07-14
 */
@Controller
@RequestMapping("/system/info")
public class VipInfoController extends BaseController
{
    private String prefix = "system/info";

    @Autowired
    private IVipInfoService vipInfoService;

    @RequiresPermissions("system:info:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/info";
    }

    /**
     * 查询会员信息管理列表
     */
    @RequiresPermissions("system:info:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(VipInfo vipInfo)
    {
        startPage();
        List<VipInfo> list = vipInfoService.selectVipInfoList(vipInfo);
        return getDataTable(list);
    }

    /**
     * 导出会员信息管理列表
     */
    @RequiresPermissions("system:info:export")
    @Log(title = "会员信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(VipInfo vipInfo)
    {
        List<VipInfo> list = vipInfoService.selectVipInfoList(vipInfo);
        ExcelUtil<VipInfo> util = new ExcelUtil<VipInfo>(VipInfo.class);
        return util.exportExcel(list, "会员信息管理数据");
    }

    /**
     * 新增会员信息管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存会员信息管理
     */
    @RequiresPermissions("system:info:add")
    @Log(title = "会员信息管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(VipInfo vipInfo)
    {
        return toAjax(vipInfoService.insertVipInfo(vipInfo));
    }

    /**
     * 修改会员信息管理
     */
    @GetMapping("/edit/{vipId}")
    public String edit(@PathVariable("vipId") Long vipId, ModelMap mmap)
    {
        VipInfo vipInfo = vipInfoService.selectVipInfoById(vipId);
        mmap.put("vipInfo", vipInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存会员信息管理
     */
    @RequiresPermissions("system:info:edit")
    @Log(title = "会员信息管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(VipInfo vipInfo)
    {
        return toAjax(vipInfoService.updateVipInfo(vipInfo));
    }

    /**
     * 删除会员信息管理
     */
    @RequiresPermissions("system:info:remove")
    @Log(title = "会员信息管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(vipInfoService.deleteVipInfoByIds(ids));
    }
}
