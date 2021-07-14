package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BillDetailMapper;
import com.ruoyi.system.domain.BillDetail;
import com.ruoyi.system.service.IBillDetailService;
import com.ruoyi.common.core.text.Convert;

/**
 * 订单详细管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-14
 */
@Service
public class BillDetailServiceImpl implements IBillDetailService 
{
    @Autowired
    private BillDetailMapper billDetailMapper;

    /**
     * 查询订单详细管理
     * 
     * @param billVirtualId 订单详细管理ID
     * @return 订单详细管理
     */
    @Override
    public BillDetail selectBillDetailById(Long billVirtualId)
    {
        return billDetailMapper.selectBillDetailById(billVirtualId);
    }

    /**
     * 查询订单详细管理列表
     * 
     * @param billDetail 订单详细管理
     * @return 订单详细管理
     */
    @Override
    public List<BillDetail> selectBillDetailList(BillDetail billDetail)
    {
        return billDetailMapper.selectBillDetailList(billDetail);
    }

    /**
     * 新增订单详细管理
     * 
     * @param billDetail 订单详细管理
     * @return 结果
     */
    @Override
    public int insertBillDetail(BillDetail billDetail)
    {
        return billDetailMapper.insertBillDetail(billDetail);
    }

    /**
     * 修改订单详细管理
     * 
     * @param billDetail 订单详细管理
     * @return 结果
     */
    @Override
    public int updateBillDetail(BillDetail billDetail)
    {
        return billDetailMapper.updateBillDetail(billDetail);
    }

    /**
     * 删除订单详细管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBillDetailByIds(String ids)
    {
        return billDetailMapper.deleteBillDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除订单详细管理信息
     * 
     * @param billVirtualId 订单详细管理ID
     * @return 结果
     */
    @Override
    public int deleteBillDetailById(Long billVirtualId)
    {
        return billDetailMapper.deleteBillDetailById(billVirtualId);
    }
}
