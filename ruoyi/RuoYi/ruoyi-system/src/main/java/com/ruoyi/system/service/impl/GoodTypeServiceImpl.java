package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GoodTypeMapper;
import com.ruoyi.system.domain.GoodType;
import com.ruoyi.system.service.IGoodTypeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 商品种类管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-07
 */
@Service
public class GoodTypeServiceImpl implements IGoodTypeService
{
    @Autowired
    private GoodTypeMapper goodTypeMapper;

    /**
     * 查询商品种类管理
     * 
     * @param goodId 商品种类管理ID
     * @return 商品种类管理
     */
    @Override
    public GoodType selectGoodTypeById(Long goodId)
    {
        return goodTypeMapper.selectGoodTypeById(goodId);
    }

    /**
     * 查询商品种类管理列表
     * 
     * @param goodType 商品种类管理
     * @return 商品种类管理
     */
    @Override
    public List<GoodType> selectGoodTypeList(GoodType goodType)
    {
        return goodTypeMapper.selectGoodTypeList(goodType);
    }

    /**
     * 新增商品种类管理
     * 
     * @param goodType 商品种类管理
     * @return 结果
     */
    @Override
    public int insertGoodType(GoodType goodType)
    {
        return goodTypeMapper.insertGoodType(goodType);
    }

    /**
     * 修改商品种类管理
     * 
     * @param goodType 商品种类管理
     * @return 结果
     */
    @Override
    public int updateGoodType(GoodType goodType)
    {
        return goodTypeMapper.updateGoodType(goodType);
    }

    /**
     * 删除商品种类管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGoodTypeByIds(String ids)
    {
        return goodTypeMapper.deleteGoodTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品种类管理信息
     * 
     * @param goodId 商品种类管理ID
     * @return 结果
     */
    @Override
    public int deleteGoodTypeById(Long goodId)
    {
        return goodTypeMapper.deleteGoodTypeById(goodId);
    }

    /**
     * 校验商品种类编码是否唯一
     *
     * @param goodType 商品种类编码信息
     * @return 结果
     */
    @Override
    public String checkGoodTypeCodeUnique(GoodType goodType)
    {
        Long goodId = StringUtils.isNull(goodType.getGoodId()) ? -1L : goodType.getGoodId();
        GoodType info = goodTypeMapper.checkGoodTypeCodeUnique(goodType.getGoodCode());
        if (StringUtils.isNotNull(info) && info.getGoodId().longValue() != goodId.longValue())
        {
            return UserConstants.GOOD_TYPE_CODE_NOT_UNIQUE;
        }
        return UserConstants.GOOD_TYPE_CODE_UNIQUE;
    }

    /**
     * 校验商品种类名称是否唯一
     *
     * @param goodType 商品种类编码信息
     * @return 结果
     */
    @Override
    public String checkGoodNameUnique(GoodType goodType)
    {
        Long goodId = StringUtils.isNull(goodType.getGoodId()) ? -1L : goodType.getGoodId();
        GoodType info = goodTypeMapper.checkGoodNameUnique(goodType.getGoodName());
        if (StringUtils.isNotNull(info) && info.getGoodId().longValue() != goodId.longValue())
        {
            return UserConstants.GOOD_NAME_NOT_UNIQUE;
        }
        return UserConstants.GOOD_NAME_UNIQUE;
    }
}
