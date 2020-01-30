package hu.flow.ktomi.BookShare.exceptions;

import javax.validation.ValidationException;

public class idValidationException extends ValidationException {

    public idValidationException() {super("Invalid ID!"); }
}
