package org.example.core_data;

public class CException {

    public static class AccessNullptr extends RuntimeException {
        public AccessNullptr(String message) {
            super(message);
        }
    }
}
