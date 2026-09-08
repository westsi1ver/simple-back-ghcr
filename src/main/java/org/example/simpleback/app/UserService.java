package org.example.simpleback.app;

import lombok.RequiredArgsConstructor;
import org.example.simpleback.domain.model.User;
import org.example.simpleback.domain.port.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserQueryUseCase {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public List<User> getUsers() {
        if (userRepository.count() == 0) {
            userRepository.save(User.create("infra-admin", "admin@example.com"));
        }
        return userRepository.findAll();
    }
}
