package controller;

import model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserController {
    private final Map<String, User> userMap;

    public UserController() {
        userMap = new HashMap<>();
    }

    public User getUser(String userId) {
        return userMap.get(userId);
    }

    public User addUser(String userId, String username) {
        return userMap.putIfAbsent(userId, new User(userId,username));
    }

    public List<String> getAllUserIds() {
        return userMap.keySet().stream().collect(Collectors.toList());
    }
}
