package com.sjj.mashibing.bridgeJoint.payment;

/**
 * 桥接模式-具体实现化角色-支付方式实现-指纹支付<br>
 */
public class PayFaceMode implements IPayMode{
    @Override
    public boolean security(String uId) {
        System.out.println("人脸支付,调用摄像头校验人脸是否是本机用户");
        return true;
    }
}
