package org.example.ainotessummarizer.service;

import org.springframework.stereotype.Service;

@Service
public class SummaryService {

    public String summarize(String notes) {

        if (notes.length() <= 100) {
            return notes;
        }

        return notes.substring(0, 100) + "...";
    }
}