package com.example.ttpproject.service;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiService implements GenerationService {
    // Supports both synchronous and streaming
    private final ChatClient chatClient;

    public AiService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String generatePath(String message) {
        return this.chatClient.prompt()
                .user(message)
                // .call() sends response to the AI model
                .call()
                .content();
    }
}
