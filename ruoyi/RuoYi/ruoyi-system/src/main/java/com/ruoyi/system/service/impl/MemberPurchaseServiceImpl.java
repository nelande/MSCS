package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MemberPurchaseMapper;
import com.ruoyi.system.domain.MemberPurchase;
import com.ruoyi.system.service.IMemberPurchaseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 会员购买信息管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-14
 */
@Service
public class MemberPurchaseServiceImpl implements IMemberPurchaseService 
{
    @Autowired
    private MemberPurchaseMapper memberPurchaseMapper;

    /**
     * 查询会员购买信息管理
     * 
     * @param ordernum 会员购买信息管理ID
     * @return 会员购买信息管理
     */
    @Override
    public MemberPurchase selectMemberPurchaseById(Long ordernum)
    {
        return memberPurchaseMapper.selectMemberPurchaseById(ordernum);
    }

    /**
     * 查询会员购买信息管理列表
     * 
     * @param memberPurchase 会员购买信息管理
     * @return 会员购买信息管理
     */
    @Override
    public List<MemberPurchase> selectMemberPurchaseList(MemberPurchase memberPurchase)
    {
        return memberPurchaseMapper.selectMemberPurchaseList(memberPurchase);
    }

    /**
     * 新增会员购买信息管理
     * 
     * @param memberPurchase 会员购买信息管理
     * @return 结果
     */
    @Override
    public int insertMemberPurchase(MemberPurchase memberPurchase)
    {
        return memberPurchaseMapper.insertMemberPurchase(memberPurchase);
    }

    /**
     * 修改会员购买信息管理
     * 
     * @param memberPurchase 会员购买信息管理
     * @return 结果
     */
    @Override
    public int updateMemberPurchase(MemberPurchase memberPurchase)
    {
        return memberPurchaseMapper.updateMemberPurchase(memberPurchase);
    }

    /**
     * 删除会员购买信息管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMemberPurchaseByIds(String ids)
    {
        return memberPurchaseMapper.deleteMemberPurchaseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除会员购买信息管理信息
     * 
     * @param ordernum 会员购买信息管理ID
     * @return 结果
     */
    @Override
    public int deleteMemberPurchaseById(Long ordernum)
    {
        return memberPurchaseMapper.deleteMemberPurchaseById(ordernum);
    }
}
