package repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.User;

public class UserRepository implements IRepository<User> {

    private static UserRepository instance;
    private Map<Integer, User> users = new HashMap<>();
    private int userIdCounter = 1;

    public static UserRepository getInstance() {
        if (instance == null) {
            return new UserRepository();
        }

        return instance;
    }

    // Create
    public void add(User user) {
        user.setId(userIdCounter++);
        users.put(user.getId(), user);
    }

    // Read
    public User getById(int userId) {
        return users.get(userId);
    }

    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    // Update
    public boolean update(User updatedUser) {
        if (users.containsKey(updatedUser.getId())) {
            users.put(updatedUser.getId(), updatedUser);
            return true;
        }
        return false; // User not found
    }

    // Delete
    public boolean delete(int userId) {
        if (users.containsKey(userId)) {
            users.remove(userId);
            return true;
        }
        return false; // User not found
    }
}

