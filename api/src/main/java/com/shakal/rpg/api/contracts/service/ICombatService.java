package com.shakal.rpg.api.contracts.service;

import com.shakal.rpg.api.dto.filter.ChallengeDificultInputDTO;

public interface ICombatService {

	String calculateChallengeDeficult(ChallengeDificultInputDTO input);
}
