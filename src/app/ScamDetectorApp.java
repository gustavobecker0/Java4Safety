package app;

import java.util.Scanner;

public class ScamDetectorApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Indique sua mensagem: ");
        String message = sc.nextLine();

        ScamDetector detector = new ScamDetector();

        System.out.println(detector.containsUrgency(message));
    }
}




