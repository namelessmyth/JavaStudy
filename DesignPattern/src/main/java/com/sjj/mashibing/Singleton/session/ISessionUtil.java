package com.sjj.mashibing.Singleton.session;

/**
 * 枚举局部单例-懒汉-创建会话
 * @author Administrator
 */
public enum ISessionUtil {
    session;
    private IAgileSession adminSession;

    ISessionUtil(){
        adminSession = new IAgileSession();
    }

    /**
     * 枚举内部单例，在枚举内部的这个管理员会话只能初始化一次。
     */
    public IAgileSession getAdmin(){
        return adminSession;
    }

    public static void main(String[] args) {
        IAgileSession s1 = ISessionUtil.session.getAdmin();
        IAgileSession s2 = ISessionUtil.session.getAdmin();
        System.out.println(s1 == s2);
    }
}
