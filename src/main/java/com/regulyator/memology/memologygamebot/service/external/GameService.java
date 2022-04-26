package com.regulyator.memology.memologygamebot.service.external;

import com.regulyator.memology.memologygamebot.dto.request.SelectCardRequest;
import com.regulyator.memology.memologygamebot.dto.request.StartGameRequest;
import com.regulyator.memology.memologygamebot.dto.response.ServiceResponse;

public interface GameService {
    ServiceResponse startGame(StartGameRequest startGameRequest);
    ServiceResponse selectCard(SelectCardRequest selectCardRequest);
}
