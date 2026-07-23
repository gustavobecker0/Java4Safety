package app.evaluation;

import java.util.ArrayList;
import java.util.List;

public class DetectionResult {

    private final List<Evidence> evidences = new ArrayList<>();

    public void add(Evidence evidence) {
        evidences.add(evidence);
    }

    public int getScore() {
        int score = 0;

        for (Evidence evidence : evidences) {
            score += evidence.getWeight();
        }

        return score;
    }

    public List<Evidence> getEvidences() {
        return evidences;
    }

    public boolean isSuspicious() {
        return getScore() >= 2;
    }
}
