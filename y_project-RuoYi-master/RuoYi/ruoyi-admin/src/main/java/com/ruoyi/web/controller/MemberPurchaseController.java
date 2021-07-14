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
import com.ruoyi.system.domain.MemberPurchase;
import com.ruoyi.system.service.IMemberPurchaseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 会员购买信息管理Controller
 * 
 * @author ruoyi
 * @date 2021-07-14
 */
@Controller
@RequestMapping("/system/purchase")
public class MemberPurchaseController extends BaseController
{
    private String prefix = "system/purchase";

    @Autowired
    private IMemberPurchaseService memberPurchaseService;

    @RequiresPermissions("system:purchase:view")
    @GetMapping()
    public String purchase()
    {
        return prefix + "/purchase";
    }

    /**
     * 查询会员购买信息管理列表
     */
    @RequiresPermissions("system:purchase:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MemberPurchase memberPurchase)
    {
        startPage();
        List<MemberPurchase> list = memberPurchaseService.selectMemberPurchaseList(memberPurchase);
        return getDataTable(list);
    }

    /**
     * 导出会员购买信息管理列表
     */
    @RequiresPermissions("system:purchase:export")
    @Log(title = "会员购买信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MemberPurchase memberPurchase)
    {
        List<MemberPurchase> list = memberPurchaseService.selectMemberPurchaseList(memberPurchase);
        ExcelUtil<MemberPurchase> util = new ExcelUtil<MemberPurchase>(MemberPurchase.class);
        return util.exportExcel(list, "会员购买信息管理数据");
    }

    /**
     * 新增会员购买信息管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存会员购买信息管理
     */
    @RequiresPermissions("system:purchase:add")
    @Log(title = "会员购买信息管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MemberPurchase memberPurchase)
    {
        return toAjax(memberPurchaseService.insertMemberPurchase(memberPurchase));
    }

    /**
     * 修改会员购买信息管理
     */
    @GetMapping("/edit/{ordernum}")
    public String edit(@PathVariable("ordernum") Long ordernum, ModelMap mmap)
    {
        MemberPurchase memberPurchase = memberPurchaseService.selectMemberPurchaseById(ordernum);
        mmap.put("memberPurchase", memberPurchase);
        return prefix + "/edit";
    }

    /**
     * 修改保存会员购买信息管理
     */
    @RequiresPermissions("system:purchase:edit")
    @Log(title = "会员购买信息管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MemberPurchase memberPurchase)
    {
        return toAjax(memberPurchaseService.updateMemberPurchase(memberPurchase));
    }

    /**
     * 删除会员购买信息管理
     */
    @RequiresPermissions("system:purchase:remove")
    @Log(title = "会员购买信息管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(memberPurchaseService.deleteMemberPurchaseByIds(ids));
    }
}
