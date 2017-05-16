package Validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import Entity.*;
public class ColourValidator implements Validator {

		public boolean supports(Class<?> paramClass) {
			return Entity.Colour.class.equals(paramClass);
		}

		public void validate(Object obj, Errors errors) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "colourName", "valid.Colour");
		}
}