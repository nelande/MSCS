package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EmployeesMapper;
import com.ruoyi.system.domain.Employees;
import com.ruoyi.system.service.IEmployeesService;
import com.ruoyi.common.core.text.Convert;

/**
 * 员工管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-08
 */
@Service
public class EmployeesServiceImpl implements IEmployeesService 
{
    @Autowired
    private EmployeesMapper employeesMapper;

    /**
     * 查询员工管理
     * 
     * @param id 员工管理ID
     * @return 员工管理
     */
    @Override
    public Employees selectEmployeesById(Long id)
    {
        return employeesMapper.selectEmployeesById(id);
    }

    /**
     * 查询员工管理列表
     * 
     * @param employees 员工管理
     * @return 员工管理
     */
    @Override
    public List<Employees> selectEmployeesList(Employees employees)
    {
        return employeesMapper.selectEmployeesList(employees);
    }

    /**
     * 新增员工管理
     * 
     * @param employees 员工管理
     * @return 结果
     */
    @Override
    public int insertEmployees(Employees employees)
    {
        return employeesMapper.insertEmployees(employees);
    }

    /**
     * 修改员工管理
     * 
     * @param employees 员工管理
     * @return 结果
     */
    @Override
    public int updateEmployees(Employees employees)
    {
        return employeesMapper.updateEmployees(employees);
    }

    /**
     * 删除员工管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEmployeesByIds(String ids)
    {
        return employeesMapper.deleteEmployeesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除员工管理信息
     * 
     * @param id 员工管理ID
     * @return 结果
     */
    @Override
    public int deleteEmployeesById(Long id)
    {
        return employeesMapper.deleteEmployeesById(id);
    }
}
