package com.sjj.mashibing.bridgeJoint.payment;

/**
 * 桥接模式-具体实现化角色-支付方式实现-指纹支付<br>
 */
public class PayCypher implements IPayMode{
    @Override
    public boolean security(String uId) {
        System.out.println("密码支付,弹出密码输入框，让用户输入密码并校验");
        return true;
    }
}
