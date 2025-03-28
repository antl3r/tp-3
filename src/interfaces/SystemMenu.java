package interfaces;

import classes.AppMenu;

public interface SystemMenu {
    /**
     * Method yang digunakan untuk menampilkan pilihan menu suatu class yang mengimplementasikan SystemMenu.
     * @example MainMenuSystem akan menampilkan menu berupa login, register, hari berikutnya, atau exit.
    */
    void showMenu();

    /*
     * "Method yang digunakan untuk mengatasi segala macam opsi pilihan suatu system.
     * Perbedaannya dengan showMenu() adalah method ini akan meminta input berdasarkan pilihan menu yang diberikan showMenu,
     * kemudian memprosesnya lebih lanjut."
     * who's doing that?
    void handleMenu();
    */
}
