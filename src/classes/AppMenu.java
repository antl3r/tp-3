package classes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// Work smarter

public class AppMenu {
    private List<MenuItem> options;

    public AppMenu(MenuItem... menuItems) {
        this.options = new ArrayList<MenuItem>(Arrays.asList(menuItems));
    }

    public void displayMenu() {
        System.out.println("\nPilih menu\n");
        for (MenuItem option : options) {
            System.out.println(option.number + ". " + option.title);
        }
        System.out.print("\nPerintah: ");
    }

    public Boolean executeOption(int choice) {
        for (MenuItem option : options) {
            if (option.number == choice) {
                option.action.execute();
                return true;
            }
        }
        System.out.println("Pilihan tidak valid."); // yang serius dong
        return false;
    }
}