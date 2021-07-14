package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.VipInfoMapper;
import com.ruoyi.system.domain.VipInfo;
import com.ruoyi.system.service.IVipInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 会员信息管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-14
 */
@Service
public class VipInfoServiceImpl implements IVipInfoService 
{
    @Autowired
    private VipInfoMapper vipInfoMapper;

    /**
     * 查询会员信息管理
     * 
     * @param vipId 会员信息管理ID
     * @return 会员信息管理
     */
    @Override
    public VipInfo selectVipInfoById(Long vipId)
    {
        return vipInfoMapper.selectVipInfoById(vipId);
    }

    /**
     * 查询会员信息管理列表
     * 
     * @param vipInfo 会员信息管理
     * @return 会员信息管理
     */
    @Override
    public List<VipInfo> selectVipInfoList(VipInfo vipInfo)
    {
        return vipInfoMapper.selectVipInfoList(vipInfo);
    }

    /**
     * 新增会员信息管理
     * 
     * @param vipInfo 会员信息管理
     * @return 结果
     */
    @Override
    public int insertVipInfo(VipInfo vipInfo)
    {
        return vipInfoMapper.insertVipInfo(vipInfo);
    }

    /**
     * 修改会员信息管理
     * 
     * @param vipInfo 会员信息管理
     * @return 结果
     */
    @Override
    public int updateVipInfo(VipInfo vipInfo)
    {
        return vipInfoMapper.updateVipInfo(vipInfo);
    }

    /**
     * 删除会员信息管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteVipInfoByIds(String ids)
    {
        return vipInfoMapper.deleteVipInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除会员信息管理信息
     * 
     * @param vipId 会员信息管理ID
     * @return 结果
     */
    @Override
    public int deleteVipInfoById(Long vipId)
    {
        return vipInfoMapper.deleteVipInfoById(vipId);
    }
}
