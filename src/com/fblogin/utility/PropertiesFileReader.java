package com.fblogin.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

    public Properties getProperties() throws IOException {
        Properties properties = new Properties();

        try {
            properties.load( new FileInputStream("resources/browser-config.properties") );
        } catch (Exception e) {
            System.out.println(e);
        }
        return properties;
    }

}
