package com.ruoyi.system.domain;

public class GoodSold {
    private int amount;

    private String name;

    public GoodSold() {
    }

    public GoodSold(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
