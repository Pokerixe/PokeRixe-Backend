package fr.baptouk.pokerixe.backend.game.gameplayer;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class GamePlayer {

    @Id
    private UUID id;

    private String pseudo;


}
