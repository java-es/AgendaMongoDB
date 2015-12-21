package com.wordpress.javaes.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author https://javaes.wordpress.com/
 */
public class Util {
    public static Properties getProp() throws IOException { 
        Properties props = new Properties(); 
        FileInputStream file = new FileInputStream( "./properties/configuracoes.properties"); 
        props.load(file); 
        return props; 
    }
}
