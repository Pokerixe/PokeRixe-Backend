package fr.baptouk.pokerixe.backend.game.analysis;

import fr.baptouk.pokerixe.backend.game.Game;
import org.jspecify.annotations.Nullable;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public final class GameAnalysisProvider {

    @Autowired
    private OllamaApi ollamaApi;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${ollama.model}")
    private String modelName;

    @Value("${ollama.prompt.file.path}")
    private String promptFilePath;

    public CompletableFuture<GameAnalysis> startAnalysis(final Game game) throws IOException {
        return CompletableFuture.supplyAsync(() -> {
            OllamaApi.ChatResponse response = ollamaApi.chat(OllamaApi.ChatRequest.builder(this.modelName)
                    .messages(Collections.singletonList(OllamaApi.Message.builder(OllamaApi.Message.Role.USER)
                            .content(GameAnalysisProvider.this.generatePrompt(game))
                            .build()))
                    .build());

            return new GameAnalysis(response.getChoices().get(0).getMessage().getContent());
        });
    }

    private String generatePrompt(Game game) throws IOException {
        final List<String> fileLines = Files.readAllLines(new File(this.promptFilePath).toPath(), StandardCharsets.UTF_8);

        final String jsonTurns = objectMapper.writeValueAsString(game.getTurns());

        return
    }

}
