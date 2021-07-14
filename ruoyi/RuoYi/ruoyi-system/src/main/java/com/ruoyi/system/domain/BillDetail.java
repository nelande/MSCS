package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单详细管理对象 bill_detail
 * 
 * @author ruoyi
 * @date 2021-07-14
 */
public class BillDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单虚拟ID */
    @Excel(name = "订单虚拟ID")
    private Long billVirtualId;

    /** 订单ID */
    @Excel(name = "订单ID")
    private Long billId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String goodName;

    /** 商品价格 */
    @Excel(name = "商品价格")
    private BigDecimal goodPrice;

    public void setBillVirtualId(Long billVirtualId) 
    {
        this.billVirtualId = billVirtualId;
    }

    public Long getBillVirtualId() 
    {
        return billVirtualId;
    }
    public void setBillId(Long billId) 
    {
        this.billId = billId;
    }

    public Long getBillId() 
    {
        return billId;
    }
    public void setGoodName(String goodName) 
    {
        this.goodName = goodName;
    }

    public String getGoodName() 
    {
        return goodName;
    }
    public void setGoodPrice(BigDecimal goodPrice) 
    {
        this.goodPrice = goodPrice;
    }

    public BigDecimal getGoodPrice() 
    {
        return goodPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("billVirtualId", getBillVirtualId())
            .append("billId", getBillId())
            .append("goodName", getGoodName())
            .append("goodPrice", getGoodPrice())
            .toString();
    }
}
