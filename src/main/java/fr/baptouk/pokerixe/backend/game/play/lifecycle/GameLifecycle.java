package fr.baptouk.pokerixe.backend.game.play.lifecycle;

import fr.baptouk.pokerixe.backend.game.play.GamePlay;
import fr.baptouk.pokerixe.backend.game.turn.action.Action;
import fr.baptouk.pokerixe.backend.game.websocket.packets.game.lifecycle.GameStartPacket;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.UUID;


@RequiredArgsConstructor
public final class GameLifecycle {

    private static final Logger logger = LoggerFactory.getLogger(GameLifecycle.class);

    private final GamePlay gamePlay;

    private Map<UUID,Action>  playerActions;
    //  playerActions.clear() pour vider la map en attendant la prochaine


    public Mono<Void> fetchPokemons(WebClient pokeApiClient) {
        List<Mono<Void>> initTasks = gamePlay.getPlayers().stream()
                .map(player -> player.init(pokeApiClient))
                .toList();

        return Mono.when(initTasks)
                .doOnSuccess(v -> this.startGame())
                .doOnError(e -> logger.error("Erreur pendant le fetch", e));
    }

    public void startGame() {

        new GameStartPacket().send(); // met les joueurs en mode Jeux


        // Paquets pour leurs faire charger les pokemons

    }

    public void computeTurn() {

        // Test si ya Switch (Oui/non)
        for (Map.Entry<UUID, Action> entry : this.playerActions.entrySet()) {
            // Test si action est switch
        }
        // Regarde qu'elle pokemon est le plus rapide

        // Joue l'action Pokemon 1, ( si poke 2 mort alors fin de tours + switch de poke j2 )

        // Poke j2


    }

    public void turnFinish () {
        // vide le player actions

        // Test si le game est finit

        // Envoi les joueurs
    }



}
