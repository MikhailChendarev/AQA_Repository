package org.example.utils;

import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CsvUtils {

    @DataProvider(name = "userData")
    public Object[][] userDataProvider() throws IOException, CsvException {
        List<Object[]> data = new ArrayList<>();
        try (CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader(Paths.get("src/main/resources/pairwiseUsers.csv").toFile()))) {
            Map<String, String> record;
            while ((record = reader.readMap()) != null) {
                data.add(new Object[]{
                        record.get("Имя"),
                        record.get("Фамилия"),
                        record.get("email"),
                        record.get("username"),
                        record.get("plain_password"),
                        record.get("roles"),
                        Boolean.parseBoolean(record.get("isCV")),
                        record.get("Открытие поиска"),
                        record.get("Статус поиска")
                });
            }
        }
        return data.toArray(new Object[0][0]);
    }

}
