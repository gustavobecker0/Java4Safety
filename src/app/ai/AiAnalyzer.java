package app.ai;

import app.evaluation.DetectionResult;

public class AiAnalyzer {

    private final PromptBuilder promptBuilder = new PromptBuilder();
    private final OllamaClient client = new OllamaClient();

    public String analyze(String message, DetectionResult result) {

        String prompt = promptBuilder.build(message, result);

        return client.generate(prompt);

    }

}
