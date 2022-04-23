package com.regulyator.memology.memologygamebot.service.external;

import com.regulyator.memology.memologygamebot.dto.UserInfo;

public interface UserService {
    boolean registerUser(UserInfo userInfo);

    UserInfo getUserById(long id);
}
