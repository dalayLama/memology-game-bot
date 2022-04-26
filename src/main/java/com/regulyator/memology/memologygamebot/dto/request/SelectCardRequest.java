package com.regulyator.memology.memologygamebot.dto.request;

import com.regulyator.memology.memologygamebot.dto.Card;
import com.regulyator.memology.memologygamebot.dto.UserInfo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SelectCardRequest {
    private final UserInfo userInfo;
    private final Card card;
}
