package ru.com.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.com.web.forms.SignUpForm;
import ru.com.web.models.User;
import ru.com.web.repositories.UsersRepository;

@RequiredArgsConstructor
@Component
public class SignUpServiceImpl implements SignUpService {

	private final PasswordEncoder passwordEncoder;
	private final UsersRepository usersRepository;

	@Override
	public void signUpUser(SignUpForm form) {
		User user = User.builder()
				.firstName(form.getFirstName())
				.lastName(form.getLastName())
				.email(form.getEmail())
				.role(User.Role.USER)
				.hashPassword(passwordEncoder.encode(form.getPassword()))
				.build();

		usersRepository.save(user);
	}
}
