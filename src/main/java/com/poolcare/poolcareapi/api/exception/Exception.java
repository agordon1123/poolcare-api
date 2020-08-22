package com.poolcare.poolcareapi.exception;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@Builder
@AllArgsConstructor
public class Exception extends RuntimeException {

    // TODO: What is the serialVersionUID?
    // https://www.baeldung.com/java-serial-version-uid#:~:text=Simply%20put%2C%20the%20serialVersionUID%20is,found%2C%20an%20InvalidClassException%20is%20thrown.
    private static final long serialVersionUID = 1L;

    public Exception(String title, String message) {
        super(message);
        this.title = title;
        this.message = message;
    }

    public String title;
    public String message;
    public Throwable cause;

}