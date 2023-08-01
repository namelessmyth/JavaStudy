package com.sjj.mashibing.proxy;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/24
 */
public class UserDaoProxy implements IUserDao {

    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开启事务"); //扩展额外功能
        target.save();
        System.out.println("提交事务");
    }

    public static void main(String[] args) {
        //目标对象
        UserDaoImpl userDao = new UserDaoImpl();
        //代理对象
        UserDaoProxy proxy = new UserDaoProxy(userDao);
        proxy.save();
    }
}
