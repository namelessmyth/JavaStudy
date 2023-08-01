package com.sjj.mashibing.proxy;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/24
 */
public class UserDaoImpl implements IUserDao {
    @Override
    public void save() {
        System.out.println("保存数据");
    }
}
