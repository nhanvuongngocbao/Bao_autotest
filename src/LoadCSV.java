import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LoadCSV {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER ="searchType,country,province_Area,location,priceFrom,priceTo,type_Subtype,onlyOwnProperties,onlyFeaturedProperties,ownPropertyFirst,onlyPreferredAgencies,urbanisation";

    public static void writeCsvFile(String fileName){

        PropertySearch1 propertySearch = new PropertySearch1("ForSale", "Spain", "Malaga", "Costa Del Sol", 0, 0, "Apartment", false, false, false, false, "a");
        PropertySearch1 propertySearch12 = new PropertySearch1("ForSale", "Spain", "Malaga", "Costa Del Sol", 0, 0, "Apartment", false, false, false, false, "b");
        List<PropertySearch1> listSearch = new ArrayList<PropertySearch1>();
        listSearch.add(propertySearch);
        listSearch.add(propertySearch12);
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);

//            fileWriter.append(FILE_HEADER);
//
//            fileWriter.append(NEW_LINE_SEPARATOR);

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

    public static void readCsvFile(String fileName) throws IOException {
        BufferedReader br =null;
        try {
            String line;
            br = new BufferedReader(new FileReader(fileName));
            while ((line=br.readLine())!=null){
                System.out.println(line);
                print(parseCsvLine(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }

    }
    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<String>();
        List<PropertySearch1> listSearch = new ArrayList<PropertySearch1>();

        if (csvLine != null) {
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }

            PropertySearch1 p = new PropertySearch1();
            p.setSearchType(splitData[0]) ;
            p.setCountry(splitData[1]);
            p.setProvince_Area(splitData[2]);
            p.setLocation(splitData[3]);
            p.setPriceFrom(Double.parseDouble(splitData[4]));
            p.setPriceTo(Double.parseDouble(splitData[5]));
            p.setType_Subtype(splitData[6]);
            p.setOnlyOwnProperties(Boolean.parseBoolean(splitData[7]));
            p.setOnlyFeaturedProperties(Boolean.parseBoolean(splitData[8]));
            p.setOwnPropertyFirst(Boolean.parseBoolean(splitData[9]));
            p.setOnlyPreferredAgencies(Boolean.parseBoolean(splitData[10]));
            p.setUrbanisation(splitData[11]);
            System.out.println(" test nè " +p.toString());

        }


        return result;
    }
//    public static String xuLi(String str){
//        String st="";
//        BufferedReader br =null;
//        try {
//            String line;
//            br = new BufferedReader(new FileReader(fileName));
//            while ((line=br.readLine())!=null){
//                print(parseCsvLine(line));
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                if (br != null)
//                    br.close();
//            } catch (IOException crunchifyException) {
//                crunchifyException.printStackTrace();
//            }
//        }
//
//        return st;
//    }
    private static void print(List<String> l) {
        System.out.println(l.toString());
    }
    public static void main(String[] args) throws IOException {
        String fileName = "/home/RESALES-ONLINE/baon/Documents/Bao_/CSV.csv";
//        writeCsvFile(fileName);
        readCsvFile(fileName);
    }
}
