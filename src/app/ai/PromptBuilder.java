package app.ai;

import app.evaluation.DetectionResult;
import app.evaluation.Evidence;

public class PromptBuilder {

	public String build(String message, DetectionResult result) {
		StringBuilder prompt = new StringBuilder(
			"""
                Você é um especialista em segurança digital.
        
                Analise a mensagem abaixo.
        
                O detector encontrou alguns indícios de golpe.
        
                Explique:
        
                - por que ela parece suspeita;
                - quais técnicas de engenharia social aparecem;
                - o que o usuário deve fazer.
        
                Caso considere que ela provavelmente não seja um golpe, explique isso também.
        
                Nunca afirme com certeza absoluta que uma mensagem é um golpe apenas com base nesses indícios
        
                Mensagem:
        """
		);

		prompt.append(message);

		prompt.append("\n\n");

		prompt.append("Pontuação encontrada: ");

		prompt.append(result.getScore());

		prompt.append("\n\n");

		prompt.append("Evidências encontradas: \n\n");

		for (Evidence evidence : result.getEvidences()) {
			prompt.append("- ").append(evidence.getName());
			prompt.append(" (").append(evidence.getWeight()).append(")\n");
			prompt.append(evidence.getDescription()).append("\n\n");
		}

		return prompt.toString();
	}
}
