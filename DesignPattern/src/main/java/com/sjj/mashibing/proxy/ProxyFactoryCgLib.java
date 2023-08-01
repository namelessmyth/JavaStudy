package com.sjj.mashibing.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂-动态生成代理对象
 * @author spikeCong
 * @date 2022/9/22
 **/
public class ProxyFactoryCgLib implements MethodInterceptor {

    private Object target; //维护一个目标对象

    public ProxyFactoryCgLib(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        //增强器类,用来创建动态代理类
        Enhancer en = new Enhancer();
        //设置代理类的父类字节码对象
        en.setSuperclass(target.getClass());
        //设置回调: 对于代理类上所有的方法的调用,都会调用CallBack,而Callback则需要实现intercept()方法进行拦截
        en.setCallback(this);
        //创建动态代理对象并返回
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务");
        //执行目标对象方法
        Object ret = methodProxy.invokeSuper(o, args);
        System.out.println("提交事务");
        return ret;
    }

    //测试
    public static void main(String[] args) {
        IUserDao target = new UserDaoImpl();
        System.out.println(target.getClass());//目标对象信息

        IUserDao proxy = (IUserDao) new ProxyFactoryCgLib(target).getProxyInstance();
        System.out.println(proxy.getClass()); //输出代理对象信息
        proxy.save(); //执行代理方法

        while(true){}
    }

}



