package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.domain.SysPost;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.GoodType;
import com.ruoyi.system.service.IGoodTypeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/** 自己写的*/
import com.ruoyi.common.constant.UserConstants;

/**
 * 商品种类管理Controller
 * 
 * @author ruoyi
 * @date 2021-07-07
 */
@Controller
@RequestMapping("/system/type")
public class GoodTypeController extends BaseController
{
    private String prefix = "system/type";

    @Autowired
    private IGoodTypeService goodTypeService;

    @RequiresPermissions("system:type:view")
    @GetMapping()
    public String type()
    {
        return prefix + "/type";
    }

    /**
     * 查询商品种类管理列表
     */
    @RequiresPermissions("system:type:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GoodType goodType)
    {
        startPage();
        List<GoodType> list = goodTypeService.selectGoodTypeList(goodType);
        return getDataTable(list);
    }

    /**
     * 导出商品种类管理列表
     */
    @RequiresPermissions("system:type:export")
    @Log(title = "商品种类管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GoodType goodType)
    {
        List<GoodType> list = goodTypeService.selectGoodTypeList(goodType);
        ExcelUtil<GoodType> util = new ExcelUtil<GoodType>(GoodType.class);
        return util.exportExcel(list, "商品种类管理数据");
    }

    /**
     * 新增商品种类管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商店种类编码
     */
    @RequiresPermissions("system:type:add")
    @Log(title = "商品种类管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated GoodType goodType)
    {
         if (UserConstants.GOOD_TYPE_CODE_NOT_UNIQUE.equals(goodTypeService.checkGoodTypeCodeUnique(goodType)))
        {
            return error("新增商品种类'" + goodType.getGoodName() + "'失败，商品种类编码已存在");
        }
         else if(UserConstants.GOOD_NAME_NOT_UNIQUE.equals(goodTypeService.checkGoodNameUnique(goodType))){
             return error("新增商品种类'" + goodType.getGoodName() + "'失败，商品种类名称已存在");
         }
        goodType.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(goodTypeService.insertGoodType(goodType));
    }

    /**
     * 修改商品种类管理
     */
    @GetMapping("/edit/{goodId}")
    public String edit(@PathVariable("goodId") Long goodId, ModelMap mmap)
    {
        GoodType goodType = goodTypeService.selectGoodTypeById(goodId);
        mmap.put("goodType", goodType);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品种类管理
     */
    @RequiresPermissions("system:type:edit")
    @Log(title = "商品种类管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GoodType goodType)
    {
        return toAjax(goodTypeService.updateGoodType(goodType));
    }

    /**
     * 删除商品种类管理
     */
    @RequiresPermissions("system:type:remove")
    @Log(title = "商品种类管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(goodTypeService.deleteGoodTypeByIds(ids));
    }

    /**
     * 校验商店种类编码是否唯一
     */
    @PostMapping("/checkGoodTypeCodeUnique")
    @ResponseBody
    public String checkGoodTypeCodeUnique(GoodType goodType)
    {
        return goodTypeService.checkGoodTypeCodeUnique(goodType);
    }

    /**
     * 校验商店种类名称是否唯一
     */
    @PostMapping("/checkGoodNameUnique")
    @ResponseBody
    public String checkGoodNameUnique(GoodType goodType)
    {
        return goodTypeService.checkGoodNameUnique(goodType);
    }

}
