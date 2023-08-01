package com.sjj.mashibing.bridgeJoint.payment;

import java.math.BigDecimal;

/**
 * 桥接模式-抽象化角色-支付抽象类<br>
 */
public abstract class Pay {
    //桥接支付方式接口
    protected IPayMode payMode;

    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }

    //划账功能
    public abstract String transfer(String uId, String tradeId, BigDecimal amount);
}
