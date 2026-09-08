package org.example.simpleback.app;

import org.example.simpleback.domain.model.User;

import java.util.List;

public interface UserQueryUseCase {
    List<User> getUsers();
}
