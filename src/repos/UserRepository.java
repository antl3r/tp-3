package repos;

import abstracts.User;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

/**
 * @class UserRepository
 * @brief A repository class for managing User objects.
 * 
 * This class provides methods to add, remove, and retrieve User objects
 * from an internal array.
 */
public class UserRepository {
    private List<User> userList = new ArrayList<>(); // We are not using arrays 🥀

    /**
     * Retrieves the role of a user by their username.
     *
     * @param username the username of the user
     * @return the role of the user, or an empty string if the user is not found
     */
    public String getUserRole(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user.getRole();
            }
        }
        return new String();
    }

    /**
     * Retrieves a user by their unique ID.
     *
     * @param id the unique ID of the user
     * @return the User object, or null if the user is not found
     */
    public User getUserById(UUID id) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Retrieves a user by their username.
     *
     * @param username the username of the user
     * @return the User object, or null if the user is not found
     */
    public User getUserByName(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Retrieves all users in the repository.
     *
     * @return an array of all User objects
     */
    public User[] getAll() {
        return userList.toArray(new User[0]);
    }

    /**
     * Adds a user to the repository.
     *
     * @param user the User object to add
     */
    public void addUser(User user) {
        userList.add(user);
    }

    /**
     * Removes a user from the repository.
     *
     * @param user the User object to remove
     */
    public void removeUser(User user) {
        userList.remove(user);
    }
}
