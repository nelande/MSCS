package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.GoodBatch;

/**
 * 商品批次管理Service接口
 * 
 * @author ruoyi
 * @date 2021-07-13
 */
public interface IGoodBatchService 
{
    /**
     * 查询商品批次管理
     * 
     * @param batchId 商品批次管理ID
     * @return 商品批次管理
     */
    public GoodBatch selectGoodBatchById(Long batchId);

    /**
     * 查询商品批次管理列表
     * 
     * @param goodBatch 商品批次管理
     * @return 商品批次管理集合
     */
    public List<GoodBatch> selectGoodBatchList(GoodBatch goodBatch);

    /**
     * 新增商品批次管理
     * 
     * @param goodBatch 商品批次管理
     * @return 结果
     */
    public int insertGoodBatch(GoodBatch goodBatch);

    /**
     * 修改商品批次管理
     * 
     * @param goodBatch 商品批次管理
     * @return 结果
     */
    public int updateGoodBatch(GoodBatch goodBatch);

    /**
     * 批量删除商品批次管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGoodBatchByIds(String ids);

    /**
     * 删除商品批次管理信息
     *
     * @param batchId 商品批次管理ID
     * @return 结果
     */
    public int deleteGoodBatchById(Long batchId);

    /**
     * 检查商品批次名称是否存在
     *
     * @param goodBatch 商品批次管理ID
     * @return 结果
     */
    public String checkGoodBatchNameExist(GoodBatch goodBatch);


}
