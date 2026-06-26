package org.example.ainotessummarizer.controller;




import org.example.ainotessummarizer.dto.SummarizeRequest;
import org.example.ainotessummarizer.dto.SummarizeResponse;
import org.example.ainotessummarizer.service.OllamaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SummarizeController {

    private final OllamaService ollamaService;

    public SummarizeController(OllamaService ollamaService) {
        this.ollamaService = ollamaService;
    }

    @PostMapping("/summarize")
    public SummarizeResponse summarize(@RequestBody SummarizeRequest request) {
        System.out.println("DEBUG NOTES: " + request.getNotes());
        String result = ollamaService.summarize(request.getNotes());

        return new SummarizeResponse(result);
    }
}