package Control_API_V4_4;

import Model.Property;
import Model.PropertySearch1;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoadCSV {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    public static void writeCsvFile(String fileName) {
        // Ghi CVS theo điều kiên khớp với API V5

        PropertySearch1 p2 = new PropertySearch1("3598", "Spain", "Málaga", "no", 0, 256920, "Apartment");
        List<PropertySearch1> listSearch = new ArrayList<PropertySearch1>();
//        listSearch.add(propertySearch);
        listSearch.add(p2);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
//            for (Model.PropertySearch1 propertySearch1 : listSearch) {
            for (int i = 0; i < listSearch.size(); i++) {
                fileWriter.append(listSearch.get(i).getApiId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(listSearch.get(i).getCountry());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(listSearch.get(i).getProvince_Area());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(listSearch.get(i).getLocation());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listSearch.get(i).getPriceFrom()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listSearch.get(i).getPriceTo()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(listSearch.get(i).getType_Subtype());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully !!!");

        } catch (IOException e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<String> readCsvFile(String fileName) throws IOException {
        // Đọc file CSV theo mẫu
        // Đưa ra danh ách các API request
        BufferedReader br = null;
        ArrayList<String> list = new ArrayList<>();
        try {
            String line;
            br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                list.add(xuLy(parseCsvLine(line)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
        return list;
    }

    public static PropertySearch1 parseCsvLine(String csvLine) {
        // Đọc 1 line CSV thành đối tượng
        // Author Bao Nhan
        // Create on 15-May-2020
        PropertySearch1 p = new PropertySearch1("", "", "", "", 0, 0, "");
        if (csvLine != null) {
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            p.setApiId(splitData[0]);
            p.setCountry(splitData[1]);
            p.setProvince_Area(splitData[2]);
            p.setLocation(splitData[3]);
            p.setPriceFrom(Double.parseDouble(splitData[4]));
            p.setPriceTo(Double.parseDouble(splitData[5]));
            p.setType_Subtype(splitData[6]);
        }
        return p;
    }

    public static String xuLy(PropertySearch1 pro) {
        // Đọc file CSV sau đó generate ra 1 câu API request
        String st = "feature-602.git.env1.resales-online.com/WebApi/V5-3/SearchProperties.php?p1=1000610&p2=879dab3e2ed47c64e1c76f4d6f364e53b9432a3d";
        StringBuilder bulider = new StringBuilder();
        bulider.append(st);
        if (!pro.getApiId().equals("no")) {
            bulider.append("&p_apiid=" + pro.getApiId());
        }
        if (!pro.getCountry().equals("no")) {
            bulider.append("&p_Country=" + pro.getCountry());
        }
        if (!pro.getProvince_Area().equals("no")) {
            bulider.append("&p_area=" + pro.getProvince_Area());
        }
        if (!pro.getLocation().equals("no")) {
            bulider.append("&p_location=" + pro.getLocation());
        }
        if (pro.getPriceFrom() != 0) {
            bulider.append("&p_Min=" + pro.getPriceFrom());
        }
        if (pro.getPriceTo() != 0) {
            bulider.append("&p_Max=" + pro.getPriceTo());
        }

        switch (pro.getType_Subtype()) {
            case "Apartment":
                bulider.append("&p_PropertyTypes=1-1");
                break;
            case "House":
                bulider.append("&p_PropertyTypes=2-1");
                break;
            case "Plot":
                bulider.append("&p_PropertyTypes=3-1");
                break;
            case "Commercial":
                bulider.append("&p_PropertyTypes=4-1");
                break;
            case "Ground Floor Apartment":
                bulider.append("&p_PropertyTypes=1-2");
                break;
            case "Middle Floor Apartment":
                bulider.append("&p_PropertyTypes=1-4");
                break;
            case "Top Floor Apartment":
                bulider.append("&p_PropertyTypes=1-5");
                break;
            case "Penthouse":
                bulider.append("&p_PropertyTypes=1-6");
                break;
            case "Ground Floor Studio":
                bulider.append("&p_PropertyTypes=1-7");
                break;
            case "Middle Floor Studio":
                bulider.append("&p_PropertyTypes=1-8");
                break;
            case "Top Floor Studio":
                bulider.append("&p_PropertyTypes=1-9");
                break;
            case "Detached Villa":
                bulider.append("&p_PropertyTypes=2-2");
                break;
            case "Semi-Detached House":
                bulider.append("&p_PropertyTypes=2-4");
                break;
            case "Townhouse":
                bulider.append("&p_PropertyTypes=2-5");
                break;
            case "Finca - Cortijo":
                bulider.append("&p_PropertyTypes=2-6");
                break;
            case "Bungalow":
                bulider.append("&p_PropertyTypes=2-9");
                break;
            case "Quad":
                bulider.append("&p_PropertyTypes=2-10");
                break;
            case "Castle":
                bulider.append("&p_PropertyTypes=2-12");
                break;
            case "City Palace":
                bulider.append("&p_PropertyTypes=2-13");
                break;
            case "Wooden Cabin":
                bulider.append("&p_PropertyTypes=2-14");
                break;
            case "Wooden House":
                bulider.append("&p_PropertyTypes=2-15");
                break;
            case "Mobile Home":
                bulider.append("&p_PropertyTypes=2-16");
                break;
            case "Cave Home":
                bulider.append("&p_PropertyTypes=2-17");
                break;
            case "Residential Plot":
                bulider.append("&p_PropertyTypes=3-2");
                break;
            case "Commercial Plot":
                bulider.append("&p_PropertyTypes=3-3");
                break;
            case "Land":
                bulider.append("&p_PropertyTypes=3-4");
                break;
            case "Land with Ruin":
                bulider.append("&p_PropertyTypes=3-5");
                break;
            case "Bar":
                bulider.append("&p_PropertyTypes=4-2");
                break;
            case "Restaurant":
                bulider.append("&p_PropertyTypes=4-3");
                break;
            case "Café":
                bulider.append("&p_PropertyTypes=4-4");
                break;
            case "Hotel":
                bulider.append("&p_PropertyTypes=4-5");
                break;
            case "Hostel":
                bulider.append("&p_PropertyTypes=4-6");
                break;
            case "Bed and Breakfast":
                bulider.append("&p_PropertyTypes=4-8");
                break;
            case "Guest House":
                bulider.append("&p_PropertyTypes=4-7");
                break;
            case "Shop":
                bulider.append("&p_PropertyTypes=4-9");
                break;
            case "Office":
                bulider.append("&p_PropertyTypes=4-10");
                break;
            case "Storage Room":
                bulider.append("&p_PropertyTypes=4-11");
                break;
            case "Parking Space":
                bulider.append("&p_PropertyTypes=4-12");
                break;
            case "Farm":
                bulider.append("&p_PropertyTypes=4-13");
                break;
            case "Night Club":
                bulider.append("&p_PropertyTypes=4-15");
                break;
            case "Warehouse":
                bulider.append("&p_PropertyTypes=4-16");
                break;
            case "Garage":
                bulider.append("&p_PropertyTypes=4-17");
                break;
            case "Business":
                bulider.append("&p_PropertyTypes=4-18");
                break;
            case "Mooring":
                bulider.append("&p_PropertyTypes=4-19");
                break;
            case "Stables":
                bulider.append("&p_PropertyTypes=4-20");
                break;
            case "Kiosk":
                bulider.append("&p_PropertyTypes=4-21");
                break;
            case "Chiringuito":
                bulider.append("&p_PropertyTypes=4-22");
                break;
            case "Beach Bar":
                bulider.append("&p_PropertyTypes=4-23");
                break;
            case "Mechanics":
                bulider.append("&p_PropertyTypes=4-24");
                break;
            case "Hairdressers":
                bulider.append("&p_PropertyTypes=4-25");
                break;
            case "Photography Studio":
                bulider.append("&p_PropertyTypes=4-26");
                break;
            case "Laundry":
                bulider.append("&p_PropertyTypes=4-27");
                break;
            case "Aparthotel":
                bulider.append("&p_PropertyTypes=4-28");
                break;
            case "Apartment Complex":
                bulider.append("&p_PropertyTypes=4-29");
                break;
            case "Residential Home":
                bulider.append("&p_PropertyTypes=4-30");
                break;
            case "Vineyard":
                bulider.append("&p_PropertyTypes=4-32");
                break;
            case "Olive Grove":
                bulider.append("&p_PropertyTypes=4-33");
                break;
            case "Car Park":
                bulider.append("&p_PropertyTypes=4-34");
                break;
            case "Commercial Premises":
                bulider.append("&p_PropertyTypes=4-35");
                break;
            case "Campsite":
                bulider.append("&p_PropertyTypes=4-36");
                break;
            case "With Residence":
                bulider.append("&p_PropertyTypes=4-37");
                break;
            case "Others":
                bulider.append("&p_PropertyTypes=4-100");
                break;
        }
        st = bulider.toString();
        return st;
    }

    private static void print(List<String> l) {
        System.out.println(l.toString());
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
    public static Property getOnePropertyByAPI(String apiId,String rsID) throws JSONException, IOException, InterruptedException {
        Property property = new Property();
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
        property.setPrice(price);
        property.setLocation(location);
        return property;
    }
    public static void main(String[] args) throws IOException, InterruptedException, SQLException, ClassNotFoundException, JSONException {
        String fileName = "/home/RESALES-ONLINE/baon/Documents/Bao_/CSV.csv";
//        writeCsvFile(fileName);
//        readCsvFile(fileName);
        String st = readCsvFile(fileName).get(0);
        System.out.println(st);
        ArrayList<String> temp = getListResponseProperty(st);
        callPropertyDetailAPi(temp.get(0),temp.get(1));
    }
}
