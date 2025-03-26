

import java.util.Scanner;

import classes.AppMenu;
import classes.MenuItem;
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

    AppMenu mainMenu = new AppMenu(
        new MenuItem(1, "Login", () -> handleLogin()),
        new MenuItem(2, "Register", () -> handleRegister()),
        new MenuItem(3, "Hari Selanjutnya", () -> handleNextDay()),
        new MenuItem(4, "Keluar", () -> {
            System.out.println("Exiting program...");
            System.exit(0);
        })
    );

    public void showMenu() {
        MiscUtils.loopMenu(mainMenu, input, 4);
    }

    public void handleLogin() {
        
    }

    public void handleRegister() {
        AppMenu registerMenu = new AppMenu(
            new MenuItem(1, "Penjual", () -> {
                System.out.print("Masukkan nama toko: ");
                String storeName = input.nextLine();
                System.out.println("Registrasi akun penjual berhasil!" + storeName);                
            }),
            new MenuItem(2, "Pembeli", () -> {}),
            new MenuItem(3, "Pengirim", () -> {}),
            new MenuItem(4, "Batalkan register", () -> {})
        );

        registerMenu.displayMenu();
        registerMenu.executeOption(input.nextInt());
    }

    public void handleNextDay() {
        
    }

    public void handleCekSaldoAntarAkun() {
        
    }

    public static void main(String[] args) {
        MainMenuSystem menuSystem = new MainMenuSystem(); // I'm an intelligent coder

        menuSystem.showMenu();
    }
}
