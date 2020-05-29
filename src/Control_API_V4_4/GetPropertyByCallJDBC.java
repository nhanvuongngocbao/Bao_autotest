package Control_API_V4_4;

import Model.Property;

import java.sql.*;

public class GetPropertyByCallJDBC {
    public static Property getPropertyForSaleByCallJDBC(String rsID) throws SQLException {
        Property property = new Property();
        String url ="jdbc:mysql://feature-602.git.env1.resales-online.com:3306/resalesonline_feature_602";
        String user="feature_602";
        String password= "AaYK7Hqu9ghHNLNrWUQr";
        Connection con = DriverManager.getConnection(url,user,password);
        String sql ="select RsId,RsSalePrice,RsSalePrice,RsCountry,RsArea,RsLocation,RsType,RsSubType,RsBeds,RsBaths,RsPicIdTo,RsDevId from tblresale where RsID="+rsID.substring(1);
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
            int beds = Integer.valueOf(rs.getString("RsBeds"));

            property.setRsID(id);
            property.setPrice(priceDB);
            property.setCountry(countryDB);
            property.setLocation(locationDB);
            property.setArea(areaDB);
            property.setProvince(provinceDB);
            property.setType(typeDB);
            property.setSubtype(subTypeDB);
            property.setBeds(beds);

        }
        return property;
    }
    public static Property getPropertyForRentByCallJDBC(String rsID) throws SQLException {
        Property property = new Property();
        String url ="jdbc:mysql://feature-602.git.env1.resales-online.com:3306/resalesonline_feature_602";
        String user="feature_602";
        String password= "AaYK7Hqu9ghHNLNrWUQr";
        Connection con = DriverManager.getConnection(url,user,password);
        String sql ="select RsId,RsSalePrice,RsCountry,RsArea,RsLocation,RsType,RsSubType,RsBeds,RsBaths,RsPicIdTo,RsDevId,RsForRent,RsShortTermRentalLow,RsShortTermRentalHigh,RsLongTermRental from tblresale join tblrentalcalendarwhere RsID="+rsID.substring(1);
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

            property.setRsID(id);
            property.setPrice(priceDB);
            property.setCountry(countryDB);
            property.setLocation(locationDB);
            property.setArea(areaDB);
            property.setProvince(provinceDB);
            property.setType(typeDB);
            property.setSubtype(subTypeDB);
        }
        return property;
    }
}
