package com.design.proxy.dynamic.impl;

import com.design.proxy.dynamic.IUserDao;

/**
 * created on 2019/7/18 13:26
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class IUserDaoImpl implements IUserDao {

    @Override
    public void save() {
        System.out.println("---- 已经保存数据 ----");
    }

}
