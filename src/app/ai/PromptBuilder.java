package app.ai;

import app.evaluation.DetectionResult;
import app.evaluation.Evidence;

public class PromptBuilder {

	public String build(String message, DetectionResult result) {

		StringBuilder prompt = new StringBuilder("""
                Você é um especialista em segurança digital. Analise o contexto da MENSAGEM abaixo.

                Um detector automático baseado em palavras-chave encontrou alguns indícios que costumam aparecer em golpes digitais.
				Essas evidências NÃO significam, por si só, que a mensagem seja um golpe.
                Elas devem ser utilizadas como pontos de atenção durante sua análise.

                Analise o contexto da conversa e determine se essas evidências realmente representam um comportamento suspeito ou se fazem parte de uma conversa legítima.

                MENSAGEM:
                """);

		prompt.append(message);

		prompt.append("\n\n");

		prompt.append("""
                EVIDÊNCIAS ENCONTRADAS PELO DETECTOR:
                """);

		prompt.append("Pontuação total do detector: ")
				.append(result.getScore()).append("\n\n");

		for (Evidence evidence : result.getEvidences()) {
			prompt.append("- ")
					.append(evidence.getName())
					.append(" (+")
					.append(evidence.getWeight())
					.append(")\n");

			prompt.append("  ")
					.append(evidence.getDescription())
					.append("\n\n");
		}

		prompt.append("""
                SUA TAREFA:

                Faça uma análise considerando principalmente o contexto da mensagem.
                Para cada evidência encontrada pelo detector, explique se ela realmente representa um comportamento suspeito dentro do contexto ou se pode ser explicada por uma conversa legítima.

                Considere aspectos como:

                - linguagem utilizada;
                - naturalidade da conversa;
                - existência de intimidade entre as pessoas;
                - coerência da história apresentada;
                - pedidos de dinheiro;
                - pedidos de informações pessoais;
                - existência de links;
                - pressão para agir rapidamente;
                - ameaças;
                - promessas irreais;
                - tentativa de manipulação emocional.

                Ao final, responda exatamente nesta estrutura:

                ## Resumo do contexto
                Explique brevemente o contexto da mensagem.

                ## Classificação
                Baseado na sua análise do contexto, escolha apenas uma das opções abaixo:

                - Muito provável que seja legítima
                - Provavelmente legítima
                - Inconclusiva
                - Provavelmente um golpe
                - Muito provável que seja um golpe

                ## Justificativa
                Explique detalhadamente por que chegou a essa classificação.

                ## Orientação
                Explique como o usuário deve agir.
                
                Baseie sua conclusão principalmente no contexto da mensagem, utilizando as evidências apenas como apoio para a análise.
                """);

		return prompt.toString();
	}
}