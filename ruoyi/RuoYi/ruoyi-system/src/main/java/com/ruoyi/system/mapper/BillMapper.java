package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Bill;

/**
 * 订单管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-07-14
 */
public interface BillMapper 
{
    /**
     * 查询订单管理
     * 
     * @param billId 订单管理ID
     * @return 订单管理
     */
    public Bill selectBillById(Long billId);

    /**
     * 查询订单管理列表
     * 
     * @param bill 订单管理
     * @return 订单管理集合
     */
    public List<Bill> selectBillList(Bill bill);

    /**
     * 新增订单管理
     * 
     * @param bill 订单管理
     * @return 结果
     */
    public int insertBill(Bill bill);

    /**
     * 修改订单管理
     * 
     * @param bill 订单管理
     * @return 结果
     */
    public int updateBill(Bill bill);

    /**
     * 删除订单管理
     * 
     * @param billId 订单管理ID
     * @return 结果
     */
    public int deleteBillById(Long billId);

    /**
     * 批量删除订单管理
     * 
     * @param billIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBillByIds(String[] billIds);
}
