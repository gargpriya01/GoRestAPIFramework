package com.gorest.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static Properties prop=new Properties();

    static{
        try{
            FileInputStream fis=new FileInputStream("src/test/resources/config.properties");
                    prop.load(fis);
        }
     catch (IOException e) {
        throw new RuntimeException("Failed to load config.properties file", e);
    }}

        public static String getBaseURI(){
            return prop.getProperty("baseURI");
        }


        public static String getAuthToken() {
            return prop.getProperty("authToken");
            //return "Bearer "+System.getenv("GOREST_TOKEN");  //getting token from github secret
        }

        public static boolean isParallelExecution() {
            return Boolean.parseBoolean(prop.getProperty("parallel", "false"));
        }

        public static int getRetryCount() {
            return Integer.parseInt(prop.getProperty("retryCount", "1"));
        }

}
