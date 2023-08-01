package com.sjj.mashibing.bridgeJoint.payment;

/**
 * 桥接模式-实现化角色-支付模式接口
 */
public interface IPayMode {

    /**
     * 安全校验功能: 对各种支付模式进行风控校验，校验通过返回结果。
     * @param uid 用户id
     */
    boolean security(String uid);
}
