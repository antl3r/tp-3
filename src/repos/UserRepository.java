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
    /**
    * We are not using arrays bro 🥀
    */
    private List<User> userList = new ArrayList<>(); 

    /**
     * Retrieves all roles of users by their username
     *
     * @param user2 the username of the user
     * @return a list of roles of the user, or an empty list if no users are found
     */
    public List<String> getUserRoles(String user2) {
        List<String> roles = new ArrayList<>();
        for (User user : userList) {
            if (user.getUsername().equals(user2)) {
                System.out.println("WATCH ME " + user.getRole());
                roles.add(user.getRole());
            }
        }
        return roles;
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
     * Retrieves a user by their username and role.
     *
     * @param username the username of the user
     * @param role the role of the user
     * @return the User object, or null if the user is not found
     */
    public User getUserByNameAndRole(String username, String role) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getRole().equals(role)) {
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
     * @throws IllegalArgumentException if a user with the same username and role already exists
     */
    public Boolean addUser(User user) {
        for (User existingUser : userList) {
            if (existingUser.getUsername().equals(user.getUsername()) && existingUser.getRole().equals(user.getRole())) {
                return false;
            }
        }
        userList.add(user);
        return true;
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
