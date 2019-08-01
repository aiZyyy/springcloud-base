package com.itzy.commonservice.interfaces;

/**
 * Created with IntelliJ IDEA
 *
 * @author MiaoWoo
 * Created on 2018/12/4 20:07.
 */
public interface UserHandler extends LoginHandler {
    /**
     * 获得用户ID
     *
     * @return 用户ID
     */
    String getId();
}
