package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Employees;

/**
 * 员工管理Service接口
 * 
 * @author ruoyi
 * @date 2021-07-08
 */
public interface IEmployeesService 
{
    /**
     * 查询员工管理
     * 
     * @param id 员工管理ID
     * @return 员工管理
     */
    public Employees selectEmployeesById(Long id);

    /**
     * 查询员工管理列表
     * 
     * @param employees 员工管理
     * @return 员工管理集合
     */
    public List<Employees> selectEmployeesList(Employees employees);

    /**
     * 新增员工管理
     * 
     * @param employees 员工管理
     * @return 结果
     */
    public int insertEmployees(Employees employees);

    /**
     * 修改员工管理
     * 
     * @param employees 员工管理
     * @return 结果
     */
    public int updateEmployees(Employees employees);

    /**
     * 批量删除员工管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEmployeesByIds(String ids);

    /**
     * 删除员工管理信息
     * 
     * @param id 员工管理ID
     * @return 结果
     */
    public int deleteEmployeesById(Long id);
}
