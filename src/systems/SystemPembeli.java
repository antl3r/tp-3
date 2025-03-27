package systems;

import classes.AppMenu;
import classes.MenuItem;
import interfaces.SystemMenu;
import utils.MiscUtils;

import java.util.Scanner;

public class SystemPembeli implements SystemMenu {
    private Scanner input;

    public SystemPembeli(Scanner input) {
        this.input = input;
    }

    public void showMenu() {
        AppMenu menu = new AppMenu(
            new MenuItem(1, "Cek Saldo", () -> {
                
            }),
            new MenuItem(2, "Top Up Saldo", () -> {
                
            }),
            new MenuItem(3, "Cek Daftar Barang", () -> {
                
            }),
            new MenuItem(4, "Tambah Barang ke Keranjang", () -> {
                
            }),
            new MenuItem(5, "Checkout Keranjang", () -> {
                
            }),
            new MenuItem(6, "Lacak Barang", () -> {
                
            }),
            new MenuItem(7, "Lihat Laporan Pengeluaran", () -> {
                
            }),
            new MenuItem(8, "Kembali ke menu utama", () -> {
                System.out.println("Kembali ke menu utama..");
            })
        );

        while(true) {
            System.out.println("===== MENU PEMBELI =====");
            menu.displayMenu();
            int selection = MiscUtils.intPrompt("Perintah: ", input); 
            menu.executeOption(selection);

            if (selection == 8) return;
        }
    }
}
