package fr.baptouk.pokerixe.backend.game.play.lifecycle;

import fr.baptouk.pokerixe.backend.game.play.GamePlay;
import fr.baptouk.pokerixe.backend.game.turn.action.Action;
import fr.baptouk.pokerixe.backend.game.turn.action.Switch;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
public final class GameLifecycle {

    private final GamePlay gamePlay;

    private Map<UUID,Action>  playerActions;
    //  playerActions.clear() pour vider la map en attendant la prochaine

    public void fetchPokemons() {
        // récupere tout les infos de pokemon + les attaques
    }

    public void startGame() {
        // envoi le packet de début de partie

        // Met en mode jeu les joueurs

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
