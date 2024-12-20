package org.example.javacore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class UpdateConfigFile {
/*

    public static void main(String... args) throws IOException {
        System.out.println("Properties updated successfully");
    }
*/

    public static void changeAddProperty(String filename, String key, String value) throws IOException {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream(filename));
            prop.setProperty(key, value);
            prop.store(new FileOutputStream(filename), null);
        } catch (FileNotFoundException e) {
            System.out.println("Exception" + e.getMessage());
        }

    }
}
