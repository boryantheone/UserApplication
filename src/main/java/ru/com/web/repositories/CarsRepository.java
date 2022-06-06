package ru.com.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.com.web.models.Car;

import java.util.List;

public interface CarsRepository extends JpaRepository<Car, Integer> {
	List<Car> findAllByOwner_Id(Integer id);
	List<Car> findAllByOwnerIsNull();
}
