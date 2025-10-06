package org.example.includes;

public class exceptions {

    // thrown when user enters invalid input type
    public static class InvalidInputTypeException extends RuntimeException {
        public InvalidInputTypeException(String message) {
            super(message);
        }

        public String additionalInfo() {
            return "Wrong data type";
        }
    }

    // thrown when an object fails to instantiate (optional, e.g., factory fails)
    public static class FailedInstantiationException extends RuntimeException {
        public FailedInstantiationException(String message) {
            super(message);
        }

        public String additionalInfo() {
            return "Warning! Failed instantiation";
        }
    }

}
