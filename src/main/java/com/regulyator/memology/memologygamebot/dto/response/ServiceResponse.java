package com.regulyator.memology.memologygamebot.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceResponse {
    private final boolean success;
    private final String message;
    private final String errorMessage;
}
