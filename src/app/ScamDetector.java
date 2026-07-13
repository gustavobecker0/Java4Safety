    package app;

    import app.evaluation.DetectionResult;
    import app.evaluation.Evidence;
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


        public DetectionResult analyze(String message) {

            message = message.toLowerCase();

            DetectionResult result = new DetectionResult();

            for (DetectionRule rule : rules) {

                Evidence evidence = rule.scoreMessage(message);

                if (evidence != null) {
                    result.add(evidence);
                }
            }

            return result;
        }
}
