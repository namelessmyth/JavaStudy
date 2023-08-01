package com.sjj.mashibing.bridgeJoint.payment.errorCase;

import java.math.BigDecimal;

/**
 * 桥接模式-支付-错误案例<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/29/0029
 */
public class PayController {
    /**
     * 在一个方法中判断支付渠道和支付方式，后续如果新增渠道和方式需要修改代码，不符合开闭原则
     *
     * @param uId         用户id
     * @param tradeId     交易流水号
     * @param amount      交易金额
     * @param channelType 渠道类型 1 微信, 2 支付宝
     * @param modeType    支付模式 1 密码,2 人脸,3 指纹
     * @return: boolean
     */
    public boolean doPay(String uId, String tradeId, BigDecimal amount, int channelType, int modeType) {
        //微信支付
        if (1 == channelType) {
            System.out.println("微信渠道支付划账开始......");
            if (1 == modeType) {
                System.out.println("密码支付");
            }
            if (2 == modeType) {
                System.out.println("人脸支付");
            }
            if (3 == modeType) {
                System.out.println("指纹支付");
            }
        }

        //支付宝支付
        if (2 == channelType) {
            System.out.println("支付宝渠道支付划账开始......");
            if (1 == modeType) {
                System.out.println("密码支付");
            }
            if (2 == modeType) {
                System.out.println("人脸支付");
            }
            if (3 == modeType) {
                System.out.println("指纹支付");
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PayController payController = new PayController();
        System.out.println("测试: 微信支付、人脸支付方式");
        payController.doPay("weixin_001","1000112333333",new BigDecimal(100),1,2);

        System.out.println("\n测试: 支付宝支付、指纹支付方式");
        payController.doPay("hifubao_002","1000112334567",new BigDecimal(100),2,3);
    }
}
