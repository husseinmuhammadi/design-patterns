package com.javastudio.tutorial;

import com.javastudio.tutorial.utils.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Observable;

public class DocumentFinder extends Observable {
    private Logger logger = LoggerFactory.getLogger(DocumentFinder.class);

    public void scanDirectory(String directory) throws IOException {
        File[] files = new File(directory).listFiles();

        for (File file : files) {
            if (file.isFile()) {
                // final String fileName = file.getCanonicalPath();
                final String fileName = file.getName();
                FileUtil.getExtension(file.getName()).ifPresent(extension -> {
                    if (extension.equals("pdf")) {
                        logger.info("{}", fileName);
                        setChanged();
                        notifyObservers(fileName);
                    }
                });

            } else if (file.isDirectory()) {
                scanDirectory(file.getCanonicalPath());
            }
        }
    }
}
