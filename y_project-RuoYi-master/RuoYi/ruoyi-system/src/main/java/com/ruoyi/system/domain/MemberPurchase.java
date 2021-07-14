package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 会员购买信息管理对象 member_purchase
 * 
 * @author ruoyi
 * @date 2021-07-14
 */
public class MemberPurchase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单号 */
    private Long ordernum;

    /** 商品编号 */
    private Long productnum;

    /** 会员编号 */
    @Excel(name = "会员编号")
    private Long memberid;

    /** 订单日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "订单日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderdate;

    /** 会员姓名 */
    @Excel(name = "会员姓名")
    private String name;

    public void setOrdernum(Long ordernum) 
    {
        this.ordernum = ordernum;
    }

    public Long getOrdernum() 
    {
        return ordernum;
    }
    public void setProductnum(Long productnum) 
    {
        this.productnum = productnum;
    }

    public Long getProductnum() 
    {
        return productnum;
    }
    public void setMemberid(Long memberid) 
    {
        this.memberid = memberid;
    }

    public Long getMemberid() 
    {
        return memberid;
    }
    public void setOrderdate(Date orderdate) 
    {
        this.orderdate = orderdate;
    }

    public Date getOrderdate() 
    {
        return orderdate;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ordernum", getOrdernum())
            .append("productnum", getProductnum())
            .append("memberid", getMemberid())
            .append("orderdate", getOrderdate())
            .append("name", getName())
            .toString();
    }
}
