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
import com.ruoyi.system.domain.BillDetail;
import com.ruoyi.system.service.IBillDetailService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单详细管理Controller
 * 
 * @author ruoyi
 * @date 2021-07-14
 */
@Controller
@RequestMapping("/system/detail")
public class BillDetailController extends BaseController
{
    private String prefix = "system/detail";

    @Autowired
    private IBillDetailService billDetailService;

    @RequiresPermissions("system:detail:view")
    @GetMapping()
    public String detail()
    {
        return prefix + "/detail";
    }

    /**
     * 查询订单详细管理列表
     */
    @RequiresPermissions("system:detail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BillDetail billDetail)
    {
        startPage();
        List<BillDetail> list = billDetailService.selectBillDetailList(billDetail);
        return getDataTable(list);
    }

    /**
     * 导出订单详细管理列表
     */
    @RequiresPermissions("system:detail:export")
    @Log(title = "订单详细管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BillDetail billDetail)
    {
        List<BillDetail> list = billDetailService.selectBillDetailList(billDetail);
        ExcelUtil<BillDetail> util = new ExcelUtil<BillDetail>(BillDetail.class);
        return util.exportExcel(list, "订单详细管理数据");
    }

    /**
     * 新增订单详细管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存订单详细管理
     */
    @RequiresPermissions("system:detail:add")
    @Log(title = "订单详细管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BillDetail billDetail)
    {
        return toAjax(billDetailService.insertBillDetail(billDetail));
    }

    /**
     * 修改订单详细管理
     */
    @GetMapping("/edit/{billVirtualId}")
    public String edit(@PathVariable("billVirtualId") Long billVirtualId, ModelMap mmap)
    {
        BillDetail billDetail = billDetailService.selectBillDetailById(billVirtualId);
        mmap.put("billDetail", billDetail);
        return prefix + "/edit";
    }

    /**
     * 修改保存订单详细管理
     */
    @RequiresPermissions("system:detail:edit")
    @Log(title = "订单详细管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BillDetail billDetail)
    {
        return toAjax(billDetailService.updateBillDetail(billDetail));
    }

    /**
     * 删除订单详细管理
     */
    @RequiresPermissions("system:detail:remove")
    @Log(title = "订单详细管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(billDetailService.deleteBillDetailByIds(ids));
    }
}
