package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品批次管理对象 good_batch
 * 
 * @author ruoyi
 * @date 2021-07-13
 */
public class GoodBatch extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 批次ID */
    private Long batchId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String goodBatchName;

    /** 批次编号 */
    @Excel(name = "批次编号")
    private String batchCode;

    /** 批次数量 */
    @Excel(name = "批次数量")
    private Long batchAmount;

    /** 生产日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date batchPd;

    /** 失效日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "失效日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date batchExp;

    public void setBatchId(Long batchId) 
    {
        this.batchId = batchId;
    }

    public Long getBatchId() 
    {
        return batchId;
    }
    public void setGoodBatchName(String goodBatchName) 
    {
        this.goodBatchName = goodBatchName;
    }

    public String getGoodBatchName() 
    {
        return goodBatchName;
    }
    public void setBatchCode(String batchCode) 
    {
        this.batchCode = batchCode;
    }

    public String getBatchCode() 
    {
        return batchCode;
    }
    public void setBatchAmount(Long batchAmount) 
    {
        this.batchAmount = batchAmount;
    }

    public Long getBatchAmount() 
    {
        return batchAmount;
    }
    public void setBatchPd(Date batchPd) 
    {
        this.batchPd = batchPd;
    }

    public Date getBatchPd() 
    {
        return batchPd;
    }
    public void setBatchExp(Date batchExp) 
    {
        this.batchExp = batchExp;
    }

    public Date getBatchExp() 
    {
        return batchExp;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("batchId", getBatchId())
            .append("goodBatchName", getGoodBatchName())
            .append("batchCode", getBatchCode())
            .append("batchAmount", getBatchAmount())
            .append("batchPd", getBatchPd())
            .append("batchExp", getBatchExp())
            .toString();
    }
}
