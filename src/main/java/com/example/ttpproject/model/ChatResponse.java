package com.example.ttpproject.model;

public record ChatResponse(String message) {}

// Records are a way to reduce boilerplate code. It is final and immutable
// It is shorthand for the below code:

//public final class ChatResponse {
//    private final String message;
//
//    public ChatResponse(String message) {
//        this.message = message;
//    }
//
//    public String message() {
//        return message;
//    }
//
//    @Override
//    public boolean equals(Object o) { ... }
//
//    @Override
//    public int hashCode() { ... }
//
//    @Override
//    public String toString() {
//        return "ChatResponse[message=" + message + "]";
//    }
//}