package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.MemberInfo;

/**
 * 会员个人信息管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-07-14
 */
public interface MemberInfoMapper 
{
    /**
     * 查询会员个人信息管理
     * 
     * @param memberid 会员个人信息管理ID
     * @return 会员个人信息管理
     */
    public MemberInfo selectMemberInfoById(Long memberid);

    /**
     * 查询会员个人信息管理列表
     * 
     * @param memberInfo 会员个人信息管理
     * @return 会员个人信息管理集合
     */
    public List<MemberInfo> selectMemberInfoList(MemberInfo memberInfo);

    /**
     * 新增会员个人信息管理
     * 
     * @param memberInfo 会员个人信息管理
     * @return 结果
     */
    public int insertMemberInfo(MemberInfo memberInfo);

    /**
     * 修改会员个人信息管理
     * 
     * @param memberInfo 会员个人信息管理
     * @return 结果
     */
    public int updateMemberInfo(MemberInfo memberInfo);

    /**
     * 删除会员个人信息管理
     * 
     * @param memberid 会员个人信息管理ID
     * @return 结果
     */
    public int deleteMemberInfoById(Long memberid);

    /**
     * 批量删除会员个人信息管理
     * 
     * @param memberids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMemberInfoByIds(String[] memberids);
}
