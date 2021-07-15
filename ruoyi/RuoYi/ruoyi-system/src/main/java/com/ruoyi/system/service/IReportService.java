package com.ruoyi.system.service;

import com.ruoyi.system.domain.EmployeesInfo;
import com.ruoyi.system.domain.GoodSold;
import com.ruoyi.system.domain.Inventory;

import java.math.BigDecimal;
import java.util.List;

public interface IReportService {

    public BigDecimal getTotalIncome();

    public int getTotalBill();

    public int getTotalGoodSold();

    public int getTotalGood();

    public int getTotalVip();

    public int getTotalEmployee();

    public List<GoodSold> getGoodSoldAmount();

    public List<Inventory> getInventoryInfo();

    public List<EmployeesInfo> getEmployeesInfo();
}
