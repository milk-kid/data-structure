package org.datastructure.exception;

public class SysException extends RuntimeException{

    public SysException(ExceptionEnums e) {
        super(e.getMessage());
    }
}
