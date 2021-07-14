package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.MemberPurchase;

/**
 * 会员购买信息管理Service接口
 * 
 * @author ruoyi
 * @date 2021-07-14
 */
public interface IMemberPurchaseService 
{
    /**
     * 查询会员购买信息管理
     * 
     * @param ordernum 会员购买信息管理ID
     * @return 会员购买信息管理
     */
    public MemberPurchase selectMemberPurchaseById(Long ordernum);

    /**
     * 查询会员购买信息管理列表
     * 
     * @param memberPurchase 会员购买信息管理
     * @return 会员购买信息管理集合
     */
    public List<MemberPurchase> selectMemberPurchaseList(MemberPurchase memberPurchase);

    /**
     * 新增会员购买信息管理
     * 
     * @param memberPurchase 会员购买信息管理
     * @return 结果
     */
    public int insertMemberPurchase(MemberPurchase memberPurchase);

    /**
     * 修改会员购买信息管理
     * 
     * @param memberPurchase 会员购买信息管理
     * @return 结果
     */
    public int updateMemberPurchase(MemberPurchase memberPurchase);

    /**
     * 批量删除会员购买信息管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMemberPurchaseByIds(String ids);

    /**
     * 删除会员购买信息管理信息
     * 
     * @param ordernum 会员购买信息管理ID
     * @return 结果
     */
    public int deleteMemberPurchaseById(Long ordernum);
}
