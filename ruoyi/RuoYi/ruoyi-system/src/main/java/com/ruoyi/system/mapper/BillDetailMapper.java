package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BillDetail;

/**
 * 订单详细管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-07-14
 */
public interface BillDetailMapper 
{
    /**
     * 查询订单详细管理
     * 
     * @param billVirtualId 订单详细管理ID
     * @return 订单详细管理
     */
    public BillDetail selectBillDetailById(Long billVirtualId);

    /**
     * 查询订单详细管理列表
     * 
     * @param billDetail 订单详细管理
     * @return 订单详细管理集合
     */
    public List<BillDetail> selectBillDetailList(BillDetail billDetail);

    /**
     * 新增订单详细管理
     * 
     * @param billDetail 订单详细管理
     * @return 结果
     */
    public int insertBillDetail(BillDetail billDetail);

    /**
     * 修改订单详细管理
     * 
     * @param billDetail 订单详细管理
     * @return 结果
     */
    public int updateBillDetail(BillDetail billDetail);

    /**
     * 删除订单详细管理
     * 
     * @param billVirtualId 订单详细管理ID
     * @return 结果
     */
    public int deleteBillDetailById(Long billVirtualId);

    /**
     * 批量删除订单详细管理
     * 
     * @param billVirtualIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBillDetailByIds(String[] billVirtualIds);
}
