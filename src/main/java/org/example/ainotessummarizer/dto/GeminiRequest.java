package org.example.ainotessummarizer.dto;

import java.util.List;

public record GeminiRequest(
        List<Content> contents
) {
}