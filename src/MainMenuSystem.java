

import java.util.Scanner;

import abstracts.User;
import classes.AppMenu;
import classes.MenuItem;
import classes.Pembeli;
import classes.Pengirim;
import classes.Penjual;
import interfaces.SystemMenu;
import repos.UserRepository;
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
        while (true) {
            mainMenu.displayMenu();
            mainMenu.executeOption(input.nextInt());
        }
    }

    public void handleLogin() {
        
    }

    public void handleRegister() {
        UserRepository userRepo = mainRepository.getUserRepo();

        input.nextLine(); //the first one always gets consumed due to keyboard newline lol
        String username = MiscUtils.textPrompt("Masukkan username: ", input);

        User potentialExistingUser = userRepo.getUserByName(username);

        if(potentialExistingUser != null){ // User exists
            System.out.println("Username sudah ada! Silahkan konfirmasi password untuk menambahkan role lain.");
        }

        String password = MiscUtils.textPrompt("Masukkan password: ", input);
        System.out.println(password);

        if(potentialExistingUser != null) {
            if(password != potentialExistingUser.getPassword()) {
                System.out.println(password);
                System.out.println("Password salah!"); //always triggers for some reason?
                return;
            }
        }

        System.out.print("Pilih role:");  
        AppMenu registerMenu = new AppMenu(
            new MenuItem(1, "Penjual", () -> {
                input.nextLine(); //the first one always gets consumed due to keyboard newline lol
                String storeName = MiscUtils.textPrompt("Masukkan nama toko: ", input);
                
                userRepo.addUser(new Penjual(username, password, storeName));
                System.out.println("Registrasi akun penjual berhasil!");             
            }),
            new MenuItem(2, "Pembeli", () -> {
                userRepo.addUser(new Pembeli(username, password));
                System.out.println("Registrasi akun pembeli berhasil!");
            }),
            new MenuItem(3, "Pengirim", () -> {
                userRepo.addUser(new Pengirim(username, password));
                System.out.println("Registrasi akun pengirim berhasil!");
            }),
            new MenuItem(4, "Batalkan register", () -> {
                System.out.println("Registrasi dibatalkan, kembali ke menu utama...");
            })
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
