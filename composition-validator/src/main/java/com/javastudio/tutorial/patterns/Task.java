package com.javastudio.tutorial.patterns;

public class Task extends TaskBase<Transaction>{

    PinValidator pinValidator;

    @Override
    public Validator<Transaction> getValidator(Transaction transaction) {
        return pinValidator;
    }
}
