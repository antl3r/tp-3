import java.util.Scanner;

import classes.AppMenu;

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

    public static final void loopMenu(AppMenu mainMenu, Scanner input, int stopNumber) {
        while (true) {
            mainMenu.displayMenu();
            int choice = input.nextInt();
            mainMenu.executeOption(choice);
            if (choice == stopNumber) break; // Stop looping if they choose number 4
        }
    }

    public static final String textPrompt(String promptText, Scanner input) {
        System.out.println(promptText);
        return input.nextLine();
    }
}
