    package app;

    import app.rules.*;

    import java.util.List;

    public class ScamDetector {

    private final List<DetectionRule> rules = List.of(
            new UrgencyRule(),
            new SuspiciousRule(),
            new MoneyRule(),
            new PrizeRule(),
            new PersonalDataRule(),
            new ThreatRule()
    );


    public boolean isSuspicious(String message){
        message = message.toLowerCase();

        for (DetectionRule rule : this.rules) {
            if (rule.detectAny(message)) {
                return true;
            }
        }

        return false;
    }
}
