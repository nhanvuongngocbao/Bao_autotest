import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.*;
import java.util.ArrayList;


public class CompareApiAndJDBC  {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // Kết nối database
        // Author Bao Nhan
        // Date created 07-May-2020
        String url ="jdbc:mysql://feature-602.git.env1.resales-online.com:3306/resalesonline_feature_602";
        String user="feature_602";
        String password= "AaYK7Hqu9ghHNLNrWUQr";
        Connection con = DriverManager.getConnection(url,user,password);
        return con;
    }
    public static Property getProperty(String RsID)  throws ClassNotFoundException, SQLException {
        // Gọi JDBC -> lấy thông tin 1 property
        // Author Bao Nhan
        // Date created 07-May-2020
        Connection con = getConnection();
//        String sql="select * from tblresale where RsId =3441919";
        String sql="select * from tblresale where RsId = "+RsID ;
        PreparedStatement pr = con.prepareStatement(sql);
        ResultSet rs= pr.executeQuery();
        Property property = new Property();
        while (rs.next()){
            String id = rs.getString("RsId");
            Double price= rs.getDouble("RsSalePrice");
            property.setRsID(id);
            property.setPrice(price);
        }
        return property;
    }
    public static String parseJson() throws  InterruptedException, IOException, SQLException, ClassNotFoundException{
        // Call HTTP request trả về json reponse
        // Author Bao Nhan
        // Date created 07-May-2020
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://feature-602.git.env1.resales-online.com/WebApi/V5-3/PropertyDetails.php?p1=1000610&p2=879dab3e2ed47c64e1c76f4d6f364e53b9432a3d&p_apiid=3598&p_refid=3441919"))
                .build();
        //call API link copy từ Jmeter
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //System.out.println(response.body());
        String js= response.body();
        return js;
    }
    public static String parseJson2(String string) throws  InterruptedException, IOException, SQLException, ClassNotFoundException{
        // Call HTTP request trả về json reponse
        // Author Bao Nhan
        // Date created 08-May-2020
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(string))
                .build();
        //call API link copy từ Jmeter
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //System.out.println(response.body());
        String js= response.body();
        return js;
    }
    public static boolean Compared1() throws InterruptedException, IOException, SQLException, ClassNotFoundException, JSONException {
        // So Sánh giá trị 1 property trả về từ API và Call JDBC
        // Author Bao Nhan
        // Date created 07-May-2020
        JSONObject object = new JSONObject(parseJson());
        double p = object.getJSONObject("Property").getDouble("OriginalPrice");
//        Connection conn = ConnectDB.getConnection();
        Property property = getProperty("3441919");
        if (p == property.getPrice()){
            return true;
        }
        else{
            return false;
        }
    }

    public static ArrayList<Property> getAllProperty() throws SQLException, ClassNotFoundException {
        String sql= "SELECT SQL_CALC_FOUND_ROWS RsId, ContactSecureId2, RsDevId, RsAgency, RsAgencyHeadOffice, RsStatus, RsForSale, RsForRent, RsForRentLong, RsForRentShort, RsSalePrice, RsSalePriceTo, RsListPrice, RsShortTermRentalLow, RsShortTermRentalHigh, RsLongTermRental, RsAgencyRef, RsAgencyRentalRef, RsAgencyRentalShortRef, RsPicIdTo, RsSecureId, RsCurrency, RsDimension, RsCountry, RsProvince, RsArea, RsLocation, RsType, RsSubType, RsSubType2, RsSubType3, RsBuiltSqm, RsTerraceSqm, RsGardenPlotSqm, RsBuiltSqmTo, RsTerraceSqmTo, RsGardenPlotSqmTo, RsBedsTo, RsBathsTo, RsBeds, RsBaths, RsEnergyRatingStatus, RsCO2RatingLetter, RsEnergyRatingLetter, RsVirtualTour, RsListDate, RsLastUpdated, tblPropertyTypes.PtLngLabelId, CASE WHEN (TRIM(RsDescriptionText) <> '') THEN RsDescriptionText ELSE RsDescriptionText END AS 'DescriptionText', CASE WHEN ( COALESCE(tblLanguage.Lng1,'') <> '' ) THEN tblLanguage.Lng1 ELSE COALESCE(tblLanguage.Lng1,'') END AS 'LangText', 0 AS 'FeatureRating', CASE WHEN (  tblResale.RsAgency = 'DEMO AGENCY' ) THEN 1 ELSE 0 END AS 'OwnProperty' FROM tblResale LEFT JOIN tblContact ON ( tblContact.ContactName = tblResale.RsAgency AND tblContact.ContactType = 1 ) LEFT JOIN tblPropertyTypes ON ( tblPropertyTypes.PtCountry = tblResale.RsCountry AND tblPropertyTypes.PtType = tblResale.RsType AND tblPropertyTypes.PtSubType = tblResale.RsSubType ) LEFT JOIN tblLanguage ON ( tblLanguage.LngPageId = 28                           AND tblLanguage.LngLabelId = tblPropertyTypes.PtLngLabelId ) LEFT JOIN tblAgentPropertyRules ON ( tblAgentPropertyRules.AprAgency = 'DEMO AGENCY' AND tblAgentPropertyRules.AprRsId = tblResale.RsId ) LEFT JOIN tblAgentPreferences Ap1 ON ( Ap1.AgpAgency = 'DEMO AGENCY' AND Ap1.AgpAssociatedAgency = tblResale.RsAgency ) LEFT JOIN tblAgentPreferences Ap2 ON ( Ap2.AgpAgency = tblResale.RsAgency AND Ap2.AgpAssociatedAgency = 'DEMO AGENCY' ) WHERE tblResale.RsAgencyLive = 1 AND tblResale.RsResalesOnline = 1 AND tblResale.RsStatus IN ('Available','Under Offer','Sale Agreed') AND ( ( tblResale.RsReadyForLive = 1 AND  tblResale.RsAgency <> 'DEMO AGENCY' ) OR (  tblResale.RsAgency = 'DEMO AGENCY' ) ) AND tblResale.RsForSale = 1 AND tblResale.RsDevId = 0 AND tblContact.StatusPriv3 = 3 AND ( tblResale.RsShareWithAgents = 1 OR  tblResale.RsAgency = 'DEMO AGENCY' ) AND ( ( tblResale.RsShowOnOurWeb = 1 AND  tblResale.RsAgency = 'DEMO AGENCY' )    OR ( tblResale.RsShowOnSharedAgentsWeb = 1 AND  tblResale.RsAgency <> 'DEMO AGENCY' ) ) AND ( (  tblResale.RsAgency = 'DEMO AGENCY' )  OR       ( (  tblResale.RsAgency <> 'DEMO AGENCY' )           AND ( tblResale.RsOrigId = 0 )           AND ( ( SELECT COUNT(*) FROM tblReSale t2                   WHERE  t2.RsAgency = 'DEMO AGENCY'                  AND   t2.RsOrigId = tblResale.RsId ) = 0  ) ) ) AND tblResale.RsCountry = 'Spain' AND ( ( tblResale.RsProvince = 'Málaga' AND tblResale.RsLocation IN ('Alameda', 'Alcaucín', 'Carranque') ) OR ( tblResale.RsProvince = 'Málaga' AND tblResale.RsLocation IN ('Mijas', 'Mijas Costa') ) ) AND ( COALESCE(tblAgentPropertyRules.AprRuleType,1) & 4 ) = 0 AND ( COALESCE(tblAgentPropertyRules.AprRuleType,1) & 16 ) = 0 AND ( COALESCE(Ap1.AgpPreferenceType,1) & 4 ) = 0 AND ( COALESCE(Ap1.AgpPreferenceType,1) & 16 ) = 0 AND ( COALESCE(Ap2.AgpPreferenceType,1) & 4 ) = 0 AND ( COALESCE(Ap2.AgpPreferenceType,1) & 16 ) = 0 AND ( tblResale.RsSalePrice >= 1 AND tblResale.RsSalePrice <= 999999999)  AND (  ( tblResale.RsType = 'House' ) OR  ( tblResale.RsType = 'Plot' ) ) AND ( (  tblResale.RsAgency = 'DEMO AGENCY' ) OR (  NOT EXISTS ( SELECT 1 FROM tblResaleFeatures WHERE tblResale.RsId = tblResaleFeatures.RsfId AND tblReSaleFeatures.RsfCategoryType = 1 AND tblReSaleFeatures.RsfCategoryId = 'Category' AND tblReSaleFeatures.RsfFeatureId = 15 ) ) ) ORDER BY tblResale.RsSalePrice ASC, tblResale.RsId LIMIT 0, 10;";
        Connection con= getConnection();
        PreparedStatement pr = con.prepareStatement(sql);
        ResultSet rs= pr.executeQuery();
        ArrayList<Property> listProperty = new ArrayList<Property>();
        while (rs.next()){
            Property property = new Property();
            String id = rs.getString("RsId");
            Double price= rs.getDouble("RsSalePrice");
            property.setRsID(id);
            property.setPrice(price);
            listProperty.add(property);
        }
        return listProperty;
    }
    public static boolean Compared2() throws InterruptedException, SQLException, ClassNotFoundException, IOException, JSONException {
        String request ="http://feature-602.git.env1.resales-online.com/WebApi/V5-3/SearchProperties.php?p1=1000610&p2=879dab3e2ed47c64e1c76f4d6f364e53b9432a3d&p_apiid=3598";
        JSONObject object = new JSONObject(parseJson2(request));
        ArrayList<Property> listProperty = new ArrayList<Property>();
        for (int i=0;i<object.getJSONObject("QueryInfo").getInt("PropertiesPerPage");i++){
            Property property = new Property(object.getJSONArray("Property").getJSONObject(i).getString("Reference"),object.getJSONArray("Property").getJSONObject(i).getDouble("OriginalPrice"));
            listProperty.add(property);
        }
        System.out.println(listProperty.toString());
        return true;

    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, InterruptedException, JSONException {
        System.out.println(Compared1());
//        ArrayList<Property> listProperty = getAllProperty();
//
//        for (int i=0;i<listProperty.size();i++){
//            System.out.println(listProperty.get(i).toString());
//        }
//        Compared2();
    }
}
