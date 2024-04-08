package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public static List<Map<String, String>> csvToMap(String csvFilePath) {
        List<Map<String, String>> lines = new ArrayList<>();
        String line;
        String csvSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            line = br.readLine();
            List<String> firstLine = Arrays.asList(line.split(csvSplitBy));
            while ((line = br.readLine()) != null) {
                List<String> data = Arrays.asList(line.split(csvSplitBy));
                Map<String, String> map = IntStream.range(0, firstLine.size())
                        .boxed()
                        .collect(Collectors.toMap(firstLine::get, data::get));
                lines.add(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;

    }
}
