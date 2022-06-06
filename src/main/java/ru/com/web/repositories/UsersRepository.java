package ru.com.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.com.web.models.User;

public interface UsersRepository extends JpaRepository<User, Integer> {
}
