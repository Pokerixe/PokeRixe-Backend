package fr.baptouk.pokerixe.backend.game.pokemon;

import lombok.Data;

@Data
public class PokemonStats {
    private int hp;

    private final int  attack,defense,specialAttack,specialDefense,speed;
}
