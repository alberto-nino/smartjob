package com.demo.smartjob.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * Class defines the logic to validate urls
 *
 * @author Ruben Pacheco
 * @since 1.2.95
 */
public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    private static final Pattern regxEmail = Pattern.compile("([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][c,l]{2,})");

    /**
     * Validate url format
     *
     * @param email url to validate
     * @param context     context application
     * @return result of validation
     */
    @Override
    public boolean isValid(final String email, final ConstraintValidatorContext context) {

        return regxEmail.matcher(email).matches();

    }
}
