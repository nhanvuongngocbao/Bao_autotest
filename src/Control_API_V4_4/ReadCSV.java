package Control_API_V4_4;

import Model.SearchAPICondition;
import com.csvreader.CsvReader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ReadCSV {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    public static ArrayList<String> readCsvFile(String fileName) throws IOException, CsvReader.CatastrophicException, CsvReader.FinalizedException {
        // Đọc file CSV theo mẫu
        // Đưa ra danh ách các API request
        ArrayList<String> list = new ArrayList<>();
        CsvReader docfile = new CsvReader(fileName);
        docfile.readHeaders();
        while (docfile.readRecord()){
            SearchAPICondition condition = new SearchAPICondition();
            condition.setTC_TD(docfile.get(0));
            condition.setP1(docfile.get(1));
            condition.setP2(docfile.get(2));
            condition.setP_Country(docfile.get(3));
            condition.setP_Own(docfile.get(4));
            condition.setP_Min(docfile.get(5));
            condition.setP_Max(docfile.get(6));
            condition.setP_PropertyTypes(docfile.get(7));
            condition.setP_SubType(docfile.get(8));
            condition.setP_Area(docfile.get(9));
            condition.setP_Location(docfile.get(10));
            condition.setP_OwnPropertiesFirst(docfile.get(11));
            condition.setP_RefId(docfile.get(12));
            condition.setP_Preferred(docfile.get(13));
            condition.setP_Lang(docfile.get(14));
            condition.setP_Beds(docfile.get(15));
            condition.setP_Baths(docfile.get(16));
            condition.setP_Images(docfile.get(17));
            condition.setP_New_Devs(docfile.get(18));
            condition.setP_Show_Dev_Prices(docfile.get(19));
            condition.setP_RentalType(docfile.get(20));
            condition.setP_RentalDateFrom(docfile.get(21));
            condition.setP_RentalDateTo(docfile.get(22));
            condition.setP_IncludeRented(docfile.get(23));
            condition.setSearchType(docfile.get(24));
            list.add(xuLy(condition));
            System.out.println(xuLy(condition).toString());
        }
        return list;
    }
    public static ArrayList<SearchAPICondition> getListPropertySearchCondition(String fileName) throws CsvReader.CatastrophicException, IOException, CsvReader.FinalizedException {
        ArrayList<SearchAPICondition> list = new ArrayList<SearchAPICondition>();
        CsvReader docfile = new CsvReader(fileName);
        docfile.readHeaders();
        while (docfile.readRecord()){
            SearchAPICondition condition = new SearchAPICondition();
            condition.setTC_TD(docfile.get(0));
            condition.setP1(docfile.get(1));
            condition.setP2(docfile.get(2));
            condition.setP_Country(docfile.get(3));
            condition.setP_Own(docfile.get(4));
            condition.setP_Min(docfile.get(5));
            condition.setP_Max(docfile.get(6));
            condition.setP_PropertyTypes(docfile.get(7));
            condition.setP_SubType(docfile.get(8));
            condition.setP_Area(docfile.get(9));
            condition.setP_Location(docfile.get(10));
            condition.setP_OwnPropertiesFirst(docfile.get(11));
            condition.setP_RefId(docfile.get(12));
            condition.setP_Preferred(docfile.get(13));
            condition.setP_Lang(docfile.get(14));
            condition.setP_Beds(docfile.get(15));
            condition.setP_Baths(docfile.get(16));
            condition.setP_Images(docfile.get(17));
            condition.setP_New_Devs(docfile.get(18));
            condition.setP_Show_Dev_Prices(docfile.get(19));
            condition.setP_RentalType(docfile.get(20));
            condition.setP_RentalDateFrom(docfile.get(21));
            condition.setP_RentalDateTo(docfile.get(22));
            condition.setP_IncludeRented(docfile.get(23));
            condition.setSearchType(docfile.get(24));

            list.add(condition);
        }

        return list;
    }

    public static String xuLySubType(String st){
        // xử lí chuỗi subtype dạng chữ thành dạng số theo để truy xuất database và gọi API ví dụ Apartment tương đương với 1-1
        // Author Bao Nhan
        // Create on 28-May-2020

        String kq="";
        if (st!=""){
            String[] splitData = st.split(COMMA_DELIMITER);
            StringBuilder bulider = new StringBuilder();
            bulider.append(kq);
            for (int i =0 ;i<splitData.length;i++){
                if (i<splitData.length-1){
                    bulider.append(ParsePropertyType.ParsePropertyType(splitData[i])+",");
                }
                else{
                bulider.append(ParsePropertyType.ParsePropertyType(splitData[i]));
                }
            }
            kq=bulider.toString();
        }
        return kq;
    }
    public static String xuLy(SearchAPICondition condition) {
        // Đọc file CSV sau đó generate ra 1 câu API request
        String st = "feature-602.git.env1.resales-online.com/weblink/xml/V4-4/";
        StringBuilder bulider = new StringBuilder();
        bulider.append(st);
        switch (condition.getSearchType()){
            case "ForSale":
                bulider.append("SearchResaleXML.php?");
                break;
            case "ForRent":
                bulider.append("SearchRentalXML.php?");
                if (condition.getP_RentalType().equals("")){
                    bulider.append("&P_RentalType=L");
                }
                else if (!condition.getP_RentalType().equals("")){
                    bulider.append("&P_RentalType="+condition.getP_RentalType());
                }
                if (!condition.getP_RentalDateFrom().equals("")){
                    bulider.append("&P_RentalDateFrom="+condition.getP_RentalDateFrom());
                }
                if (!condition.getP_RentalDateTo().equals("")){
                    bulider.append("&P_RentalDateTo="+condition.getP_RentalDateTo());
                }
                if (condition.getP_IncludeRented().equals("")){
                    bulider.append("&P_IncludeRented=0");
                }
                else if (!condition.getP_IncludeRented().equals("")){
                bulider.append("&P_IncludeRented="+condition.getP_IncludeRented());
                }
                break;
        }
        if (!condition.getP1().equals("")){
            bulider.append("&P1="+condition.getP1());
        }
        if (!condition.getP2().equals("")){
            bulider.append("&P2="+condition.getP2());
        }
        if (!condition.getP_Country().equals("")){
            bulider.append("&P_Country="+condition.getP_Country());
        }
        if(!condition.getP_Own().equals("")){
            bulider.append("&P_Own"+condition.getP_Own());
        }
        if(condition.getP_Min().equals("")){
            bulider.append("&P_Min=0");
        }
        else if (!condition.getP_Min().equals("")){
            bulider.append("&P_Min="+condition.getP_Min());
        }
        if (!condition.getP_Max().equals("")){
            bulider.append("&P_Max="+condition.getP_Max());
        }
        if (!condition.getP_PropertyTypes().equals("")){
            bulider.append("&P_PropertyTypes="+ParsePropertyType.ParsePropertyType(condition.getP_PropertyTypes()));
        }
        if (!condition.getP_SubType().equals("")){
            bulider.append("&P_SubType="+ParsePropertyType.ParsePropertyType(condition.getP_SubType()));
        }
        if (!condition.getP_Area().equals("")){
            bulider.append("&P_Area="+ValiDateSearchAPIV4Condition.xuLiProvine_Location(condition.getP_Area()));
        }
        if (!condition.getP_Location().equals("")){
            bulider.append("&P_Location="+ValiDateSearchAPIV4Condition.xuLiProvine_Location(condition.getP_Location()));
        }
        if (condition.getP_OwnPropertiesFirst().equals("")){
            bulider.append("&P_OwnPropertiesFirst=0");
        }
        else  if (!condition.getP_OwnPropertiesFirst().equals("")){
            bulider.append("&P_OwnPropertiesFirst=1");
        }
        if(!condition.getP_RefId().equals("")){
            bulider.append("&P_RefId="+condition.getP_RefId());
        }
        if (condition.getP_Preferred().equals("")){
            bulider.append("&P_Preferred=0");
        }
        else  if (!condition.getP_Preferred().equals("")){
            bulider.append("&P_Preferred="+condition.getP_Preferred());
        }
        if (condition.getP_Lang().equals("")){
            bulider.append("&P_Lang=1");
        }
        else  if (!condition.getP_Lang().equals("")){
            bulider.append("&P_Lang="+condition.getP_Lang());
        }
        if (!condition.getP_Beds().equals("")){
            bulider.append("&P_Beds="+condition.getP_Beds());
        }
        if (!condition.getP_Baths().equals("")){
            bulider.append("&P_Baths="+condition.getP_Baths());
        }
        if (condition.getP_Images().equals("")){
            bulider.append("&P_Images=1");
        }
        else  if (!condition.getP_Images().equals("")){
            bulider.append("&P_Images="+condition.getP_Images());
        }
        if (condition.getP_New_Devs().equals("")){
            bulider.append("&P_New_Devs=0");
        }
        else  if (!condition.getP_New_Devs().equals("")){
            bulider.append("&P_New_Devs="+condition.getP_New_Devs());
        }
        if (condition.getP_Show_Dev_Prices().equals("")){
            bulider.append("&P_Show_Dev_Prices=1");
        }
        else  if (!condition.getP_Show_Dev_Prices().equals("")){
            bulider.append("&P_Show_Dev_Prices="+condition.getP_Show_Dev_Prices());
        }

        st = bulider.toString();
        return st;
    }
    public static void print(List<String> l) {
        System.out.println(l.toString());
    }
    public static void main(String[] args) throws CsvReader.CatastrophicException, IOException, CsvReader.FinalizedException {
//        SearchAPICondition con1= new SearchAPICondition("TC_1","1000610","879dab3e2ed47c64e1c76f4d6f364e53b9432a3d",
//                "Spain","","250000","500000","Apartment","","Costa Del Sol",
//                "Marbella,Estepona","","","","","","","","","","","","","","ForSale");
//        System.out.println(xuLy(con1));
//        tempReader();
        readCsvFile("/home/RESALES-ONLINE/baon/Documents/Bao_/CSV_V4.csv");
    }
}

