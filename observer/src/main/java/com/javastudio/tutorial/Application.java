package com.javastudio.tutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        LOGGER.info("Application started!");
        try {
            DocumentFinder finder = new DocumentFinder();
            finder.addObserver(new DocumentIndexer());
            finder.scanDirectory("C:\\Users\\hossein\\DATA");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
