package org.example.simpleback.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface SpringDataUserRepository extends JpaRepository<UserJpaEntity, Long> {
}
