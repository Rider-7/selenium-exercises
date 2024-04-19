package com.herokuapp.theinternet.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CsvDataProvider {

    @DataProvider
    public static Iterator<Object[]> csvReader(Method method) {

        List<Object[]> list = new ArrayList<Object[]>();

        // Dynamically create filepath to csv file based on given method.
        String csvPath = "src" + File.separator + "test" + File.separator + "resources" + File.separator
            + "dataproviders" + File.separator + method.getDeclaringClass().getSimpleName() + File.separator
            + method.getName() + ".csv";

        // Create File instance for manipulation.
        File file = new File(csvPath);

        // Read csv file, assign each row as Map key-value pairs, and add each map to a List as an Object array. 
        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            String[] keys = reader.readNext();
            if (keys != null) {
                String[] dataParts;
                while ((dataParts = reader.readNext()) != null) {
                    Map<String, String> testData = new HashMap<String, String>();
                    for (int i = 0; i < keys.length; i++) {
                        testData.put(keys[i], dataParts[i]);
                    }
                    list.add(new Object[] { testData });
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File " + csvPath + " was not found\n");
        } catch (IOException e) {
            throw new RuntimeException("Could not read " + csvPath + "file\n");
        } catch (CsvValidationException e) {
            throw new RuntimeException("Invalid csv line found in file\n");
        }
        
        // Return list as an iterator of Object arrays
        return list.iterator();
}
}
