package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 员工管理对象 employees
 * 
 * @author ruoyi
 * @date 2021-07-08
 */
public class Employees extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 员工编号 */
    @Excel(name = "员工编号")
    private Long id;

    /** 员工职位 */
    @Excel(name = "员工职位")
    private String post;

    /** 员工姓名 */
    @Excel(name = "员工姓名")
    private String name;

    /** 员工年龄 */
    @Excel(name = "员工年龄")
    private Long age;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPost(String post) 
    {
        this.post = post;
    }

    public String getPost() 
    {
        return post;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("post", getPost())
            .append("name", getName())
            .append("age", getAge())
            .append("status", getStatus())
            .append("remark", getRemark())
            .toString();
    }
}
