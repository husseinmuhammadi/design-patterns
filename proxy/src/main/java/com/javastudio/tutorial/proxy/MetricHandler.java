package com.javastudio.tutorial.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MetricHandler implements InvocationHandler {
    private Logger logger = LoggerFactory.getLogger(MetricHandler.class);
    private final Object target;

    public MetricHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info("before call method " + method.getName());
        Object o = method.invoke(target, args);
        logger.info("after call method " + method.getName());
        return o;
    }
}
