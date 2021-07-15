package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;

public class Report extends BaseEntity {

    private BigDecimal totalIncome;

    private int totalBill;

    private int totalGoodSold;

    private int totalGood;

    private int totalVip;

    private int totalEmployee;

    public Report() {
        totalIncome = new BigDecimal(0);
    }

    public Report(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public int getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(int totalBill) {
        this.totalBill = totalBill;
    }

    public int getTotalGoodSold() {
        return totalGoodSold;
    }

    public void setTotalGoodSold(int totalGoodSold) {
        this.totalGoodSold = totalGoodSold;
    }

    public int getTotalGood() {
        return totalGood;
    }

    public void setTotalGood(int totalGood) {
        this.totalGood = totalGood;
    }

    public int getTotalVip() {
        return totalVip;
    }

    public void setTotalVip(int totalVip) {
        this.totalVip = totalVip;
    }

    public int getTotalEmployee() {
        return totalEmployee;
    }

    public void setTotalEmployee(int totalEmployee) {
        this.totalEmployee = totalEmployee;
    }
}
