package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.GoodType;
import com.ruoyi.system.domain.SysPost;

/**
 * 商品种类管理Service接口
 * 
 * @author ruoyi
 * @date 2021-07-07
 */
public interface IGoodTypeService 
{
    /**
     * 查询商品种类管理
     * 
     * @param goodId 商品种类管理ID
     * @return 商品种类管理
     */
    public GoodType selectGoodTypeById(Long goodId);

    /**
     * 查询商品种类管理列表
     * 
     * @param goodType 商品种类管理
     * @return 商品种类管理集合
     */
    public List<GoodType> selectGoodTypeList(GoodType goodType);

    /**
     * 新增商品种类管理
     * 
     * @param goodType 商品种类管理
     * @return 结果
     */
    public int insertGoodType(GoodType goodType);

    /**
     * 修改商品种类管理
     * 
     * @param goodType 商品种类管理
     * @return 结果
     */
    public int updateGoodType(GoodType goodType);

    /**
     * 批量删除商品种类管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGoodTypeByIds(String ids);

    /**
     * 删除商品种类管理信息
     * 
     * @param goodId 商品种类管理ID
     * @return 结果
     */
    public int deleteGoodTypeById(Long goodId);

    /**
     * 校验商品种类编码
     *
     * @param goodType 商品种类信息
     * @return 结果
     */
    public String checkGoodTypeCodeUnique(GoodType goodType);

    /**
     * 校验商品种类名称
     *
     * @param goodType 商品种类信息
     * @return 结果
     */
    public String checkGoodNameUnique(GoodType goodType);
}
