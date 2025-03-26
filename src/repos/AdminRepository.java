package repos;

import java.util.ArrayList;
import java.util.List;

public class AdminRepository {
    /**
     * We are not using arrays bro 🥀
     */
    private List<Admin> adminList = new ArrayList<>();

    {
        adminList.add(new Admin("admin1", "password1"));
        adminList.add(new Admin("admin2", "password2"));
        adminList.add(new Admin("admin3", "password3"));
        adminList.add(new Admin("pertamina", "12341234", 1937000)); //193.7 jt pun cukup
    }

    public Admin login(String username, String password) {
        for (Admin admin : adminList) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return admin;
            }
        }
        return null;
    }
}
