

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
            System.out.println(MiscUtils.ASCII_GREETING);
            mainMenu.displayMenu();
            mainMenu.executeOption(input.nextInt());
        }
    }

    public void handleLogin() {
        UserRepository userRepo = mainRepository.getUserRepo();
        System.out.println("===== LOGIN =====");

        input.nextLine(); //the first one always gets consumed due to keyboard newline lol
        String username = MiscUtils.textPrompt("Masukkan username: ", input);
        String password = MiscUtils.textPrompt("Masukkan password: ", input);

        User user = userRepo.getUserByName(username);
        if (user == null) {
            System.out.println("Tidak ada user dengan username " + username);
            return;
        } else {
            if(user.verifyPassword(password)){
                //login success
            } else {
                System.out.println("Password salah!");
                return;
            }
        }
    }

    public void handleRegister() {
        UserRepository userRepo = mainRepository.getUserRepo();
        System.out.println("===== REGISTRASI =====");

        input.nextLine(); //the first one always gets consumed due to keyboard newline lol
        String username = MiscUtils.textPrompt("Masukkan username: ", input);

        User potentialExistingUser = userRepo.getUserByName(username);

        if(potentialExistingUser != null){ // User exists
            System.out.println("Username sudah ada! Silahkan konfirmasi password untuk menambahkan role lain.");
        }

        String password = MiscUtils.textPrompt("Masukkan password: ", input);
        System.out.println(password);

        if(potentialExistingUser != null) {
            if(!potentialExistingUser.verifyPassword(password)) {
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
                
                if (userRepo.addUser(new Penjual(username, password, storeName))) {
                    System.out.println("Registrasi akun penjual berhasil!");
                } else {
                    System.out.println("User sudah punya akun role penjual!");
                }
            }),
            new MenuItem(2, "Pembeli", () -> {
                if (userRepo.addUser(new Pembeli(username, password))) {
                    System.out.println("Registrasi akun pembeli berhasil!");
                } else {
                    System.out.println("User sudah punya akun role pembeli!");
                }
            }),
            new MenuItem(3, "Pengirim", () -> {
                if (userRepo.addUser(new Pengirim(username, password))) {
                    System.out.println("Registrasi akun pengirim berhasil!");
                } else {
                    System.out.println("User sudah punya akun role pengirim!");
                }
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
