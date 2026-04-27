package fr.baptouk.pokerixe.backend.history;

import fr.baptouk.pokerixe.backend.game.Game;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = "users")

public class History {

    @Id
    private UUID id;

    private List<Game> games;

}
