package org.example.ainotessummarizer.dto;
import java.util.List;


import java.util.List;

public record GeminiResponse(
        List<Candidate> candidates
) {
}