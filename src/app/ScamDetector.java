package app;

public class ScamDetector {

    public boolean isSuspicious(String message){
        String lowerCaseMessage = message.toLowerCase();

        return containsUrgency(lowerCaseMessage);
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

}
