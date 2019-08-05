package mum.edu.domain;

import java.io.Serializable;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class Employee  {

    @NotEmpty
 	private String firstName;
	@NotEmpty
 	private String lastName;
	@NotEmpty
 	private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
