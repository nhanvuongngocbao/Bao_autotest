import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LoadCSV {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    private static final String FILE_HEADER ="searchType,country,province_Area,location,priceFrom,priceTo,type_Subtype,onlyOwnProperties,onlyFeaturedProperties,ownPropertyFirst,onlyPreferredAgencies,urbanisation";

    public static void writeCsvFile(String fileName){
        PropertySearch1 propertySearch = new PropertySearch1("ForSale", "Spain", "Malaga", "Costa Del Sol", 0, 0, "Apartment", false, false, false, false, "1");
        List<PropertySearch1> listSearch = new ArrayList<PropertySearch1>();
        listSearch.add(propertySearch);
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);

            fileWriter.append(FILE_HEADER);

            fileWriter.append(NEW_LINE_SEPARATOR);

            for (PropertySearch1 propertySearch1 : listSearch) {
                fileWriter.append(propertySearch1.getSearchType());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(propertySearch1.getCountry());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(propertySearch1.getProvince_Area());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(propertySearch1.getLocation());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(propertySearch1.getPriceFrom()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(propertySearch1.getPriceTo()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(propertySearch1.getType_Subtype());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(propertySearch1.isOnlyOwnProperties()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(propertySearch1.isOnlyFeaturedProperties()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(propertySearch1.isOwnPropertyFirst()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(propertySearch1.isOnlyPreferredAgencies()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(propertySearch1.getUrbanisation());
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
    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<String>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }
    private static void print( List<String> result){
        System.out.println(result.toString());
    }
    public static void readCSV(String fileName){
        BufferedReader br = null;

        try {
            String line;
            br = new BufferedReader(new FileReader(fileName));

            // How to read file in java line by line?
            while ((line = br.readLine()) != null) {
                print(parseCsvLine(line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }
    public static String parseSearchString(List<String>  listStr){
        String string="";
        StringBuilder builder= new StringBuilder();
        return string;
    }
    public static void main(String[] args) {
        String fileName = "/home/RESALES-ONLINE/baon/Documents/Bao_/CSV.csv";
//        writeCsvFile(fileName);
        readCSV(fileName);
    }
}
