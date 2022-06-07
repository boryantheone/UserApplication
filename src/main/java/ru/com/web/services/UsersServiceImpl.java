package ru.com.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.com.web.forms.UserForm;
import ru.com.web.models.Car;
import ru.com.web.models.User;
import ru.com.web.repositories.CarsRepository;
import ru.com.web.repositories.UsersRepository;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UsersServiceImpl implements UsersService {

	private final UsersRepository usersRepository;
	private final CarsRepository carsRepository;

	@Override
	public void addUser(UserForm form) {
		User user = User.builder()
				.firstName(form.getFirstName())
				.lastName(form.getLastName())
				.build();

		usersRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return usersRepository.findAll();
	}

	@Override
	public void deleteUser(Integer userId) {
		usersRepository.deleteById(userId);
	}

	@Override
	public User getUser(Integer userId) {
		return usersRepository.getById(userId);
	}

	@Override
	public List<Car> getCarsWithoutOwners() {
		return carsRepository.findAllByOwnerIsNull();
	}

	@Override
	public void addCarToUser(Integer userId, Integer carId) {
		User user = usersRepository.getById(userId);
		Car car = carsRepository.getById(userId);
		car.setOwner(user);
		carsRepository.save(car);
	}

	@Override
	public List<Car> getCarsByUser(Integer userId) {
		return carsRepository.findAllByOwner_Id(userId);
	}

}
