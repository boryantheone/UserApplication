package ru.com.web.forms;


import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;

@Data
public class UserForm {

	@NotEmpty
	@Length(max = 15)
	private String firstName;

	@NotEmpty
	@Length(max = 15)
	private String lastName;
}
