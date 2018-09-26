package com.coingaming.service;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesFactory {

    private FileReader fileReader;
    private Properties properties;

    public PropertiesFactory(){
        //fileReader=null;
        //properties=null;
        loadPropertiesFile();
    }

    private void loadPropertiesFile(){
        try  {
            fileReader = new FileReader("src/main/resources/application.properties");
            properties = new Properties();
            properties.load(fileReader);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getPropertyPathToLog(){
        System.out.println(properties.getProperty("logging.file"));
        return properties.getProperty("logging.file");
    }
}
