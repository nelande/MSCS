package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.VipInfo;

/**
 * 会员信息管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-07-14
 */
public interface VipInfoMapper 
{
    /**
     * 查询会员信息管理
     * 
     * @param vipId 会员信息管理ID
     * @return 会员信息管理
     */
    public VipInfo selectVipInfoById(Long vipId);

    /**
     * 查询会员信息管理列表
     * 
     * @param vipInfo 会员信息管理
     * @return 会员信息管理集合
     */
    public List<VipInfo> selectVipInfoList(VipInfo vipInfo);

    /**
     * 新增会员信息管理
     * 
     * @param vipInfo 会员信息管理
     * @return 结果
     */
    public int insertVipInfo(VipInfo vipInfo);

    /**
     * 修改会员信息管理
     * 
     * @param vipInfo 会员信息管理
     * @return 结果
     */
    public int updateVipInfo(VipInfo vipInfo);

    /**
     * 删除会员信息管理
     * 
     * @param vipId 会员信息管理ID
     * @return 结果
     */
    public int deleteVipInfoById(Long vipId);

    /**
     * 批量删除会员信息管理
     * 
     * @param vipIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteVipInfoByIds(String[] vipIds);
}
