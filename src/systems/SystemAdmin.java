package systems;

import java.util.Scanner;

import classes.AppMenu;
import classes.MenuItem;
import interfaces.SystemMenu;
import utils.MiscUtils;

public class SystemAdmin implements SystemMenu {
    private Scanner input;

    public SystemAdmin(Scanner input) {
        this.input = input;
    }

    public void showMenu() {
        AppMenu menu = new AppMenu(
            new MenuItem(1, "Generate Voucher", () -> {
                
            }),
            new MenuItem(2, "Generate Promo", () -> {
                
            }),
            new MenuItem(3, "Lihat Voucher", () -> {
                
            }),
            new MenuItem(4, "Lihat Promo", () -> {
                
            }),
            new MenuItem(5, "Kembali ke menu utama", () -> {
                System.out.println("Kembali ke menu utama..");
            })
        );

        while(true) {
            MiscUtils.createTitle("MENU ADMIN");
            menu.displayMenu();
            int selection = MiscUtils.intPrompt("Perintah: ", input); 
            menu.executeOption(selection);

            if (selection == 5) return;
        }
    }
}
