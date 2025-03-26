

import java.util.Scanner;

import interfaces.SystemMenu;
import systems.SystemAdmin;
import systems.SystemPembeli;
import systems.SystemPengirim;
import systems.SystemPenjual;

public class MainMenuSystem implements SystemMenu {
    SystemPembeli systemPembeli = new SystemPembeli();
    SystemPenjual systemPenjual = new SystemPenjual();
    SystemPengirim systemPengirim = new SystemPengirim();
    SystemAdmin systemAdmin = new SystemAdmin();
    Scanner input = new Scanner(System.in);
    BurhanPedia mainRepository = new BurhanPedia();

    public String showMenu() {
        return MiscUtils.ASCII_GREETING;
    }

    public void handleMenu() {
        
    }

    public void handleLogin() {
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();

        mainRepository.getAdminRepo();
        mainRepository.getPromoRepo();
        mainRepository.getUserRepo();
        mainRepository.getVoucherRepo();
    }

    public void handleRegister() {
        // Implement register handling logic
        // Allow overlapping roles for the same username
        // Ask for password verification if adding a new role
    }

    public void handleNextDay() {
        // Implement next day handling logic
        // Handle transaction completion with the Sender role
        // Implement refund mechanism for incomplete transactions
    }

    public void handleCekSaldoAntarAkun() {
        // Implement check balance between roles handling logic
        // Combine balances for overlapping roles and display
    }

    public static void main(String[] args) {
        System.out.println(MiscUtils.ASCII_GREETING);
    }
}
