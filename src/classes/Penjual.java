package classes;

import abstracts.User;

public class Penjual extends User {
    private String namaToko;

    public Penjual(String username, String password, String namaToko, long balance) {
        super(username, password, "Penjual");
        this.namaToko = namaToko;
        this.setBalance(balance);
    }

    public Penjual(String username, String password, String namaToko) {
        super(username, password, "Penjual");
        this.namaToko = namaToko;
    }

    public void setNamaToko(String namaToko) {
        this.namaToko = namaToko;
    }

    public String getNamaToko() {
        return namaToko;
    }
}
