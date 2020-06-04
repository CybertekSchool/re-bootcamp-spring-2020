package com.cybertek.library.utilities.common;


import java.io.FileInputStream;
import java.util.Properties;

public class Environment {
    private static Properties properties;

    static {
        try {
            // LOAD GENERAL PROPERTIES
            String path = "configuration.properties";
            FileInputStream input = new FileInputStream(path);

            properties = new Properties();
            properties.load(input);

            // LOAD ENVIRONMENT SPECIFIC PROPERTIES
            if (System.getProperty("env") != null) {
                path = "src/test/resources/env/" + System.getProperty("env") + ".properties";
            } else {
                path = "src/test/resources/env/" + properties.getProperty("env") + ".properties";
            }
            input = new FileInputStream(path);
            properties.load(input);


            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String getProperty(String keyName) {
        return properties.getProperty(keyName);
    }
}