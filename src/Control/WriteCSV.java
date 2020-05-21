package Control;

import Model.PropertySearch1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteCSV {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    public static void writeCsvFile(String fileName) {
        // Ghi CVS theo điều kiên khớp với API V5

        PropertySearch1 p2 = new PropertySearch1("3598", "Spain", "Málaga", "no", 0, 256920, "Apartment");
        List<PropertySearch1> listSearch = new ArrayList<PropertySearch1>();
//        listSearch.add(propertySearch);
        listSearch.add(p2);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
//            for (Model.PropertySearch1 propertySearch1 : listSearch) {
            for (int i = 0; i < listSearch.size(); i++) {
                fileWriter.append(listSearch.get(i).getApiId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(listSearch.get(i).getCountry());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(listSearch.get(i).getProvince_Area());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(listSearch.get(i).getLocation());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listSearch.get(i).getPriceFrom()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listSearch.get(i).getPriceTo()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(listSearch.get(i).getType_Subtype());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully !!!");

        } catch (IOException e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

}
