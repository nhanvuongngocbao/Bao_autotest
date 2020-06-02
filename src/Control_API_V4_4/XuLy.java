package Control_API_V4_4;

import Model.Property;
import Model.PropertySearch1;
import Model.SearchAPICondition;
import com.csvreader.CsvReader;
import org.json.JSONException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class XuLy {
    public static void XuLy() throws IOException, JSONException, InterruptedException, SQLException, CsvReader.FinalizedException, CsvReader.CatastrophicException {
        String fileName = "/home/RESALES-ONLINE/baon/Documents/Bao_/CSV_V4.csv";
        ArrayList<String> input = ReadCSV.readCsvFile(fileName);
        boolean kq = true;
        ArrayList<SearchAPICondition> inputSearchCondition = ReadCSV.getListPropertySearchCondition(fileName);

//        for (int i = 0; i < inputSearchCondition.size(); i++) {
//            System.out.println(inputSearchCondition.get(i).toString());
//            ArrayList<String> listProperty = GetPropertyByCallAPI.getListResponseProperty(input.get(i));
//            //lấy ra toàn bộ property thỏa mản
//            for (int j = 1; j < listProperty.size(); j++) {
//                Property property = GetPropertyByCallJDBC.getPropertyByCallJDBC(listProperty.get(j));
//                if (!inputSearchCondition.get(i).getCountry().equals("no")) {
//                    if (!inputSearchCondition.get(i).getCountry().equals(property.getCountry())) {
//                        System.out.println(property.getRsID()+ " Wrong country");
//                        kq = false;
//                        break;
//                    }
//                }
//                if (inputSearchCondition.get(i).getProvince_Area().equals("no") ){
//                    if ((!inputSearchCondition.get(i).getProvince_Area().equals(property.getProvince())) || ((inputSearchCondition.get(i).getProvince_Area().equals(property.getArea())))) {
//                        System.out.println(property.getRsID()+  " Wrong ProVince_Area");
//                        kq = false;
//                        break;
//                    }
//                }
//                if (!inputSearchCondition.get(i).getLocation().equals("no")) {
//                    if (!inputSearchCondition.get(i).getLocation().equals(property.getLocation())) {
//                        System.out.println(property.getRsID()+" Wrong location");
//                        kq = false;
//                        break;
//                    }
//                }
//                if (!inputSearchCondition.get(i).getType_Subtype().equals("no")) {
//                    if ((!inputSearchCondition.get(i).getType_Subtype().equals(property.getType())) || ((inputSearchCondition.get(i).getType_Subtype().equals(property.getSubtype())))) {
//                        System.out.println(property.getRsID()+" Wrong Type_s");
//                        kq = false;
//                        break;
//                    }
//                }
//                if (inputSearchCondition.get(i).getPriceFrom() == 0) {
//                    if (property.getPrice() > inputSearchCondition.get(i).getPriceTo()) {
//                        System.out.println(property.getRsID()+" Price is higher thar Price To");
//                        kq = false;
//                        break;
//                    }
//                }
//                if (inputSearchCondition.get(i).getPriceTo() == 0) {
//                    if (property.getPrice() < inputSearchCondition.get(i).getPriceFrom()) {
//                        System.out.println(property.getRsID()+" Price is Low thar Price from");
//                        kq = false;
//                        break;
//                    }
//                }
//                if ((property.getPrice() < inputSearchCondition.get(i).getPriceFrom() && (property.getPrice() > inputSearchCondition.get(i).getPriceTo())))
//                {
//                    System.out.println(property.getRsID()+ " Wrong price conditcons");
//                    kq = false;
//                    break;
//                }
//            }
//            if (kq== false){
//                System.out.println("API "+ inputSearchCondition.get(i).getApiId() + " is fail" );
//                kq=true;
//            }
//            else {
//                System.out.println("API "+ inputSearchCondition.get(i).getApiId() + " is true" );
//            }
//        }
    }
//
    public static void main(String[] args) throws IOException, InterruptedException, SQLException, JSONException, CsvReader.CatastrophicException, CsvReader.FinalizedException {
        XuLy();
    }
}
