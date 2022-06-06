package ru.com.web.services;

import ru.com.web.forms.UserForm;
import ru.com.web.models.Car;
import ru.com.web.models.User;

import java.util.List;

public interface UsersService {
	void addUser(UserForm form);
	List<User> getAllUsers();
	void deleteUser(Integer userId);
	User getUser(Integer userId);
	public List<Car> getCarsByUser(Integer userId);
	List<Car> getCarsWithoutOwners();
	void addCarToUser(Integer userId, Integer carId);
}
