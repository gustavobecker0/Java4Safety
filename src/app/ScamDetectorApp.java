package app;

import app.ai.AiAnalyzer;
import app.evaluation.DetectionResult;
import app.evaluation.Evidence;

import java.util.Scanner;

public class ScamDetectorApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a sua mensagem: ");
        String message = sc.nextLine();

        ScamDetector detector = new ScamDetector();

        DetectionResult result = detector.analyze(message);

        System.out.println();
        System.out.println("Pontuação: " + result.getScore());
        System.out.println("Suspeita: " + result.isSuspicious());

        System.out.println("\nRazões:");

        for (Evidence evidence : result.getEvidences()) {
            System.out.println("- " + evidence.getName()
                    + " (+" + evidence.getWeight() + ")");
            System.out.println("  " + evidence.getDescription());
        }

        if (result.isSuspicious()) {

            AiAnalyzer ai = new AiAnalyzer();

            String explanation = ai.analyze(message, result);

            System.out.println("\n=== Análise da IA ===");
            System.out.println(explanation);
        }
    }
}




