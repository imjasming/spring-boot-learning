package com.xiaoming.springbootlearning.exception;

/**
 * @author Xiaoming.
 * Created on 2019/02/06 01:43.
 * Description :
 */
public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
