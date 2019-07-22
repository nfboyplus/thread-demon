package com.design.proxy.quiet;

/**
 * 代理类:静态需要生成代理对象
 */
public class UserDaoProxy implements IUserDao {

    private IUserDao iUserDao;

    public UserDaoProxy(IUserDao iUserDao){
        this.iUserDao = iUserDao;
    }

    @Override
    public void save() {
        System.out.println("---- 开启事物 ----");
        iUserDao.save();
        System.out.println("---- 关闭事物 ----");
    }
}
