package com.demo.controller;

public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T object;

    public static class ResponseBuilder {
        private boolean success;
        private String message;

        private ResponseBuilder(boolean success) {
            this.success = success;
            this.message = "";
        }

        public ResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public <C> ApiResponse<C> object(C object) {
            return new ApiResponse<C>(success, message, object);
        }

        public <C> ApiResponse<C> build() {
            return new ApiResponse<>(success, message, null);
        }
    }

    public static ResponseBuilder success() {
        return new ResponseBuilder(true);
    }

    public static ResponseBuilder failure() {
        return new ResponseBuilder(false);
    }

    private ApiResponse(boolean success, String message, T object) {
        this.success = success;
        this.message = message;
        this.object = object;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
