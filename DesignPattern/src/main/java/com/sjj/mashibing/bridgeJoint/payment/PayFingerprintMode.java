package com.sjj.mashibing.bridgeJoint.payment;

/**
 * 桥接模式-具体实现化角色-支付方式实现-指纹支付<br>
 */
public class PayFingerprintMode implements IPayMode {
    @Override
    public boolean security(String uId) {
        System.out.println("指纹支付,调用手机指纹校验功能");
        return true;
    }
}
