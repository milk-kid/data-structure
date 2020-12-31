package org.datastructure.exception;

public enum ExceptionEnum implements ExceptionEnums {
    ELEMENT_FULL("元素已满！"),
    ELEMENT_EMPTY("元素为空！"),
    ELEMENT_NOT_EXIST("元素不存在");

    private String message;

    ExceptionEnum(String description) {
        this.message = description;
    }

    public String getMessage() {
        return message;
    }


}
