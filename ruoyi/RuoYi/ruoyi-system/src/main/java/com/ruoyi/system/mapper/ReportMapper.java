package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.*;

import java.math.BigDecimal;
import java.util.List;

public interface ReportMapper {
    /**
     * 查询总收入
     *
     * @return 总收入
     */
    public Report getTotalIncome();

    /**
     * 查询总订单数
     *
     * @return 总订单数
     */
    public Report getTotalBill();

    public Report getTotalGoodSold();

    public Report getTotalGood();

    public Report getTotalVip();

    public Report getTotalEmployee();

    public List<GoodSold> getGoodSoldAmount();

    public List<Inventory> getInventoryInfo();

    public List<EmployeesInfo> getEmployeesInfo();
}
