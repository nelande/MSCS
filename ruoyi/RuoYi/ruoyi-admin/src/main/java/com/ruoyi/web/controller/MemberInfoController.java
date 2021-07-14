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
import com.ruoyi.system.domain.MemberInfo;
import com.ruoyi.system.service.IMemberInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 会员个人信息管理Controller
 * 
 * @author ruoyi
 * @date 2021-07-14
 */
@Controller
@RequestMapping("/system/info")
public class MemberInfoController extends BaseController
{
    private String prefix = "system/info";

    @Autowired
    private IMemberInfoService memberInfoService;

    @RequiresPermissions("system:info:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/info";
    }

    /**
     * 查询会员个人信息管理列表
     */
    @RequiresPermissions("system:info:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MemberInfo memberInfo)
    {
        startPage();
        List<MemberInfo> list = memberInfoService.selectMemberInfoList(memberInfo);
        return getDataTable(list);
    }

    /**
     * 导出会员个人信息管理列表
     */
    @RequiresPermissions("system:info:export")
    @Log(title = "会员个人信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MemberInfo memberInfo)
    {
        List<MemberInfo> list = memberInfoService.selectMemberInfoList(memberInfo);
        ExcelUtil<MemberInfo> util = new ExcelUtil<MemberInfo>(MemberInfo.class);
        return util.exportExcel(list, "会员个人信息管理数据");
    }

    /**
     * 新增会员个人信息管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存会员个人信息管理
     */
    @RequiresPermissions("system:info:add")
    @Log(title = "会员个人信息管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MemberInfo memberInfo)
    {
        return toAjax(memberInfoService.insertMemberInfo(memberInfo));
    }

    /**
     * 修改会员个人信息管理
     */
    @GetMapping("/edit/{memberid}")
    public String edit(@PathVariable("memberid") Long memberid, ModelMap mmap)
    {
        MemberInfo memberInfo = memberInfoService.selectMemberInfoById(memberid);
        mmap.put("memberInfo", memberInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存会员个人信息管理
     */
    @RequiresPermissions("system:info:edit")
    @Log(title = "会员个人信息管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MemberInfo memberInfo)
    {
        return toAjax(memberInfoService.updateMemberInfo(memberInfo));
    }

    /**
     * 删除会员个人信息管理
     */
    @RequiresPermissions("system:info:remove")
    @Log(title = "会员个人信息管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(memberInfoService.deleteMemberInfoByIds(ids));
    }
}
