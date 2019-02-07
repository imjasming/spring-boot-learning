package com.xiaoming.springbootlearning.exception;

/**
 * @author Xiaoming.
 * Created on 2019/02/06 01:43.
 * Description :
 */
public class StorageFileNotFoundException extends StorageException {

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}