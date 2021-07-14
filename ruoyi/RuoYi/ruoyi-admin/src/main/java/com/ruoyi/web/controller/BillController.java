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
import com.ruoyi.system.domain.Bill;
import com.ruoyi.system.service.IBillService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单管理Controller
 * 
 * @author ruoyi
 * @date 2021-07-14
 */
@Controller
@RequestMapping("/system/bill")
public class BillController extends BaseController
{
    private String prefix = "system/bill";

    @Autowired
    private IBillService billService;

    @RequiresPermissions("system:bill:view")
    @GetMapping()
    public String bill()
    {
        return prefix + "/bill";
    }

    /**
     * 查询订单管理列表
     */
    @RequiresPermissions("system:bill:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Bill bill)
    {
        startPage();
        List<Bill> list = billService.selectBillList(bill);
        return getDataTable(list);
    }

    /**
     * 导出订单管理列表
     */
    @RequiresPermissions("system:bill:export")
    @Log(title = "订单管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Bill bill)
    {
        List<Bill> list = billService.selectBillList(bill);
        ExcelUtil<Bill> util = new ExcelUtil<Bill>(Bill.class);
        return util.exportExcel(list, "订单管理数据");
    }

    /**
     * 新增订单管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存订单管理
     */
    @RequiresPermissions("system:bill:add")
    @Log(title = "订单管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Bill bill)
    {
        return toAjax(billService.insertBill(bill));
    }

    /**
     * 修改订单管理
     */
    @GetMapping("/edit/{billId}")
    public String edit(@PathVariable("billId") Long billId, ModelMap mmap)
    {
        Bill bill = billService.selectBillById(billId);
        mmap.put("bill", bill);
        return prefix + "/edit";
    }

    /**
     * 修改保存订单管理
     */
    @RequiresPermissions("system:bill:edit")
    @Log(title = "订单管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Bill bill)
    {
        return toAjax(billService.updateBill(bill));
    }

    /**
     * 删除订单管理
     */
    @RequiresPermissions("system:bill:remove")
    @Log(title = "订单管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(billService.deleteBillByIds(ids));
    }
}
