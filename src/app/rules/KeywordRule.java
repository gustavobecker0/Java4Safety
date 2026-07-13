package app.rules;

import app.evaluation.Evidence;

public abstract class KeywordRule implements DetectionRule {

    protected abstract String[] keywords();

    protected abstract String name();

    protected abstract String description();

    protected abstract int weight();

    @Override
    public Evidence scoreMessage(String message) {

        for (String keyword : keywords()) {
            if (message.contains(keyword)) {
                return new Evidence(
                        name(),
                        description(),
                        weight()
                );
            }
        }

        return null;
    }

}