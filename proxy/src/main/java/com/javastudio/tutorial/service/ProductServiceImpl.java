package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductServiceImpl implements ProductService {

    private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public void init() {
        logger.info("ProductServiceImpl -> init");
    }
}
