package com.javastudio.tutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class DocumentIndexer implements Observer {
    private Logger logger = LoggerFactory.getLogger(DocumentIndexer.class);


    @Override
    public void update(Observable o, Object arg) {
        new Thread(() -> {
            try {
                logger.info("Start indexing {}", arg);
                Thread.sleep(new Random().nextInt(1000));
                logger.info("End indexing {}", arg);
            } catch (InterruptedException e) {
                logger.warn("Error indexing {}", arg, e);
            }
        }).start();
    }
}
