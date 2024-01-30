package com.example.testdoubles;

import com.example.BankService;

public class BankServiceSpy implements BankService {
    private int numberOfCalls = 0;
    private boolean shouldThrowException = false;

    public int getNumberOfCalls() {
        return numberOfCalls;
    }

    @Override
    public void pay(String id, double amount) {
        numberOfCalls++;
        if (shouldThrowException) {
            throw new RuntimeException("Payment failed");
        }
    }

    public void setShouldThrowException(boolean shouldThrowException) {
        this.shouldThrowException = shouldThrowException;
    }
}