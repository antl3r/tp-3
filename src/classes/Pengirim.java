package classes;

import abstracts.User;

public class Pengirim extends User {
    public Pengirim(String username, String password, long balance) {
        super(username, password, "Pengirim");
        this.setBalance(balance);
    }

    public Pengirim(String username, String password) {
        super(username, password, "Pengirim");
    }
}
