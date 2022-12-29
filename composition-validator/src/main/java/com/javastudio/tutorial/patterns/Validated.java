package com.javastudio.tutorial.patterns;

public abstract interface Validated<T> {

   public abstract Validator<T> getValidator(T t);

}
