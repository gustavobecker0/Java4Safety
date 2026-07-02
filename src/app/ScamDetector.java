package app;

public class ScamDetector {

    public boolean isSuspicious(String message){
        String lowerCaseMessage = message.toLowerCase();

        return containsUrgency(lowerCaseMessage);
    }

    public boolean containsUrgency(String message){
        return message.contains("urgente");
    }

}
