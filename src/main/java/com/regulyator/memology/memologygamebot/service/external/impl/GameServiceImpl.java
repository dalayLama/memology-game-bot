package com.regulyator.memology.memologygamebot.service.external.impl;

import com.regulyator.memology.memologygamebot.dto.request.SelectCardRequest;
import com.regulyator.memology.memologygamebot.dto.request.StartGameRequest;
import com.regulyator.memology.memologygamebot.dto.response.ServiceResponse;
import com.regulyator.memology.memologygamebot.service.external.GameService;
import org.springframework.stereotype.Component;

@Component
public class GameServiceImpl implements GameService {
    @Override
    public ServiceResponse startGame(StartGameRequest startGameRequest) {
        return null;
    }

    @Override
    public ServiceResponse selectCard(SelectCardRequest selectCardRequest) {
        return null;
    }
}
