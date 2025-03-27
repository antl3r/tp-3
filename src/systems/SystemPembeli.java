package systems;

import classes.AppMenu;
import classes.MenuItem;
import classes.Pembeli;
import classes.BurhanPedia;
import interfaces.SystemMenu;
import utils.MiscUtils;

import java.util.Scanner;

//the fact that this glorified method is turned into a class and initiated
//on the main menu system as an attrib is a demonstration of their laughable software design skills
public class SystemPembeli implements SystemMenu {
    private Scanner input;
    private Pembeli activePembeli;
    private BurhanPedia mainRepository;

    public SystemPembeli(Scanner input, Pembeli activePembeli, BurhanPedia mainRepository) {
        this.input = input;
        this.activePembeli = activePembeli;
        this.mainRepository = mainRepository;
    }

    public void showMenu() {
        AppMenu menu = new AppMenu(
            new MenuItem(1, "Cek Saldo", () -> {
                long balance = activePembeli.getBalance();

                System.out.print(
                    "==============================\r\n" +
                    "Saldo saat ini: " + balance + "\r\n" +
                    "=============================="
                );
            }),
            new MenuItem(2, "Top Up Saldo", () -> {
                System.out.print("Masukkan jumlah saldo yang ingin ditambah: ");
                long amount = input.nextLong();
                activePembeli.addBalance(amount);
                System.out.println(
                    "Saldo berhasil ditambah! Saldo saat ini: " + String.format("%.2f", (double) activePembeli.getBalance())
                );
            }),
            new MenuItem(3, "Cek Daftar Barang", () -> {
                
            }),
            new MenuItem(4, "Tambah Barang ke Keranjang", () -> {
                
            }),
            new MenuItem(5, "Checkout Keranjang", () -> {
                if (activePembeli.getKeranjang().getProducts().isEmpty()) { //why isn't cart just an array?
                    System.out.println(
                        "=================================\r\n" +
                        "\r\n" +
                        "Keranjang masih kosong!\r\n" +
                        "\r\n" +
                        "================================="
                    );
                } else {
                    // Add logic for processing checkout here

            }),
            new MenuItem(6, "Lacak Barang", () -> {
                
            }),
            new MenuItem(7, "Lihat Laporan Pengeluaran", () -> {
                if (activePembeli.getTransactionHistory().isEmpty()) {
                    System.out.println(
                        "=================================\r\n" +
                        "\r\n" +
                        "Laporan pengeluaran masih kosong!\r\n" +
                        "\r\n" +
                        "================================="
                    );
                } else {
                    System.out.println("=================================");
                    System.out.println("Laporan Pengeluaran:");
                    activePembeli.getTransactionHistory().forEach(transaction -> {
                        System.out.println(transaction);
                    });
                    System.out.println("=================================");
                }
            }),
            new MenuItem(8, "Kembali ke menu utama", () -> {
                System.out.println("Kembali ke menu utama..");
            })
        );

        while(true) {
            MiscUtils.createTitle("MENU PEMBELI");
            menu.displayMenu();
            int selection = MiscUtils.intPrompt("Perintah: ", input); 
            menu.executeOption(selection);

            if (selection == 8) return;
        }
    }
}
