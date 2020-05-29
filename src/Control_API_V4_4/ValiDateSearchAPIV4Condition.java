package Control_API_V4_4;

import Model.SearchAPICondition;


public class ValiDateSearchAPIV4Condition {
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

    public static void main(String[] args) {
        String st= "Costa del sol";
        System.out.println(xuLiProvine_Location(st));
    }
}
