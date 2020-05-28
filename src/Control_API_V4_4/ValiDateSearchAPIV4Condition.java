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
}
