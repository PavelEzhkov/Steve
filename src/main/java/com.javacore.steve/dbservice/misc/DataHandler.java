package com.javacore.steve.dbservice.misc;

import java.io.File;

public interface DataHandler {
    default void handleString(String line) { };
    default void handleFile(final File file){ };
    default void handleFile(String filePath) { };
}
