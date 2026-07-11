    package app;

public class ScamDetector {

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
        String[] words = {
                "urgente", "imediato", "última chance",
                "não perca", "responda agora", "tempo limitado"
        };

        return containsAny(message, words);
    }

    public boolean containSuspiciousLink(String message) {
        String[] suspiciousWords = {
                "link", "clique", "aqui", "resgate", "resgatar"
        };

        return containsAny(message, suspiciousWords);
    }

    public boolean containsMoneyWords(String message) {
        String[] words = {
                "pix", "pagamento", "depósito", "transferência",
                "boleto", "dinheiro", "taxa", "multa", "prêmio"
        };

        return containsAny(message, words);
    }

    public boolean containsPrizeWords(String message) {
        String[] words = {
                "você ganhou", "parabéns",
                "prêmio", "sorteio", "recompensa"
        };

        return containsAny(message, words);
    }

    public boolean asksForPersonalData(String message) {
        String[] words = {
                "senha", "cpf", "cartão", "código",
                "token", "cvv", "confirme seus dados"
        };

        return containsAny(message, words);
    }

    public boolean containsThreats(String message) {
        String[] words = {
                "conta bloqueada",
                "será bloqueado",
                "último aviso",
                "ação judicial",
                "cancelado"
        };

        return containsAny(message, words);
    }

    public boolean containsUrl(String message) {
        return message.contains("http://")
                || message.contains("https://")
                || message.contains("www.");
    }

}
