package fr.baptouk.pokerixe.backend.game;

import fr.baptouk.pokerixe.backend.game.gameanalysis.GameAnalysis;
import fr.baptouk.pokerixe.backend.game.gameplayer.GamePlayer;
import fr.baptouk.pokerixe.backend.game.turn.Turn;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.UUID;

public class Game {

    @Id
    private UUID id;

    private List<Turn> turns;

    private List<GamePlayer> players;

    private GameAnalysis analysis;

}
