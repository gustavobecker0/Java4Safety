package app.ai;

import app.evaluation.DetectionResult;
import app.evaluation.Evidence;

public class PromptBuilder {

	public String build(String message, DetectionResult result) {
		StringBuilder prompt = new StringBuilder(
				"""
    Você é um analista especialista em golpes digitais e engenharia social.
    
    Sua missão é avaliar o risco da mensagem utilizando o contexto E as evidências já detectadas pelo sistema.
    
    IMPORTANTE
    
    - As evidências fornecidas pelo detector já foram identificadas corretamente.
    - Não questione se elas existem.
    - Sua função é interpretar o significado dessas evidências.
    - Quanto mais evidências relevantes aparecerem juntas, maior deve ser o nível de suspeita.
    
    Considere especialmente como sinais fortes de golpe:
    
    - pedido de senha;
    - pedido de código SMS ou token;
    - pedido de CPF ou dados bancários;
    - solicitação de PIX;
    - pedido para confirmar dados;
    - links desconhecidos;
    - ameaças;
    - urgência exagerada;
    - promessas de prêmio;
    - tentativa de causar medo;
    - pressão para agir imediatamente.
    
    IMPORTANTE: Uma instituição financeira NUNCA pede senha, token, código SMS ou PIX para desbloquear conta. Sempre considere isso um fortíssimo indício de golpe.
    
    ==========================
    MENSAGEM ORIGINAL:
    """
		);
		prompt.append(message);
		prompt.append("""

==========================
RESULTADO DO DETECTOR
Pontuação total: """);

		prompt.append(result.getScore()).append("\n\n");

		for (Evidence evidence : result.getEvidences()) {
			prompt.append("- ").append(evidence.getName()).append(" (+").append(evidence.getWeight()).append(")\n");

			prompt.append("  ").append(evidence.getDescription()).append("\n\n");
		}

		prompt.append(
				"""
    
    ==========================
    SUA TAREFA:
    
    Analise a mensagem considerando o contexto E TODAS as evidências em conjunto. Não analise cada evidência isoladamente.
	Explique como a combinação dos sinais influencia o risco.
    
    Exemplos:
    
    - Urgência + PIX + Senha = risco extremamente elevado.
    - Link + Pedido de CPF = forte indício de phishing.
    - Pedido de dinheiro entre familiares, sem links e sem solicitar senhas, pode ser legítimo dependendo do contexto.
    
    Caso a mensagem peça senha, token, código SMS ou PIX para desbloquear conta, a classificação dificilmente deverá ser inferior a:
    
    Muito provável que seja um golpe
    
    Mesmo assim, nunca afirme com certeza absoluta.
    
    Utilize expressões como:
    
    - há fortes indícios;
    - provavelmente;
    - o contexto sugere.
    
    Responda OBRIGATORIAMENTE em Markdown utilizando exatamente esta estrutura.
    
    # Resumo do contexto
    
    Resumo em até 3 linhas.
    
    ---
    
    # Análise das evidências
    
    Para cada evidência:
    
    - **Nome**
        - É relevante? Sim ou Não.
        - Explique em até 3 linhas.
    
    Caso existam sinais que o detector não encontrou, adicione:
    
    - **Outros sinais observados**
    
    ---
    
    # Classificação
    
    Escolha apenas UMA:
    
    - Muito provável que seja legítima;
    - Provavelmente legítima;
    - Inconclusiva;
    - Provavelmente um golpe;
    - Muito provável que seja um golpe.
    
    ---
    
    # Justificativa: Explique por que chegou à conclusão.
    
    ---
    
    # Orientação
    
    Explique objetivamente como o usuário deve agir.
    """
		);

		return prompt.toString();
	}
}
