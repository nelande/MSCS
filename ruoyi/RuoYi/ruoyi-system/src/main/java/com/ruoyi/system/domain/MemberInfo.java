package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 会员个人信息管理对象 member_info
 * 
 * @author ruoyi
 * @date 2021-07-14
 */
public class MemberInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 会员ID */
    private Long memberid;

    /** 会员姓名 */
    @Excel(name = "会员姓名")
    private String name;

    /** 累计消费金额 */
    @Excel(name = "累计消费金额")
    private Long amount;

    public void setMemberid(Long memberid) 
    {
        this.memberid = memberid;
    }

    public Long getMemberid() 
    {
        return memberid;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setAmount(Long amount) 
    {
        this.amount = amount;
    }

    public Long getAmount() 
    {
        return amount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("memberid", getMemberid())
            .append("name", getName())
            .append("amount", getAmount())
            .toString();
    }
}
