package app.service;

import app.model.User;

public interface UserService {

    User getUserbyUsername(String userName);
    User saveUser(User user);
}
