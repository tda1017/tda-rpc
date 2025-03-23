package com.tda.common.service;

import com.tda.common.model.User;

/**
 * 用户服务
 */
public interface UserService {
    /**
     * 获取用户
     *
     * @param user
     * @return
     */
    User getUser(User user);
}
