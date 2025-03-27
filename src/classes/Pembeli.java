package classes;

import abstracts.User;

public class Pembeli extends User {
    private Cart keranjang;

    public Cart getKeranjang() {
        return keranjang;
    }

    public Pembeli(String username, String password, long balance) {
        super(username, password, "Pembeli");
        this.setBalance(balance);
    }

    public Pembeli(String username, String password) {
        super(username, password, "Pembeli");
    }
}
