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
        PropertySearch1 propertySearch123 = new PropertySearch1("ForSale", "Spain", "Malaga", "Costa Del Sol", 0, 0, "Apartment", false, false, false, false, "b","1000610");
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
            p.setSecureID(splitData[12]);
            listSearch.add(p);
        }

        System.out.println(" test nè " +listSearch.toString());
        return result;
    }
    public static String xuLy(PropertySearch1 pro){
        String st="select * from tblresale where ";
        StringBuilder bulider = new StringBuilder();
        bulider.append(st);
            switch (pro.getSearchType()){
                case "ForSale":
                    bulider.append(" RsForSale = 1 ");
                    break;
                case "ForLongRent":
                    bulider.append(" RsForRentLong = 1 ");
                    break;
                case "ForShortRent":
                    bulider.append(" RsForRentShort = 1 ");
                    break;
            }
            if (pro.getCountry()!= "no"){
                bulider.append("and RsCountry = "+"'" +pro.getCountry()+"'");
            }
            if (pro.getProvince_Area() != "no"){
                bulider.append(" and (( RsProvince = "+"'"+ pro.getProvince_Area() +"'" + ") OR ( RsArea = "   +"'"+ pro.getProvince_Area() +"'" + " ))");
            }
            if (pro.getLocation()!="no"){
                bulider.append("and RsLocation = "+"'" +pro.getLocation()+"'");
            }
            switch (pro.getSearchType()){
                    case "ForSale":
                        if (pro.getPriceTo()>0){
                        bulider.append(" and (RsSalePrice >= "+ pro.getPriceFrom() + " and  RsSalePrice <= " +pro.getPriceTo()+")" );
                            }
                        else {
                            bulider.append("and  RsSalePrice >= "+ pro.getPriceFrom());
                        }
                        break;
                    case "ForLongRent":
                        if (pro.getPriceTo()>0){
                            bulider.append(" and (RsLongTermRental >= "+ pro.getPriceFrom() + " and  RsLongTermRental <= " +pro.getPriceTo()+")" );
                        }
                        else {
                            bulider.append(" and RsLongTermRental >= "+ pro.getPriceFrom());
                        }
                        break;
                    case "ForShortRent":
                        if (pro.getPriceTo()>0){
                            bulider.append(" and (( RsShortTermRentalLow >= " + pro.getPriceFrom() + " and  RsShortTermRentalLow  <= " +pro.getPriceTo() + ")  OR (  RsShortTermRentalHigh >= "   +  pro.getPriceFrom() + " and RsShortTermRentalHigh <= " +pro.getPriceTo()+"))" ) ;
                        }
                        else {
                            bulider.append("  and (( RsShortTermRentalLow >= "+ pro.getPriceFrom() + ")  OR (  RsShortTermRentalHigh >= "   +  pro.getPriceFrom() +  "))");
                        }
                        break;
                }
            if(pro.getType_Subtype()!="no"){
                bulider.append(" and ((RsType = " +"'"+pro.getType_Subtype() +"') OR ( RsSubType = "+"'"+pro.getType_Subtype()+"'"+ "))");
            }
            if (pro.isOnlyOwnProperties()==true){
                bulider.append(" and RsAgencyContactSecureId = "+ pro.getSecureID());
            }
            if(pro.isOnlyFeaturedProperties()==true){
                switch (pro.getSearchType()){
                    case "ForSale":
                        bulider.append(" and RsFeaturedPropertySale = 1 ");
                        break;
                    case  "ForLongRent" :
                        bulider.append(" and RsFeaturedPropertyRentalLong = 1 ");

                    case "ForShortRent":
                        bulider.append(" and RsFeaturedPropertyRentalShort = 1");
                }
            }
            if(pro.getUrbanisation() != "no"){
                bulider.append("");
        }
        st=bulider.toString();
        return st;
    }
    private static void print(List<String> l) {
        System.out.println(l.toString());
    }
    public static void main(String[] args) throws IOException {
        String fileName = "/home/RESALES-ONLINE/baon/Documents/Bao_/CSV.csv";
//        writeCsvFile(fileName);
        PropertySearch1 propertySearch = new PropertySearch1("ForShortRent", "Spain", "Malaga", "Estepona", 0, 2120, "Apartment", false, false, false, false, "a");
//        readCsvFile(fileName);
        System.out.println(xuLy(propertySearch));
    }
}
