package Control_API_V4_4;

import Model.Property;
import java.sql.*;

import static java.sql.DriverManager.getConnection;


public class GetPropertyByCallJDBC {
    public static Property getPropertyForSaleByCallJDBC(String rsID) throws SQLException {
        Property property = new Property();
        String url ="jdbc:mysql://feature-602.git.env1.resales-online.com:3306/resalesonline_feature_602";
        String user="feature_602";
        String password= "AaYK7Hqu9ghHNLNrWUQr";
        Connection con = getConnection(url,user,password);
        String sql ="select RsId,RsSalePrice,RsProvince,RsCountry,RsArea,RsLocation,RsType,RsSubType,RsBeds,RsBaths,RsPicIdTo,RsDevId from tblresale where RsID="+rsID.substring(1);
        PreparedStatement pr = con.prepareStatement(sql);
        ResultSet rs= pr.executeQuery();
        while (rs.next()){
            String id = rs.getString("RsId");
            Double priceDB= rs.getDouble("RsSalePrice");
            String countryDB=rs.getString("RsCountry");
            String provinceDB= rs.getString("RsProvince");
            String areaDB = rs.getString("RsArea");
            String locationDB = rs.getString("RsLocation");
            String typeDB = rs.getString("RsType");
            String subTypeDB = rs.getString("RsSubType");
            String beds = (rs.getString("RsBeds"));
            String baths = (rs.getString("RsBaths"));
            String image = (rs.getString("RsPicIdTo"));
            String devID = rs.getString("RsDevId");
            property.setRsID(id);
            property.setPrice(priceDB);
            property.setCountry(countryDB);
            property.setLocation(locationDB);
            property.setArea(areaDB);
            property.setProvince(provinceDB);
            property.setType(typeDB);
            property.setSubtype(subTypeDB);
            property.setBeds(beds);
            property.setBaths(baths);
            property.setImages(image);
            property.setDevID(devID);
            property.setSearchType("ForSale");
        }
        return property;
    }
    public static Property getPropertyForLongRentByCallJDBC(String rsID) throws SQLException {
        Property property = new Property();
        String url ="jdbc:mysql://feature-602.git.env1.resales-online.com:3306/resalesonline_feature_602";
        String user="feature_602";
        String password= "AaYK7Hqu9ghHNLNrWUQr";
        Connection con = getConnection(url,user,password);
        String sql ="select RsId,RsCountry,RsArea,RsLocation,RsType,RsSubType,RsProvince,RsBeds,RsBaths,RsPicIdTo,RsDevId,RsForRent,RsShortTermRentalLow,RsLongTermRental from tblresale join tblrentalcalendar on RsId=RcRsId where RsID="+rsID.substring(1);
        PreparedStatement pr = con.prepareStatement(sql);
        ResultSet rs= pr.executeQuery();
        while (rs.next()){
            String id = rs.getString("RsId");
            double priceDB= rs.getDouble("RsLongTermRental");
            String countryDB= rs.getString("RsCountry");
            String provinceDB= rs.getString("RsProvince");
            String areaDB = rs.getString("RsArea");
            String locationDB = rs.getString("RsLocation");
            String typeDB = rs.getString("RsType");
            String subTypeDB = rs.getString("RsSubType");
            String beds = (rs.getString("RsBeds"));
            String baths = (rs.getString("RsBaths"));
            String image = (rs.getString("RsPicIdTo"));
            String devID = rs.getString("RsDevId");
            property.setRsID(id);
            property.setPrice(priceDB);
            property.setCountry(countryDB);
            property.setLocation(locationDB);
            property.setArea(areaDB);
            property.setProvince(provinceDB);
            property.setType(typeDB);
            property.setSubtype(subTypeDB);
            property.setBeds(beds);
            property.setBaths(baths);
            property.setImages(image);
            property.setDevID(devID);
            property.setSearchType("ForRent");
        }
        return property;
    }
    public static Property getPropertyForShortRentByCallJDBC(String rsID) throws SQLException {
        Property property = new Property();
        String url ="jdbc:mysql://feature-602.git.env1.resales-online.com:3306/resalesonline_feature_602";
        String user="feature_602";
        String password= "AaYK7Hqu9ghHNLNrWUQr";
        Connection con = getConnection(url,user,password);
        String sql ="select RsId,RsCountry,RsArea,RsLocation,RsType,RsSubType,RsProvince,RsBeds,RsBaths,RsPicIdTo,RsDevId,RsForRent,RsShortTermRentalLow,RsShortTermRentalHigh,RsLongTermRental from tblresale join tblrentalcalendarwhere RsID="+rsID.substring(1);
        PreparedStatement pr = con.prepareStatement(sql);
        ResultSet rs= pr.executeQuery();
        while (rs.next()){
            String id = rs.getString("RsId");
            double shortTermRentLow= rs.getDouble("RsShortTermRentalLow");
            double shortTermRentHigh= rs.getDouble("RsShortTermRentalHigh");
            String countryDB= rs.getString("RsCountry");
            String provinceDB= rs.getString("RsProvince");
            String areaDB = rs.getString("RsArea");
            String locationDB = rs.getString("RsLocation");
            String typeDB = rs.getString("RsType");
            String subTypeDB = rs.getString("RsSubType");
            String beds = rs.getString("RsBeds");
            String baths = rs.getString("RsBaths");
            String image = rs.getString("RsPicIdTo");
            String devID = rs.getString("RsDevId");
            property.setRsID(id);
            property.setShortTermRentHigh(shortTermRentHigh);
            property.setShortTermRentLow(shortTermRentLow);
            property.setCountry(countryDB);
            property.setLocation(locationDB);
            property.setArea(areaDB);
            property.setProvince(provinceDB);
            property.setType(typeDB);
            property.setSubtype(subTypeDB);
            property.setBeds(beds);
            property.setBaths(baths);
            property.setImages(image);
            property.setDevID(devID);
            property.setSearchType("ForRent");
        }
        return property;
    }
}
