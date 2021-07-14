package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MemberInfoMapper;
import com.ruoyi.system.domain.MemberInfo;
import com.ruoyi.system.service.IMemberInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 会员个人信息管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-14
 */
@Service
public class MemberInfoServiceImpl implements IMemberInfoService 
{
    @Autowired
    private MemberInfoMapper memberInfoMapper;

    /**
     * 查询会员个人信息管理
     * 
     * @param memberid 会员个人信息管理ID
     * @return 会员个人信息管理
     */
    @Override
    public MemberInfo selectMemberInfoById(Long memberid)
    {
        return memberInfoMapper.selectMemberInfoById(memberid);
    }

    /**
     * 查询会员个人信息管理列表
     * 
     * @param memberInfo 会员个人信息管理
     * @return 会员个人信息管理
     */
    @Override
    public List<MemberInfo> selectMemberInfoList(MemberInfo memberInfo)
    {
        return memberInfoMapper.selectMemberInfoList(memberInfo);
    }

    /**
     * 新增会员个人信息管理
     * 
     * @param memberInfo 会员个人信息管理
     * @return 结果
     */
    @Override
    public int insertMemberInfo(MemberInfo memberInfo)
    {
        return memberInfoMapper.insertMemberInfo(memberInfo);
    }

    /**
     * 修改会员个人信息管理
     * 
     * @param memberInfo 会员个人信息管理
     * @return 结果
     */
    @Override
    public int updateMemberInfo(MemberInfo memberInfo)
    {
        return memberInfoMapper.updateMemberInfo(memberInfo);
    }

    /**
     * 删除会员个人信息管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMemberInfoByIds(String ids)
    {
        return memberInfoMapper.deleteMemberInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除会员个人信息管理信息
     * 
     * @param memberid 会员个人信息管理ID
     * @return 结果
     */
    @Override
    public int deleteMemberInfoById(Long memberid)
    {
        return memberInfoMapper.deleteMemberInfoById(memberid);
    }
}
