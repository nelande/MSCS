package com.ruoyi.web.controller;

import com.ruoyi.system.domain.EmployeesInfo;
import com.ruoyi.system.domain.GoodSold;
import com.ruoyi.system.domain.Inventory;
import com.ruoyi.system.service.IReportService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

/**
 * 报表
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/report")
public class ReportController {
    private String prefix = "system/report";

    @Autowired
    private IReportService reportService;

    @RequiresPermissions("system:system:report")
    @GetMapping()
    public String report()
    {
        return prefix + "/report";
    }

    @GetMapping("/getTotalIncome")
    @ResponseBody
    public BigDecimal getTotalIncome(){
        return reportService.getTotalIncome();
    }


    @GetMapping("/getTotalBill")
    @ResponseBody
    public int getTotalBill(){
        return reportService.getTotalBill();
    }

    @GetMapping("/getTotalGoodSold")
    @ResponseBody
    public int getTotalGoodSold(){
        return reportService.getTotalGoodSold();
    }

    @GetMapping("/getTotalGood")
    @ResponseBody
    public int getTotalGood(){
        return reportService.getTotalGood();
    }

    @GetMapping("/getTotalVip")
    @ResponseBody
    public int getTotalVip(){
        return reportService.getTotalVip();
    }

    @GetMapping("/getTotalEmployee")
    @ResponseBody
    public int getTotalEmployee(){
        return reportService.getTotalEmployee();
    }

    @GetMapping("/getGoodSoldAmount")
    @ResponseBody
    public List<GoodSold> getGoodSoldAmount(){
        return reportService.getGoodSoldAmount();
    }

    @GetMapping("/getInventoryInfo")
    @ResponseBody
    public List<Inventory> getInventoryInfo(){
        return reportService.getInventoryInfo();
    }

    @GetMapping("/getEmployeesInfo")
    @ResponseBody
    public List<EmployeesInfo> getEmployeesInfo(){
        return reportService.getEmployeesInfo();
    }
}
