package ru.com.web.security.details;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.com.web.models.User;

import java.util.Collection;
import java.util.Collections;

public class UsersDetailsImpl implements UserDetails {

	private final User user;

	public UsersDetailsImpl(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = user.getRole().toString();
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
		return Collections.singleton(authority);
	}

	@Override
	public String getPassword() {
		return user.getHashPassword();
	}

	//имя пользователя
	@Override
	public String getUsername() {
		return user.getEmail();
	}

	//аккаунт не просрочен
	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	//аккаунт не заблокирован
	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	//пароль не просрочен
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//пользователь активный
	@Override
	public boolean isEnabled() {
		return true;
	}
}
