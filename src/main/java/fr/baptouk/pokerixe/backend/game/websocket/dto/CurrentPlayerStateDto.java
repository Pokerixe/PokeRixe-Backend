package fr.baptouk.pokerixe.backend.game.websocket.dto;

import java.util.List;

public record PlayerStateDto(
        String pseudo,
        PokemonStateDto activePokemon
) {
    public record PokemonStateDto(
            String name,
            int currentHp,
            int maxHp,
            String urlImageFront,
            List<AttackDto> attacks
    ) {
        public record AttackDto(
                String name,
                Integer power,
                Integer accuracy,
                String type
        ) {}
    }
}



