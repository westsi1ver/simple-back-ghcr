package org.example.simpleback.infra.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.simpleback.domain.model.User;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class UserJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    UserJpaEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }

    static UserJpaEntity from(User user) {
        return new UserJpaEntity(user.name(), user.email());
    }

    User toDomain() {
        return new User(id, name, email);
    }
}
