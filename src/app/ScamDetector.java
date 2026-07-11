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

    public boolean containsUrgency(String message) {
        String[] urgencyWords = {
                "urgente", "imediato", "última chance",
                "não perca", "responda agora", "tempo limitado"
        };

        for (String word : urgencyWords) {
            if (message.contains(word)) {
                return true;
            }
        }
        return false;
    }

    public boolean containSuspiciousLink(String message) {
        String[] suspiciousWords = {
                "link", "clique", "aqui", "resgate", "resgatar"
        };

        for (String word : suspiciousWords) {
            if (message.contains(word)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsMoneyWords(String message) {
        String[] words = {
                "pix", "pagamento", "depósito", "transferência",
                "boleto", "dinheiro", "taxa", "multa", "prêmio"
        };

        for (String word : words) {
            if (message.contains(word)) {
                return true;
            }
        }

        return false;
    }

    public boolean containsPrizeWords(String message) {
        String[] words = {
                "você ganhou", "parabéns",
                "prêmio", "sorteio", "recompensa"
        };

        for (String word : words) {
            if (message.contains(word)) {
                return true;
            }
        }

        return false;
    }

    public boolean asksForPersonalData(String message) {
        String[] words = {
                "senha", "cpf", "cartão", "código",
                "token", "cvv", "confirme seus dados"
        };

        for (String word : words) {
            if (message.contains(word)) {
                return true;
            }
        }

        return false;
    }

    public boolean containsThreats(String message) {
        String[] words = {
                "conta bloqueada",
                "será bloqueado",
                "último aviso",
                "ação judicial",
                "cancelado"
        };

        for (String word : words) {
            if (message.contains(word)) {
                return true;
            }
        }

        return false;
    }

    public boolean containsUrl(String message) {
        return message.contains("http://")
                || message.contains("https://")
                || message.contains("www.");
    }

}
