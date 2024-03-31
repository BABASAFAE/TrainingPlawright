package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

        private Properties properties;

        //Raed from properties files and returns properties object
        public Properties initProp() {
            properties = new Properties();
            try {
                FileInputStream fileInputStream = new FileInputStream("./src/test/resources/config/config.properties");
                properties.load(fileInputStream);
            } catch (Exception e) {
                Utils.logger.info("Unable to read Properties file.");
            }
            return properties;
        }

    }
