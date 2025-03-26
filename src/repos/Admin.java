package repos;

import abstracts.User;

public class Admin extends User {
    public Admin(String username, String password, long balance) {
        super(username, password, "Admin");
        this.setBalance(balance);
    }

    public Admin(String username, String password) {
        super(username, password, "Admin");
    }
}
