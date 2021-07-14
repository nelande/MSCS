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
import com.ruoyi.system.domain.Employees;
import com.ruoyi.system.service.IEmployeesService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 员工管理Controller
 * 
 * @author ruoyi
 * @date 2021-07-08
 */
@Controller
@RequestMapping("/system/employees")
public class EmployeesController extends BaseController
{
    private String prefix = "system/employees";

    @Autowired
    private IEmployeesService employeesService;

    @RequiresPermissions("system:employees:view")
    @GetMapping()
    public String employees()
    {
        return prefix + "/employees";
    }

    /**
     * 查询员工管理列表
     */
    @RequiresPermissions("system:employees:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Employees employees)
    {
        startPage();
        List<Employees> list = employeesService.selectEmployeesList(employees);
        return getDataTable(list);
    }

    /**
     * 导出员工管理列表
     */
    @RequiresPermissions("system:employees:export")
    @Log(title = "员工管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Employees employees)
    {
        List<Employees> list = employeesService.selectEmployeesList(employees);
        ExcelUtil<Employees> util = new ExcelUtil<Employees>(Employees.class);
        return util.exportExcel(list, "员工管理数据");
    }

    /**
     * 新增员工管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存员工管理
     */
    @RequiresPermissions("system:employees:add")
    @Log(title = "员工管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Employees employees)
    {
        return toAjax(employeesService.insertEmployees(employees));
    }

    /**
     * 修改员工管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Employees employees = employeesService.selectEmployeesById(id);
        mmap.put("employees", employees);
        return prefix + "/edit";
    }

    /**
     * 修改保存员工管理
     */
    @RequiresPermissions("system:employees:edit")
    @Log(title = "员工管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Employees employees)
    {
        return toAjax(employeesService.updateEmployees(employees));
    }

    /**
     * 删除员工管理
     */
    @RequiresPermissions("system:employees:remove")
    @Log(title = "员工管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(employeesService.deleteEmployeesByIds(ids));
    }
}
