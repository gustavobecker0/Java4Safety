package app;

import app.evaluation.DetectionResult;
import app.evaluation.Evidence;

import java.util.Scanner;

public class ScamDetectorApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a message: ");
        String message = sc.nextLine();

        ScamDetector detector = new ScamDetector();

        DetectionResult result = detector.analyze(message);

        System.out.println();
        System.out.println("Score: " + result.getScore());
        System.out.println("Suspicious: " + result.isSuspicious());

        System.out.println("\nReasons:");

        for (Evidence evidence : result.getEvidences()) {
            System.out.println("- " + evidence.getName()
                    + " (+" + evidence.getWeight() + ")");
            System.out.println("  " + evidence.getDescription());
        }
    }
}




