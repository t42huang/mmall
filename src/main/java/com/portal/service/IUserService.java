package com.portal.service;

import com.portal.common.ServerResponse;
import com.portal.dao.UserMapper;
import com.portal.pojo.User;

public interface IUserService {
    public ServerResponse<User> login(String username, String password);

    public ServerResponse<User> register(User user) ;

    public ServerResponse<String> checkValid(String str, String type) ;

    ServerResponse selectQuestion(String username);

    ServerResponse checkAnswer(String username, String question, String answer);

    ServerResponse<String> forgetResetPassword(String username, String passwordNew);

    ServerResponse<User> loginTest(String username, String password);
}
