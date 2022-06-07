package ru.com.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "account")
public class User {

	public enum Role {
		ADMIN, USER
	}

	@Enumerated(value = EnumType.STRING)
	private Role role;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String firstName;
	private String lastName;

	@Column(unique = true)
	private String email;

	private String hashPassword;

	@OneToMany(mappedBy = "owner")
	private List<Car> cars;
}
