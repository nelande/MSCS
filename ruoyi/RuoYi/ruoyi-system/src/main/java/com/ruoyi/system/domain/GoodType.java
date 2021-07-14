package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 商品种类管理对象 good_type
 *
 * @author ruoyi
 */
public class GoodType extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 商品种类ID
     */
    private Long goodId;

    /**
     * 商品种类编码
     */
    @Excel(name = "商品种类编码")
    private String goodCode;

    /**
     * 商品种类名称
     */
    @Excel(name = "商品种类名称")
    private String goodName;

    /**
     * 用户是否存在此商品种类标识 默认不存在
     */
    private boolean flag = false;

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    @NotBlank(message = "商店种类编码不能为空")
    @Size(min = 0, max = 64, message = "商品种类编码长度不能超过64个字符")
    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    @NotBlank(message = "商品种类名称不能为空")
    @Size(min = 0, max = 64, message = "商品种类名称长度不能超过64个字符")
    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public boolean isFlag()
    {
        return flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("goodId", getGoodId())
                .append("goodCode", getGoodCode())
                .append("goodName", getGoodName())
                .toString();
    }
}
