package Control_API_V4_4;

import Model.SearchAPICondition;
import com.csvreader.CsvWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteCSV {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n\r";
    private static final String HEADER="TC_ID,p1 (Agency secureId),p2(API key id),P_Country,P_Own,P_Min,P_Max,P_PropertyTypes,P_SubType,P_Area,P_Location,P_OwnPropertiesFirst,P_RefId,P_Preferred,Lang,P_Beds,P_Baths,P_Images,P_New_Devs,P_Show_Dev_Prices,P_RentalType,P_RentalDateFrom,P_RentalDateTo,P_IncludeRented,Search_Type" ;
    public static void writeCsvFile(String fileName) throws IOException {
        // Ghi CVS theo điều kiên khớp với API V5

        List<SearchAPICondition> listConditions = new ArrayList<SearchAPICondition>();
//        listSearch.add(propertySearch);

        SearchAPICondition con1= new SearchAPICondition("TC_1","1000610","879dab3e2ed47c64e1c76f4d6f364e53b9432a3d",
                "Spain","","250000","500000","Apartment","","Costa Del Sol",
                "Marbella,Estepona","","","","","","","","","","","","","","");
        SearchAPICondition con2= new SearchAPICondition("TC_1","1000610","879dab3e2ed47c64e1c76f4d6f364e53b9432a3d",
                "Spain","","250000","500000","Apartment","","Costa Del Sol",
                "Marbella,Estepona","","","","","","","","","","","","","","");
        listConditions.add(con1);
        listConditions.add(con2);

        try {
            CsvWriter writer= new CsvWriter(fileName);
            writer.write("TC_ID");
            writer.write("p1 (Agency secureId)");
            writer.write("p2(API key id)");
            writer.write("P_Country");
            writer.write("P_Own");
            writer.write("P_Min");
            writer.write("P_Max");
            writer.write("P_PropertyTypes");
            writer.write("P_SubType");
            writer.write("P_Area");
            writer.write("P_Location");
            writer.write("P_OwnPropertiesFirst");
            writer.write("P_RefId");
            writer.write("P_Preferred");
            writer.write("Lang");
            writer.write("P_Beds");
            writer.write("P_Baths");
            writer.write("P_Images");
            writer.write("P_New_Devs");
            writer.write("P_Show_Dev_Prices");
            writer.write("P_RentalType");
            writer.write("P_RentalDateFrom");
            writer.write("P_RentalDateTo");
            writer.write("P_IncludeRented");
            writer.write("Search_Type");
            writer.endRecord();
            for (int i = 0; i < listConditions.size(); i++) {
                writer.write(listConditions.get(i).getTC_TD());
                writer.write(listConditions.get(i).getP1());
                writer.write(listConditions.get(i).getP2());
                writer.write(listConditions.get(i).getP_Country());
                writer.write(listConditions.get(i).getP_Own());
                writer.write(listConditions.get(i).getP_Min());
                writer.write(listConditions.get(i).getP_Max());
                writer.write(listConditions.get(i).getP_PropertyTypes());
                writer.write(listConditions.get(i).getP_SubType());
                writer.write(listConditions.get(i).getP_Area());
                writer.write(listConditions.get(i).getP_Location());
                writer.write(listConditions.get(i).getP_OwnPropertiesFirst());
                writer.write(listConditions.get(i).getP_RefId());
                writer.write(listConditions.get(i).getP_Preferred());
                writer.write(listConditions.get(i).getP_Lang());
                writer.write(listConditions.get(i).getP_Beds());
                writer.write(listConditions.get(i).getP_Baths());
                writer.write(listConditions.get(i).getP_Images());
                writer.write(listConditions.get(i).getP_New_Devs());
                writer.write(listConditions.get(i).getP_Show_Dev_Prices());
                writer.write(listConditions.get(i).getP_RentalDateFrom());
                writer.write(listConditions.get(i).getP_RentalDateTo());
                writer.write(listConditions.get(i).getP_IncludeRented());
                writer.write(listConditions.get(i).getSearchType());
                writer.endRecord();
            }
            writer.flush();
            writer.close();
            System.out.println("CSV file was created successfully !!!");

        } catch (IOException | CsvWriter.FinalizedException e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        String fileName = "/home/RESALES-ONLINE/baon/Documents/Bao_/CSV_V4.csv";
        writeCsvFile(fileName);

    }
}
