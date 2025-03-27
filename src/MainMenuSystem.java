

import java.util.ArrayList;
import java.util.List;
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
import utils.MiscUtils;

public class MainMenuSystem implements SystemMenu {
    Scanner input = new Scanner(System.in);
    SystemPembeli systemPembeli = new SystemPembeli(input);
    SystemPenjual systemPenjual = new SystemPenjual(input);
    SystemPengirim systemPengirim = new SystemPengirim(input);
    SystemAdmin systemAdmin = new SystemAdmin(input);
    BurhanPedia mainRepository = new BurhanPedia();

    public void showMenu() {
        AppMenu mainMenu = new AppMenu(
            new MenuItem(1, "Login", () -> handleLogin()),
            new MenuItem(2, "Register", () -> handleRegister()),
            new MenuItem(3, "Hari Selanjutnya", () -> handleNextDay()),
            new MenuItem(4, "Keluar", () -> {
                System.out.println("Exiting program...");
                System.exit(0);
            }),
            new MenuItem(5, "Crash aja deh", () -> {
                Object[] o = null;

                while (true) {
                    o = new Object[] {o};
                }
            })
        );

        while (true) {
            System.out.println(MiscUtils.ASCII_GREETING);
            mainMenu.displayMenu();
            mainMenu.executeOption(MiscUtils.intPrompt("\nPerintah:", input));;
        }
    }

    public void handleLogin() {
        System.out.print("Masukkan username: ");
        String name = input.nextLine();
        if (userExists(name)){
            System.out.print("Masukkan password: ");
            String password = input.nextLine();
            User user = mainRepository.getUserRepo().getUserByName(name);

            if (user.verifyPassword(password)) {
                List<String> roleArray = mainRepository.getUserRepo().getUserRoles(user.getUsername());

                if (roleArray.isEmpty()) {
                    System.out.println("User tidak memiliki role yang valid!");
                    return;
                }

                AppMenu roleMenu = new AppMenu();
                int menuIndex = 1;

                for (String role : roleArray) {
                    switch (role.toLowerCase()) {
                        case "pembeli":
                            roleMenu.addMenu(new MenuItem(menuIndex++, "Pembeli", () -> systemPembeli.showMenu()));
                            break;
                        case "penjual":
                            roleMenu.addMenu(new MenuItem(menuIndex++, "Penjual", () -> systemPenjual.showMenu()));
                            break;
                        case "pengirim":
                            roleMenu.addMenu(new MenuItem(menuIndex++, "Pengirim", () -> systemPengirim.showMenu()));
                            break;
                        case "admin":
                            roleMenu.addMenu(new MenuItem(menuIndex++, "Admin", () -> systemAdmin.showMenu()));
                            break;
                        default:
                            System.out.println("Role tidak dikenal: " + role);
                            break;
                    }
                }

                roleMenu.displayMenu();
                roleMenu.executeOption(MiscUtils.intPrompt("\nPerintah:", input));
            } else {
                System.out.println("Username atau password salah!");
            }    } else {
            System.out.println("Username tidak ditemukan!");
        }
    }

    public boolean userExists(String name){
        for (User user : mainRepository.getUserRepo().getAll()){
            if (user.getUsername().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }


    public void handleRegister() {
        UserRepository userRepo = mainRepository.getUserRepo();
        System.out.println("===== REGISTRASI =====");

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
                System.out.println("Password salah!");
                return;
            }
        }

        System.out.print("Pilih role:");  
        AppMenu registerMenu = new AppMenu(
            new MenuItem(1, "Penjual", () -> {
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
        registerMenu.executeOption(MiscUtils.intPrompt("\nPerintah:", input));;
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
