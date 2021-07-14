package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BillMapper;
import com.ruoyi.system.domain.Bill;
import com.ruoyi.system.service.IBillService;
import com.ruoyi.common.core.text.Convert;

/**
 * 订单管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-14
 */
@Service
public class BillServiceImpl implements IBillService 
{
    @Autowired
    private BillMapper billMapper;

    /**
     * 查询订单管理
     * 
     * @param billId 订单管理ID
     * @return 订单管理
     */
    @Override
    public Bill selectBillById(Long billId)
    {
        return billMapper.selectBillById(billId);
    }

    /**
     * 查询订单管理列表
     * 
     * @param bill 订单管理
     * @return 订单管理
     */
    @Override
    public List<Bill> selectBillList(Bill bill)
    {
        return billMapper.selectBillList(bill);
    }

    /**
     * 新增订单管理
     * 
     * @param bill 订单管理
     * @return 结果
     */
    @Override
    public int insertBill(Bill bill)
    {
        return billMapper.insertBill(bill);
    }

    /**
     * 修改订单管理
     * 
     * @param bill 订单管理
     * @return 结果
     */
    @Override
    public int updateBill(Bill bill)
    {
        return billMapper.updateBill(bill);
    }

    /**
     * 删除订单管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBillByIds(String ids)
    {
        return billMapper.deleteBillByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除订单管理信息
     * 
     * @param billId 订单管理ID
     * @return 结果
     */
    @Override
    public int deleteBillById(Long billId)
    {
        return billMapper.deleteBillById(billId);
    }
}
