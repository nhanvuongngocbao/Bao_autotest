package Control;

import Model.Property;

import java.sql.*;

public class GetPropertyByCallJDBC {
    public static Property getPropertyByCallJDBC(String rsID) throws SQLException {
        Property property = new Property();
        String url ="jdbc:mysql://feature-602.git.env1.resales-online.com:3306/resalesonline_feature_602";
        String user="feature_602";
        String password= "AaYK7Hqu9ghHNLNrWUQr";
        Connection con = DriverManager.getConnection(url,user,password);
        String sql ="select RsID,RsSalePrice,RsCountry,RsProvince,RsArea,RsLocation, RsType, RsSubType from tblresale where RsID="+rsID.substring(1);
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
