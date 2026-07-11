    package app;

public class ScamDetector {

    private static final String[] URGENCY_WORDS = {
        "urgente", "imediato", "última chance", "não perca", "responda agora", "tempo limitado"
    };
    private static final String[] SUSPICIOUS_WORDS = {
            "link", "clique", "aqui", "resgate", "resgatar"
    };

    private static final String[] MONEY_WORDS = {
            "pix", "pagamento", "depósito", "transferência",
            "boleto", "dinheiro", "taxa", "multa", "prêmio"
    };

    private static final String[] PRIZE_WORDS = {
            "você ganhou", "parabéns",
            "prêmio", "sorteio", "recompensa"
    };

    private static final String[] PERSONAL_DATA_WORDS = {
            "senha", "cpf", "cartão", "código",
            "token", "cvv", "confirme seus dados"
    };

    private static final String[] THREAT_WORDS = {
            "conta bloqueada",
            "será bloqueado",
            "último aviso",
            "ação judicial",
            "cancelado"
    };

    public boolean isSuspicious(String message){
        String lowerCaseMessage = message.toLowerCase();

        return containsUrgency(lowerCaseMessage)
                || containSuspiciousLink(lowerCaseMessage)
                || containsMoneyWords(lowerCaseMessage)
                || containsPrizeWords(lowerCaseMessage)
                || asksForPersonalData(lowerCaseMessage)
                || containsThreats(lowerCaseMessage)
                || containsUrl(lowerCaseMessage);
    }

    private boolean containsAny(String message, String[] words) {
        for (String word : words) {
            if (message.contains(word)) {
                return true;
            }
        }

        return false;
    }

    public boolean containsUrgency(String message) {
        return containsAny(message, URGENCY_WORDS);
    }

    public boolean containSuspiciousLink(String message) {
        return containsAny(message, SUSPICIOUS_WORDS);
    }

    public boolean containsMoneyWords(String message) {
        return containsAny(message, MONEY_WORDS);
    }

    public boolean containsPrizeWords(String message) {
        return containsAny(message, PRIZE_WORDS);
    }

    public boolean asksForPersonalData(String message) {
        return containsAny(message, PERSONAL_DATA_WORDS);
    }

    public boolean containsThreats(String message) {
        return containsAny(message, THREAT_WORDS);
    }

    public boolean containsUrl(String message) {
        return message.contains("http://")
                || message.contains("https://")
                || message.contains("www.");
    }

}
