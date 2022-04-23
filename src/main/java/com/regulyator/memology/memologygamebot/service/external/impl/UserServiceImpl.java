package com.regulyator.memology.memologygamebot.service.external.impl;

import com.regulyator.memology.memologygamebot.dto.UserInfo;
import com.regulyator.memology.memologygamebot.service.external.UserService;
import org.springframework.stereotype.Component;

import javax.ws.rs.NotSupportedException;

@Component
public class UserServiceImpl implements UserService {
    @Override
    public boolean registerUser(UserInfo userInfo) {
        return true;
    }

    @Override
    public UserInfo getUserById(long id) {
        throw new NotSupportedException("Operation not supported yet!");
    }
}
