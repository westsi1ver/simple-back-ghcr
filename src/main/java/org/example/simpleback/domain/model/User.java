package org.example.simpleback.domain.model;

public record User(Long id, String name, String email) {
    public static User create(String name, String email) {
        return new User(null, name, email);
    }
}
