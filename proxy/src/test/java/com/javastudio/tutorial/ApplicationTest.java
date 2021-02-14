package com.javastudio.tutorial;

import com.javastudio.tutorial.api.ProductService;
import com.javastudio.tutorial.proxy.MetricHandler;
import com.javastudio.tutorial.service.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;

class ApplicationTest {

    private Logger logger = LoggerFactory.getLogger(ApplicationTest.class);

    @Test
    void proxy() {
        ProductService productService = new ProductServiceImpl();
        ProductService proxy = (ProductService) Proxy.newProxyInstance(ProductServiceImpl.class.getClassLoader(),
                new Class[]{ProductService.class},
                new MetricHandler(productService));
        proxy.init();
    }
}