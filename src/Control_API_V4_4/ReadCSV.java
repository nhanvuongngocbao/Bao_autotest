package Control_API_V4_4;

import Model.PropertySearch1;
import Model.SearchAPICondition;
import com.csvreader.CsvReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
//    public static ArrayList<String> readCsvFile(String fileName) throws IOException {
//        // Đọc file CSV theo mẫu
//        // Đưa ra danh ách các API request
//        BufferedReader br = null;
//        ArrayList<String> list = new ArrayList<>();
//        try {
//            String line;
//            br = new BufferedReader(new FileReader(fileName));
//            while ((line = br.readLine()) != null) {
//                list.add(xuLy(parseCsvLine(line)));
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (br != null)
//                    br.close();
//            } catch (IOException crunchifyException) {
//                crunchifyException.printStackTrace();
//            }
//        }
//        return list;
//    }
//    public static ArrayList<PropertySearch1> getListPropertySearchCondition(String fileName){
//        ArrayList<PropertySearch1> list = new ArrayList<PropertySearch1>();
//        BufferedReader br = null;
//        try {
//            String line;
//            br = new BufferedReader(new FileReader(fileName));
//            while ((line = br.readLine()) != null) {
//                list.add((parseCsvLine(line)));
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (br != null)
//                    br.close();
//            } catch (IOException crunchifyException) {
//                crunchifyException.printStackTrace();
//            }
//        }
//        return list;
//    }

    public static SearchAPICondition parseCsvLine(String csvLine) {
        // Đọc 1 line CSV thành đối tượng
        // Author Bao Nhan
        // Create on 28-May-2020
        SearchAPICondition con1= new SearchAPICondition("TC_1","1000610","879dab3e2ed47c64e1c76f4d6f364e53b9432a3d",
                "Spain","","250000","500000","Apartment","","Costa Del Sol",
                "Marbella,Estepona","","","","","","","","","");
        SearchAPICondition condition = new SearchAPICondition();
        if ( csvLine != null){
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            condition.setTC_TD(splitData[0]);
            condition.setP1(splitData[1]);
            condition.setP2(splitData[2]);
            condition.setP_Country(splitData[3]);
            condition.setP_Own(splitData[4]);
            condition.setP_Min(splitData[5]);
            condition.setP_Max(splitData[6]);
            condition.setP_PropertyTypes(splitData[7]);
            condition.setP_SubType(splitData[8]);
            condition.setP_Area(splitData[9]);
            condition.setP_Location(splitData[10]);
            condition.setP_OwnPropertiesFirst(splitData[11]);
            condition.setP_RefId(splitData[12]);
            condition.setP_Preferred(splitData[13]);
            condition.setP_Lang(splitData[14]);
            condition.setP_Beds(splitData[15]);
            condition.setP_Baths(splitData[16]);
            condition.setP_Images(splitData[17]);
            condition.setP_New_Devs(splitData[18]);
            condition.setP_Show_Dev_Prices(splitData[19]);
            condition.setP_RentalType(splitData[20]);
            condition.setP_RentalDateFrom(splitData[21]);
            condition.setP_RentalDateTo(splitData[22]);
            condition.setP_IncludeRented(splitData[23]);
            condition.setSearchType(splitData[24]);
        }
        return condition;
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
        String st = "feature-602.git.env1.resales-online.com/weblink.resales-online.com/xml/V4-4/";
        StringBuilder bulider = new StringBuilder();
        bulider.append(st);
        switch (condition.getSearchType()){
            case "ForSale":
                bulider.append("SearchResaleXML.php?");
                break;
            case "ForRent":
                bulider.append("SearchRentalXML.php?");
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
            bulider.append("&P_Area="+condition.getP_Area());
        }
        if (!condition.getP_Location().equals("")){
            bulider.append("&P_Location="+condition.getP_Location());
        }
        if (condition.getP_OwnPropertiesFirst().equals("")){
            bulider.append("&P_P_OwnPropertiesFirst()=0");
        }
        else  if (!condition.getP_OwnPropertiesFirst().equals("")){
            bulider.append("&P_P_OwnPropertiesFirst()=1");
        }
        st = bulider.toString();
        return st;
    }
    public static void print(List<String> l) {
        System.out.println(l.toString());
    }
    public static void read1(){
        String fileName = "/home/RESALES-ONLINE/baon/Documents/Bao_/CSV_V4.csv";
        CsvReader reader = new CsvReader(fileName);

    }

    public static void main(String[] args) {
        System.out.println(xuLySubType("Others,Apartment"));
    }
}

