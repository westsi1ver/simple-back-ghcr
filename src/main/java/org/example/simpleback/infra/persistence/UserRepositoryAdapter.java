package org.example.simpleback.infra.persistence;

import lombok.RequiredArgsConstructor;
import org.example.simpleback.domain.model.User;
import org.example.simpleback.domain.port.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {
    private final SpringDataUserRepository jpaRepository;

    @Override
    public long count() {
        return jpaRepository.count();
    }

    @Override
    public User save(User user) {
        return jpaRepository.save(UserJpaEntity.from(user)).toDomain();
    }

    @Override
    public List<User> findAll() {
        return jpaRepository.findAll().stream()
                .map(UserJpaEntity::toDomain)
                .toList();
    }
}
