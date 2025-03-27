package systems;

import java.util.Scanner;

import classes.AppMenu;
import classes.MenuItem;
import interfaces.SystemMenu;

public class SystemPengirim implements SystemMenu {
    private Scanner input;

    public SystemPengirim(Scanner input) {
        this.input = input;
    }

    public void showMenu() {
        AppMenu menu = new AppMenu(
            new MenuItem(1, "Find Job", () -> {
                // Implement the action for "Cek Produk"
            }),
            new MenuItem(2, "Take Job", () -> {
                // Implement the action for "Tambah Produk"
            }),
            new MenuItem(3, "Confirm Job", () -> {
                // Implement the action for "Tambah Stok"
            }),
            new MenuItem(4, "Lihat Riwayat Transaksi", () -> {
                // Implement the action for "Ubah Harga Barang"
            }),
            new MenuItem(5, "Kembali ke menu utama", () -> {
                System.out.println("Kembali ke menu utama..");
            })
        );

        while(true) {
            System.out.println("===== MENU PENGIRIM =====");
            menu.displayMenu();
            int selection = Integer.parseInt(input.nextLine());
            menu.executeOption(selection);

            if (selection == 5) return;
        }
    }
}
