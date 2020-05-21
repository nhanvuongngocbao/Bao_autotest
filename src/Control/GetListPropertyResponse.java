package Control;

import Model.Property;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.*;
import java.util.ArrayList;

public class GetListPropertyResponse {
    public static ArrayList<String> getListResponseProperty(String st) throws IOException, InterruptedException, JSONException {
        // Lấy danh sách list RSid thỏa điều kiện mà APi request
        // Author Bao Nhan
        // Create on 18-May-2020
        ArrayList<String> result = new ArrayList<String>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://" + st))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String js = response.body();
        JSONObject object = new JSONObject(js);
        // luu API ID tại vị trí đầu tiên trong array để cho phương thưc callPropertyDetailAPi
        result.add(object.getJSONObject("QueryInfo").getString("ApiId"));
        if ((object.getJSONObject("QueryInfo").getInt("PropertyCount") <= 1) || ((object.getJSONObject("QueryInfo").getInt("PropertyCount") - object.getJSONObject("QueryInfo").getInt("CurrentPage") * object.getJSONObject("QueryInfo").getInt("CurrentPage") == 1))) {
            String str = object.getJSONObject("Model.Property").getString("Reference");
            result.add(str);
        } else {
            for (int i = 0; i < object.getJSONArray("Property").length(); i++) {
                String str1 = object.getJSONArray("Property").getJSONObject(i).getString("Reference");
                result.add(str1);
            }
        }
        return result;
    }

    public static void callPropertyDetailAPi(String apiId,String rsID) throws InterruptedException, JSONException, IOException, SQLException {
        String st = "feature-602.git.env1.resales-online.com/WebApi/V5-3/PropertyDetails.php?p1=1000610&p2=879dab3e2ed47c64e1c76f4d6f364e53b9432a3d";
        StringBuilder bulider = new StringBuilder();
        bulider.append(st);
        bulider.append("&P_RefId="+rsID);
        bulider.append("&P_ApiId="+apiId);
        st = bulider.toString();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://" + st))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject object = new JSONObject(response.body());

        double price  = object.getJSONObject("Property").getDouble("OriginalPrice");
        String country = object.getJSONObject("Property").getString("Country");
        String location = object.getJSONObject("Property").getString("Province");
        String province = object.getJSONObject("Property").getString("Location");
        String area = object.getJSONObject("Property").getString("Area");
        String type = object.getJSONObject("Property").getString("ROLType");
        String subType = object.getJSONObject("Property").getString("Type");
//        subtype còn đang phân vân        System.out.println(price);
        String url ="jdbc:mysql://feature-602.git.env1.resales-online.com:3306/resalesonline_feature_602";
        String user="feature_602";
        String password= "AaYK7Hqu9ghHNLNrWUQr";
        Connection con = DriverManager.getConnection(url,user,password);
        String sql ="select RsID,RsSalePrice,RsCountry,RsProvince,RsArea,RsLocation, RsType, RsSubType from tblresale where RsID="+rsID.substring(1);
        PreparedStatement pr = con.prepareStatement(sql);
        ResultSet rs= pr.executeQuery();
        Property property = new Property();
        while (rs.next()){
            String id = rs.getString("RsId");
            Double priceDB= rs.getDouble("RsSalePrice");
            String countryDB=rs.getString("RsCountry");
            String provinceDB= rs.getString("RsProvince");
            String areaDB = rs.getString("RsArea");
            String locationDB = rs.getString("RsLocation");
            String typeDB = rs.getString("RsType");
            String subTypeDB = rs.getString("RsSubType");

            property.setRsID(id);
            property.setPrice(priceDB);
            property.setCountry(countryDB);
            property.setLocation(locationDB);
            property.setArea(areaDB);
            property.setProvince(provinceDB);
            property.setType(typeDB);
            property.setSubtype(subTypeDB);
        }
        if ((property.getPrice()==price) &&(property.getCountry().equals(country)) ){
// (property.getPrice()==price)&&(property.getCountry().equals(country))&&(property.getLocation().equals(location)&&(property.getArea().equals(area))&&(property.getProvince().equals(province))&&(property.getType().equals(type))&&(property.getSubtype().equals(subType)))
            System.out.println("match value from API and  database");

        }
        else {
            System.out.println("not match");
        }
    }
}
