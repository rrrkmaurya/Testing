package com.data.WEINVEST;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;


public class PropertiesFile {


        public static Properties prop = new Properties();


    public static void readPropertiesFIle() throws Exception {

        String path = new File("src/main/java/com/data/WEINVEST/path.properties")
                .getAbsolutePath();
        prop.load(new InputStreamReader(new FileInputStream(path), "UTF8"));

    }
    
  
}
