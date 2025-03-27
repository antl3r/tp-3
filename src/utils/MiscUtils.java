package utils;
import java.util.Scanner;

public class MiscUtils {
    public static final String ASCII_GREETING = 
        "=============================================================\n" +
        "  ____             _                 _____         _ _      \n" +
        " |  _ \\           | |               |  __ \\       | (_)      \n" +
        " | |_) |_   _ _ __| |__   __ _ _ __ | |__) |__  __| |_  __ _\n" +
        " |  _ <| | | | '__| '_ \\ / _` | '_ \\|  ___/ _ \\/ _` | |/ _` |\n" +
        " | |_) | |_| | |  | | | | (_| | | | | |  |  __/ (_| | | (_| |\n" +
        " |____/ \\__,_|_|  |_| |_|\\__,_|_| |_|_|   \\___|\\__,_|_|\\__,_|\n" +
        "=============================================================\n" +
        "============== Selamat datang di Burhanpedia! ===============\n" +
        "=============================================================\n";

    public static String textPrompt(String promptText, Scanner input) {
        System.out.print(promptText);
        return input.nextLine();
    }

    public static Integer intPrompt(String promptText, Scanner input) {
        while (true) {
            System.out.print(promptText);
            String line = input.nextLine();
            
            if (line.isEmpty()) {
                System.out.println("Mohon input tidak kosong.");
                continue;
            }

            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Mohon masukkan angka yang valid.");
            }
        }
    }

    public static String createTitle(String title) {
        return ("===== " + title + " =====");
    }
}
