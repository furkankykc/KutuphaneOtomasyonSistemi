package Validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import Entity.*;
public class PublisherValidator implements Validator {

		public boolean supports(Class<?> paramClass) {
			return Entity.Publisher.class.equals(paramClass);
		}

		public void validate(Object obj, Errors errors) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "valid.Publisher");
		}
}