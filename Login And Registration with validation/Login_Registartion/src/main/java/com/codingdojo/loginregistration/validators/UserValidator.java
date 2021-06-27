package com.codingdojo.loginregistration.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.codingdojo.loginregistration.models.User;

@Component
public class UserValidator implements Validator {

	// 1
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	// 2
	@Override
	public void validate(Object target, Errors errors) { //Errors is the parent class and the BindingResult extends it
		User user = (User) target;

		if (!user.getPasswordConfirmation().equals(user.getPassword())) {
			// 3
			errors.rejectValue("passwordConfirmation", "Match"); //this method is found only in the parent (Errors) that's why we don't need to cast the errors to binding rsult object.
		}
	}
}