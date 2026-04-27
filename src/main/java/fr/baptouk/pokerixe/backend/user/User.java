package fr.baptouk.pokerixe.backend.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "users")
public class User {

    @Id
    private UUID id;

    private String mail, password, pseudo;

    // TODO : Équipe, Historique


}
