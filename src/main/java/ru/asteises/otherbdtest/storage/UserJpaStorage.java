package ru.asteises.otherbdtest.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.asteises.otherbdtest.model.User;

import java.util.UUID;

@Repository
public interface UserJpaStorage extends JpaRepository<User, UUID> {
}
