package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.GoodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GoodBatchMapper;
import com.ruoyi.system.domain.GoodBatch;
import com.ruoyi.system.service.IGoodBatchService;
import com.ruoyi.common.core.text.Convert;

/**
 * 商品批次管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-13
 */
@Service
public class GoodBatchServiceImpl implements IGoodBatchService 
{
    @Autowired
    private GoodBatchMapper goodBatchMapper;

    /**
     * 查询商品批次管理
     * 
     * @param batchId 商品批次管理ID
     * @return 商品批次管理
     */
    @Override
    public GoodBatch selectGoodBatchById(Long batchId)
    {
        return goodBatchMapper.selectGoodBatchById(batchId);
    }

    /**
     * 查询商品批次管理列表
     * 
     * @param goodBatch 商品批次管理
     * @return 商品批次管理
     */
    @Override
    public List<GoodBatch> selectGoodBatchList(GoodBatch goodBatch)
    {
        return goodBatchMapper.selectGoodBatchList(goodBatch);
    }

    /**
     * 新增商品批次管理
     * 
     * @param goodBatch 商品批次管理
     * @return 结果
     */
    @Override
    public int insertGoodBatch(GoodBatch goodBatch)
    {
        return goodBatchMapper.insertGoodBatch(goodBatch);
    }

    /**
     * 修改商品批次管理
     * 
     * @param goodBatch 商品批次管理
     * @return 结果
     */
    @Override
    public int updateGoodBatch(GoodBatch goodBatch)
    {
        return goodBatchMapper.updateGoodBatch(goodBatch);
    }

    /**
     * 删除商品批次管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGoodBatchByIds(String ids)
    {
        return goodBatchMapper.deleteGoodBatchByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品批次管理信息
     * 
     * @param batchId 商品批次管理ID
     * @return 结果
     */
    @Override
    public int deleteGoodBatchById(Long batchId)
    {
        return goodBatchMapper.deleteGoodBatchById(batchId);
    }

    /**
     * 检查商品种类名称是否存在
     *
     * @param goodBatch 商品批次管理
     * @return 结果
     */
    @Override
    public String checkGoodBatchNameExist(GoodBatch goodBatch){
        GoodType info = goodBatchMapper.checkGoodBatchNameExist(goodBatch.getGoodBatchName());
        if (StringUtils.isNotNull(info)){
            return UserConstants.GOOD_NAME_EXIST;
        }
        return UserConstants.GOOD_NAME_NOT_EXIST;
    }
}
