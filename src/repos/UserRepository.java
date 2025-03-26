package repos;

import abstracts.User;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> userList = new ArrayList<>();

    public String getUserRole(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user.getRole();
            }
        }
        return new String();
    }

    public User getUserById(UUID id) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public User getUserByName(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public User[] getAll() {
        return userList.toArray(new User[0]);
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void removeUser(User user) {
        userList.remove(user);
    }
}
