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

    public String showMenu() {
        return (
            MiscUtils.ASCII_GREETING
        );
    }

    public void handleMenu() {
        
    }

    public void handleLogin() {
        // Implement login handling logic
        // Check for overlapping roles and handle login accordingly
        // If overlapping roles, ask user to choose role and handle balance check
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

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
