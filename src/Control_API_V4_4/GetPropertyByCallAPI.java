package Control_API_V4_4;

import Model.Property;
import Model.SearchAPICondition;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class GetPropertyByCallAPI {
    public static Property getPropertyByAPI(String queryId, String rsID, SearchAPICondition condition) throws JSONException, IOException, InterruptedException {
        Property pro= new Property();
        String st = "feature-602.git.env1.resales-online.com/weblink/xml/V4-4/PropertyDetailsXML.asp?";
        StringBuilder bulider = new StringBuilder();
        bulider.append(st);
        bulider.append("&P_RefId="+rsID);
        bulider.append("&P_ApiId="+queryId);
        switch (condition.getSearchType()){
            case "ForSale":
                  bulider.append("&SearchType=1");
                  break;
            case "ForRent":
                    if(condition.getP_RentalType().equals("S")){
                        bulider.append("SearchType=2");
                        break;
                    }
                    else {
                        bulider.append("SearchType=3");
                        break;
                    }
        }
        bulider.append("&P1="+condition.getP1());
        bulider.append("&P2="+condition.getP2());
        bulider.append("&P_New_Devs="+condition.getP_New_Devs());
        bulider.append("&P_Show_Dev_Prices="+condition.getP_Show_Dev_Prices());
        bulider.append("&Lang="+condition.getP_Lang());
        st = bulider.toString();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://" + st))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String xml = response.body();
        JSONObject json = XML.toJSONObject(xml);
        JSONObject object = new JSONObject(true);
        object = XML.toJSONObject(xml).getJSONObject("root");
        double price ;
        switch (condition.getSearchType()){
            case "ForSale":
                 price  = object.getJSONObject("Property").getDouble("OriginalPrice");
                 pro.setPrice(price);
                break;
            case "ForRent":
                if (condition.getP_RentalType().equals("")){
                    price  = object.getJSONObject("Property").getDouble("RentalPrice1");
                    pro.setPrice(price);
                    pro.setPriceRentalLong(price);
                    break;
                }
                else{
                    price  = object.getJSONObject("Property").getDouble("RentalPrice1");
                    pro.setPrice(price);
                    double low, high;
                    low = object.getJSONObject("Property").getDouble("RentalPrice1");
                    high = object.getJSONObject("Property").getDouble("RentalPrice2");
                    pro.setShortTermRentLow(low);
                    pro.setShortTermRentHigh(high);
                }
        }
        String country = object.getJSONObject("Property").getString("Country");
        String location = object.getJSONObject("Property").getString("Province");
        String province = object.getJSONObject("Property").getString("Location");
        String area = object.getJSONObject("Property").getString("Area");
        String type = object.getJSONObject("Property").getString("ROLType");
        String subType = object.getJSONObject("Property").getString("ROLSubType");
        String beds =object.getJSONObject("Property").getString("Bedrooms");
        String baths = object.getJSONObject("Property").getString("Bathrooms");
        pro.setRsID(rsID);
        pro.setCountry(country);
        pro.setLocation(location);
        pro.setArea(area);
        pro.setProvince(province);
        pro.setType(type);
        pro.setSubtype(subType);
        pro.setBeds(beds);
        pro.setBaths(baths);
        return pro;
    }
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

        String xml = response.body();
        JSONObject json = XML.toJSONObject(js);
        JSONObject object = new JSONObject(true);
        object = XML.toJSONObject(xml).getJSONObject("root");

        // luu API ID tại vị trí đầu tiên trong array để cho phương thưc callPropertyDetailAPi
        result.add(object.getJSONObject("QueryInfo").getString("QueryId"));
    if(object.getJSONObject("QueryInfo").getInt("PropertyCount")>0) {
            if ((object.getJSONObject("QueryInfo").getInt("PropertyCount") <= 1) || ((object.getJSONObject("QueryInfo").getInt("PropertyCount") - object.getJSONObject("QueryInfo").getInt("CurrentPage") * object.getJSONObject("QueryInfo").getInt("CurrentPage") == 1))) {
                String str = object.getJSONObject("Property").getString("Reference");
                result.add(str);
            } else {
                for (int i = 0; i < object.getJSONArray("Property").length(); i++) {
                    String str1 = object.getJSONArray("Property").getJSONObject(i).getString("Reference");
                    result.add(str1);
                }
            }
        }
        return result;
    }
}
