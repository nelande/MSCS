package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.system.domain.GoodType;
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
import com.ruoyi.system.domain.GoodBatch;
import com.ruoyi.system.service.IGoodBatchService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品批次管理Controller
 * 
 * @author ruoyi
 * @date 2021-07-13
 */
@Controller
@RequestMapping("/system/batch")
public class GoodBatchController extends BaseController
{
    private String prefix = "system/batch";

    @Autowired
    private IGoodBatchService goodBatchService;

    @RequiresPermissions("system:batch:view")
    @GetMapping()
    public String batch()
    {
        return prefix + "/batch";
    }

    /**
     * 查询商品批次管理列表
     */
    @RequiresPermissions("system:batch:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GoodBatch goodBatch)
    {
        startPage();
        List<GoodBatch> list = goodBatchService.selectGoodBatchList(goodBatch);
        return getDataTable(list);
    }

    /**
     * 导出商品批次管理列表
     */
    @RequiresPermissions("system:batch:export")
    @Log(title = "商品批次管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GoodBatch goodBatch)
    {
        List<GoodBatch> list = goodBatchService.selectGoodBatchList(goodBatch);
        ExcelUtil<GoodBatch> util = new ExcelUtil<GoodBatch>(GoodBatch.class);
        return util.exportExcel(list, "商品批次管理数据");
    }

    /**
     * 新增商品批次管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品批次管理
     */
    @RequiresPermissions("system:batch:add")
    @Log(title = "商品批次管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GoodBatch goodBatch)
    {
        return toAjax(goodBatchService.insertGoodBatch(goodBatch));
    }

    /**
     * 修改商品批次管理
     */
    @GetMapping("/edit/{batchId}")
    public String edit(@PathVariable("batchId") Long batchId, ModelMap mmap)
    {
        GoodBatch goodBatch = goodBatchService.selectGoodBatchById(batchId);
        mmap.put("goodBatch", goodBatch);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品批次管理
     */
    @RequiresPermissions("system:batch:edit")
    @Log(title = "商品批次管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GoodBatch goodBatch)
    {
        return toAjax(goodBatchService.updateGoodBatch(goodBatch));
    }

    /**
     * 删除商品批次管理
     */
    @RequiresPermissions("system:batch:remove")
    @Log(title = "商品批次管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(goodBatchService.deleteGoodBatchByIds(ids));
    }

    /**
     * 校验商店批次名称是否唯一
     */
    @PostMapping("/checkGoodBatchNameExist")
    @ResponseBody
    public String checkGoodBatchNameExist(GoodBatch goodBatch)
    {
        return goodBatchService.checkGoodBatchNameExist(goodBatch);
    }
}
