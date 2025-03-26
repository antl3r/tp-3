package abstracts;
import java.util.UUID;

public abstract class User {
    private UUID id;
    private String username;
    private String password;
    private String role;
    private long balance;

    public User(String username, String password, String role) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.password = password;
        setRole(role);
        this.balance = 0;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public long getBalance() {
        return balance;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setRole(String role) {
        if (role.equals("Pembeli") || role.equals("Penjual") || role.equals("Pengirim") || role.equals("Admin")) {
            this.role = role;
        } else {
            throw new IllegalArgumentException("Role can only be either 'Pembeli', 'Penjual', or 'Pengirim'");
        }
    }

    //public abstract void getRiwayatTransaksi(Transaksi[] transaksi); //wtf?
}
