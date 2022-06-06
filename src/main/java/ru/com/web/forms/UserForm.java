package ru.com.web.forms;


import lombok.Data;
import org.hibernate.validator.constraints.*;

@Data
public class UserForm {
	@javax.validation.constraints.NotEmpty
	@Length(max = 15)
	private String firstName;
	@javax.validation.constraints.NotEmpty
	@Length(max = 15)
	private String lastName;
}
