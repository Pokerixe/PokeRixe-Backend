package fr.baptouk.pokerixe.backend.game;

import fr.baptouk.pokerixe.backend.game.analysis.GameAnalysis;
import fr.baptouk.pokerixe.backend.game.attack.GameAttack;
import fr.baptouk.pokerixe.backend.game.player.GamePlayer;
import fr.baptouk.pokerixe.backend.game.pokemon.GamePokemon;
import fr.baptouk.pokerixe.backend.game.team.GameTeam;
import fr.baptouk.pokerixe.backend.game.turn.Turn;
import fr.baptouk.pokerixe.backend.user.User;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Document(collection = "game")
@Data
public class Game {

    @Id
    private UUID id = UUID.randomUUID();

    private String description;

    private List<Turn> turns = Collections.emptyList();

    private List<GamePlayer> players = new ArrayList<>(2);

    private GameAnalysis analysis;

    protected Game(final String description) {
        this.description = description;
    }

    public Game addPlayer(final User user) {
        return this.addPlayer(user, 0);
    }


    public Game addPlayer(final User user, int selectedPokemon) {
        GameTeam gameTeam = new GameTeam();
        gameTeam.setPokemons(user.getTeam().getPokemons().stream()
                .map(pokemon -> {
                    GamePokemon gamePokemon = new GamePokemon();
                    gamePokemon.setPokemonId(pokemon.getId());
                    gamePokemon.setAttacks(pokemon.getAttacks().stream()
                            .map(attack -> {
                                GameAttack gameAttack = new GameAttack();
                                gameAttack.setApiUrl(attack.getApiUrl());
                                return gameAttack;
                            })
                            .toList());
                    return gamePokemon;
                })
                .toList());

        this.players.add(GamePlayer.builder()
                .id(user.getId())
                .pseudo(user.getPseudo())
                .team(gameTeam)
                .indexSelectedPokemon(selectedPokemon)
                .build());

        return this;
    }

}
