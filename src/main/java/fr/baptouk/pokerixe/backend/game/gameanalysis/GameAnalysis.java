package fr.baptouk.pokerixe.backend.game.gameanalysis;

import org.springframework.data.annotation.Id;

import java.util.Map;
import java.util.UUID;

public class GameAnalysis {

    @Id
    private UUID id;

    private int score;

    private Map<Integer,Integer> score_tour;

    private String conseil;
}
