package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.EmployeesInfo;
import com.ruoyi.system.domain.GoodSold;
import com.ruoyi.system.domain.Inventory;
import com.ruoyi.system.mapper.ReportMapper;
import com.ruoyi.system.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ReportServiceImpl implements IReportService {

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public BigDecimal getTotalIncome(){
        return reportMapper.getTotalIncome().getTotalIncome();
    }

    @Override
    public int getTotalBill(){
        return reportMapper.getTotalBill().getTotalBill();
    }

    @Override
    public int getTotalGoodSold(){
        return reportMapper.getTotalGoodSold().getTotalGoodSold();
    }

    @Override
    public int getTotalGood(){
        return reportMapper.getTotalGood().getTotalGood();
    }

    @Override
    public int getTotalVip() {
        return reportMapper.getTotalVip().getTotalVip();
    }

    @Override
    public int getTotalEmployee() {
        return reportMapper.getTotalEmployee().getTotalEmployee();
    }
    @Override
    public List<GoodSold> getGoodSoldAmount(){
        return reportMapper.getGoodSoldAmount();
    }

    @Override
    public List<Inventory> getInventoryInfo() {
        return reportMapper.getInventoryInfo();
    }

    public List<EmployeesInfo> getEmployeesInfo(){
        return reportMapper.getEmployeesInfo();
    }
}
