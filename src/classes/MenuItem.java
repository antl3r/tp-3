package classes;

import interfaces.MenuAction;

public class MenuItem {
    int number;
    String title;
    MenuAction action;

    public MenuItem(int number, String title, MenuAction action) {
        this.number = number;
        this.title = title;
        this.action = action;
    }
}
