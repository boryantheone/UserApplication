package ru.com.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.com.web.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);
}
