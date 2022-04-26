package com.regulyator.memology.memologygamebot.dto.request;

import com.regulyator.memology.memologygamebot.dto.UserInfo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StartGameRequest {
    private final UserInfo userInfo;
}
