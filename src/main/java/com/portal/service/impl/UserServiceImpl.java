package com.portal.service.impl;

import com.portal.common.Const;
import com.portal.common.ServerResponse;
import com.portal.dao.UserMapper;
import com.portal.pojo.User;
import com.portal.service.IUserService;
import com.portal.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("iUserService") // 向上注册到controller里
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String username, String password) {
        int resultCount = userMapper.checkUsername(username);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("user not exist");
        }
        // 密码md5登陆
        String md5Password = MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.selectLogin(username, md5Password);
        if (user == null) {
            return ServerResponse.createByErrorMessage("password error");
        }
        return ServerResponse.createBySuccess("login in", user);
    }
    @Override
    public ServerResponse<User> loginTest(String username, String password) {

//        int resultCount = userMapper.checkUsername(username);
//        if (resultCount == 0) {
//            return ServerResponse.createByErrorMessage("user not exist");
//        }
//         密码md5登陆
        User user = userMapper.selectLogin(username,password);
        if (user == null) {
            return ServerResponse.createByErrorMessage("password error");
        }
        return ServerResponse.createBySuccess("login in", user);
    }
//
//    @Override
//    public ServerResponse<User> loginTest(String username, String password) {
//        int resultCount = userMapper.checkUsername(username);
//        if (resultCount == 0) {
//            return ServerResponse.createByErrorMessage("user not exist");
//        }
//        User user = userMapper.selectLogin(username, password);
//        System.out.println(user.getUsername());
//        if (user == null) {
//            return ServerResponse.createByErrorMessage("password error");
//        }
//        return ServerResponse.createBySuccess("login in", user);
//    }

    @Override
    public ServerResponse<User> register(User user) {
        int resultCount = userMapper.checkUsername(user.getUsername());
        ServerResponse validResponse = this.checkValid(user.getUsername(), Const.USERNAME);
        if (!validResponse.isSuccess()) {
            return validResponse;
        }
        validResponse = this.checkValid(user.getEmail(), Const.EMAIL);
        if (!validResponse.isSuccess()) {
            return validResponse;
        }
        user.setRole(Const.Role.ROLE_CUSTOMER);
        // password 加密
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("register failed.");
        }

        return ServerResponse.createBySuccessMessage("register success");
    }

    @Override
    public ServerResponse<String> checkValid(String str, String type) {
        if (type != null) {
            // 判断用户名
            if (Const.USERNAME.equals(type)) {
                int resultCount = userMapper.checkUsername(str);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("user name already exist");
                }
            }
            // 判断email
            if (Const.EMAIL.equals(type)) {
                int resultCount = userMapper.checkEmail(type);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("email already exist");
                }
            }
        } else {
            return ServerResponse.createByErrorMessage("param error");
        }
        return ServerResponse.createBySuccessMessage("user name not exist");
    }

    @Override
    public ServerResponse selectQuestion(String username) {
        ServerResponse validResponse = this.checkValid(username, Const.USERNAME);
        if (validResponse.isSuccess()) {
            return ServerResponse.createByErrorMessage("user not exist");
        }
        String question = userMapper.selectQuestionByUsername(username);
        if (question == null) {
            return ServerResponse.createBySuccess(question);
        }
        return ServerResponse.createByErrorMessage("question not exist");
    }

    @Override
    public ServerResponse<String> checkAnswer(String username, String question, String answer) {
        int resultCount = userMapper.checkAnswer(username, question, answer);
        if (resultCount > 0) {
            // 问题和问题答案是这个用户的
            String forgetToken = UUID.randomUUID().toString();
            // url 缓存算法，这里有点问题就不写了，
            // TokenCache.setKey(TokenCache.TOKEN_PREFIX + username, forgetToken);
            return ServerResponse.createByError(forgetToken);
        }
        return ServerResponse.createByErrorMessage("Answer is not correct.");
    }

    @Override
    public ServerResponse<String> forgetResetPassword(String username, String passwordNew) {
//        if (forgetToken == null) {
//            return ServerResponse.createByErrorMessage("token is null");
//        }
        ServerResponse validResponse = this.checkValid(username, Const.USERNAME);
        if (!validResponse.isSuccess()) {
            return ServerResponse.createByErrorMessage("user not exist");
        }
        // token 的逻辑 去掉了
        String md5Password = MD5Util.MD5EncodeUtf8(passwordNew);
        int rowCount = userMapper.updatePasswordByUsername(username, md5Password);
        if (rowCount > 0) {
            return ServerResponse.createBySuccessMessage("reset password success");
        }
        return ServerResponse.createByErrorMessage("reset password failed");
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
    }
}
