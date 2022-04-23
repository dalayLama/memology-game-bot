package com.regulyator.memology.memologygamebot.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfo {
    private final long id;
    private final String userName;
    private final String firstName;
    private final String lastName;
}
