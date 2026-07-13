package app.rules;

import app.evaluation.Evidence;

public interface DetectionRule {

    Evidence scoreMessage(String message);
}