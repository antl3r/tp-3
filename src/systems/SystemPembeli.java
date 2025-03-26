package systems;

import classes.AppMenu;
import classes.MenuItem;
import interfaces.SystemMenu;
import java.util.Scanner;

public class SystemPembeli implements SystemMenu {
    private Scanner input;

    public SystemPembeli(Scanner input) {
        this.input = input;
    }

    public void showMenu() {
        AppMenu pembeliMenu = new AppMenu(
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

        System.out.println("===== MENU PEMBELI =====");
        pembeliMenu.displayMenu();
        pembeliMenu.executeOption(input.nextInt());
    }
}
