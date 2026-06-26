package org.example.ainotessummarizer.service;

import org.example.ainotessummarizer.dto.Content;
import org.example.ainotessummarizer.dto.GeminiRequest;
import org.example.ainotessummarizer.dto.GeminiResponse;
import org.example.ainotessummarizer.dto.Part;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class GeminiService {

    private final RestClient restClient;

    @Value("${gemini.api.key}")
    private String apiKey;

    public GeminiService(RestClient restClient) {
        this.restClient = restClient;
    }

    public String summarize(String notes) {

     GeminiRequest request =
             new GeminiRequest(
                     List.of(
                             new Content(
                                     List.of(
                                             new Part("Summarize: " + notes)
                                     )
                             )
                     )
             );

     String url =
             "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key="
                     + apiKey;

     GeminiResponse response =
             restClient.post()
                     .uri(url)
                     .body(request)
                     .retrieve()
                     .body(GeminiResponse.class);

     return response.toString();
 }
}