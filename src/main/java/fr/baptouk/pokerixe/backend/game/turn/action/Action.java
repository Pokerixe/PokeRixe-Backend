package fr.baptouk.pokerixe.backend.game.turn.action;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public abstract class Action {

    @Id
    private UUID id;

    private String name;

}
