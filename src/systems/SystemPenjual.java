package systems;

import java.util.Scanner;
import classes.AppMenu;
import classes.MenuItem;
import interfaces.SystemMenu;
import utils.MiscUtils;

public class SystemPenjual implements SystemMenu {
    private Scanner input;

    public SystemPenjual(Scanner input) {
        this.input = input;
    }

    public void showMenu() {
        AppMenu menu = new AppMenu(
            new MenuItem(1, "Cek Produk", () -> {
                // Implement the action for "Cek Produk"
            }),
            new MenuItem(2, "Tambah Produk", () -> {
                // Implement the action for "Tambah Produk"
            }),
            new MenuItem(3, "Tambah Stok", () -> {
                // Implement the action for "Tambah Stok"
            }),
            new MenuItem(4, "Ubah Harga Barang", () -> {
                // Implement the action for "Ubah Harga Barang"
            }),
            new MenuItem(5, "Kirim Barang", () -> {
                // Implement the action for "Kirim Barang"
            }),
            new MenuItem(6, "Lihat Laporan Pendapatan", () -> {
                // Implement the action for "Lihat Laporan Pendapatan"
            }),
            new MenuItem(7, "Cek Saldo", () -> {
                // Implement the action for "Cek Saldo"
            }),
            new MenuItem(8, "Lihat Riwayat Transaksi", () -> {
                // Implement the action for "Lihat Riwayat Transaksi"
            }),
            new MenuItem(9, "Kembali ke menu utama", () -> {
                System.out.println("Kembali ke menu utama..");
            })
        );

        while(true) {
            MiscUtils.createTitle("MENU PENJUAL");
            menu.displayMenu();
            int selection = MiscUtils.intPrompt("Perintah: ", input); // Accessing MiscUtils here
            menu.executeOption(selection);

            if (selection == 9) return;
        }
    }
}
