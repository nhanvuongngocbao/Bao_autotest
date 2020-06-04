package Control_API_V4_4;

import Model.Property;
import Model.SearchAPICondition;


public class ValiDateSearchAPIV4Condition {
    public static boolean checkCondition(SearchAPICondition condition){
        boolean kq=true;
            if ((checkP1(condition) && checkP2(condition) && checkCountry(condition))) {
                kq=true;
            }
            else kq=false;
        return kq;
    }
    public static boolean checkP1(SearchAPICondition condition){
        if (condition.getP1().equals("")){
            return false;
        }
        else return true;
    }
    public static boolean checkP2(SearchAPICondition condition){
        if (condition.getP2().equals("")){
            return false;
        }
        else return true;
    }
    public static boolean checkCountry(SearchAPICondition condition){
        if (condition.getP_Country().equals("")){
            return false;
        }
        else return true;
    }
    public static String xuLiProvine_Location(String st){
        // Xu ly provine_location khi đọc CSV
        // Nguyên nhân do khoảng trắng khi đọc CSV -> generate Link API -> call lỗi do có khoảng trống " "
        //=> cách khách phục thay khoảng trống " "  bằng "+"
        // create om 29/05/2020
        // author Bao Nhan
      String kq=st.replace(" ","+");
              return kq;
    }
    public static boolean checkCountryRight(SearchAPICondition con, Property prop){
        boolean kq=true;
        if (!con.getP_Country().equals("")){
            if (!con.getP_Country().equals(prop.getCountry())){
                 kq=false;
            }
        }
        return kq;
    }
    public static boolean checkPrice(SearchAPICondition con, Property prop){
        boolean kq=true;
        switch (con.getSearchType()){
            case "ForSale":
                if (con.getP_Min().equals("")){
                    if(prop.getPrice()> Double.parseDouble(con.getP_Max())){
                        kq=false;
                        break;
                    }
                }
                else if (con.getP_Max().equals("")){
                    if (prop.getPrice() < Double.parseDouble(con.getP_Min())){
                        kq=false;
                        break;
                    }
                }
                else {
                    if ((prop.getPrice() < Double.parseDouble(con.getP_Min())) || (prop.getPrice()> Double.parseDouble(con.getP_Max())) ){
                        kq=false;
                        break;
                    }
                }
            case "ForRent":
                if (con.getP_RentalType().equals("")) {
                    if (con.getP_Min().equals("")) {
                        if (prop.getPriceRentalLong() > Double.parseDouble(con.getP_Max())) {
                            kq = false;
                            break;
                        }
                    } else if (con.getP_Max().equals("")) {
                        if (prop.getPriceRentalLong() < Double.parseDouble(con.getP_Min())) {
                            kq = false;
                            break;
                        }
                    } else {
                        if ((prop.getPriceRentalLong() < Double.parseDouble(con.getP_Min())) || (prop.getPriceRentalLong() > Double.parseDouble(con.getP_Max()))) {
                            kq = false;
                            break;
                        }
                    }
                }
                else {
                    if (con.getP_Min().equals("")) {
                        if (prop.getShortTermRentHigh()> Double.parseDouble(con.getP_Max())) {
                            kq = false;
                            break;
                        }
                    } else if (con.getP_Max().equals("")) {
                        if (prop.getShortTermRentLow() <  Double.parseDouble(con.getP_Min())) {
                            kq = false;
                            break;
                        }
                    } else {
                        double low = prop.getShortTermRentLow();
                        double high = prop.getShortTermRentHigh();
                        double from = Double.parseDouble(con.getP_Min());
                        double to = Double.parseDouble(con.getP_Max());
                        if ( (((low >= from) && (low<=to) )) || ((high>=from) && (high <= to))) {
                            kq = true;
                            break;
                        }
                        else kq=false;
                    }
                }
        }
        return kq;
    }
    public static boolean checkLocation(SearchAPICondition con, Property prop){
        boolean kq=true;
        if (!con.getP_Location().equals("")){
            if (!con.getP_Location().contains(prop.getLocation())){
                kq=false;
            }
        }
        return kq;
    }
    public static boolean checkType(SearchAPICondition con, Property prop){
        boolean kq=true;
        if (!con.getP_PropertyTypes().equals("")) {
            if (!con.getP_PropertyTypes().equals(prop.getType())) {
                kq = false;
            }
        }
        return kq;
    }
    public static boolean checkSubType(SearchAPICondition con, Property prop){
        boolean kq=true;
        if (!con.getP_PropertyTypes().equals("")){
            if(!con.getP_PropertyTypes().contains(prop.getSubtype())){
                kq=false;
             }
        }
        return kq;
    }
    public static boolean checkBeds(SearchAPICondition con, Property prop){
        boolean kq=true;
        if(!con.getP_Beds().equals("")) {
            if (prop.getBeds().equals(con.getP_Beds())) {
                kq = false;
            }
        }
        return kq;
    }
    public static boolean checkBaths(SearchAPICondition con, Property prop){
        boolean kq=true;
        if(!con.getP_Baths().equals("")){
            if (prop.getBaths().equals((con.getP_Baths()))){
                kq=false;
            }
        }
       return kq;
    }
    public static boolean checkP_Dev(SearchAPICondition con, Property prop){
        boolean kq=true;
        if(con.getSearchType().equals("ForSale")){
            if (con.getP_New_Devs().equals("")|| con.getP_New_Devs().equals("0")){
                if (!prop.getDevID().equals("0")){
                    kq=false;
                }
            }
            else if (con.getP_New_Devs().equals("2")){
                if (prop.getDevID().equals("0")){
                    kq=false;
                }
            }

        }
        return kq;
    }


    public static void main(String[] args) {
        String st= "Costa del sol";
        System.out.println(xuLiProvine_Location(st));
    }
}
