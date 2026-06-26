package org.example.ainotessummarizer.service;



import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class OllamaService {

    private final RestTemplate restTemplate;

    public OllamaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private final String OLLAMA_URL = "http://localhost:11434/api/generate";

    public String summarize(String notes) {

        String prompt = "Summarize the following notes in simple bullet points:\n\n" + notes;

        Map<String, Object> request = new HashMap<>();
        request.put("model", "llama3");
        request.put("prompt", prompt);
        request.put("stream", false);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity =
                new HttpEntity<>(request, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(
                OLLAMA_URL,
                entity,
                Map.class
        );

        Map body = response.getBody();

        if (body == null) return "No response from model";

        return body.get("response").toString();
    }
}