package org.example.simpleback.domain.port;

import org.example.simpleback.domain.model.User;

import java.util.List;

public interface UserRepository {
    long count();
    User save(User user);
    List<User> findAll();
}
