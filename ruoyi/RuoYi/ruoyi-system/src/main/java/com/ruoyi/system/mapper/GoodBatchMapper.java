package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.GoodBatch;
import com.ruoyi.system.domain.GoodType;

/**
 * 商品批次管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-07-13
 */
public interface GoodBatchMapper 
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
     * 删除商品批次管理
     * 
     * @param batchId 商品批次管理ID
     * @return 结果
     */
    public int deleteGoodBatchById(Long batchId);

    /**
     * 批量删除商品批次管理
     * 
     * @param batchIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteGoodBatchByIds(String[] batchIds);


    /**
     * 检查商品种类名称是否唯一
     *
     * @param goodName
     * @return 结果
     */
    public GoodType checkGoodBatchNameExist(String goodName);
}
