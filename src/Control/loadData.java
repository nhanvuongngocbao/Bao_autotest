package Control;

import Control.ConnectDB;
import Model.Property;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loadData {
    public static Property queryProperty(Connection con) throws SQLException {
//        lấy dữ liệu 1 property
        String sql="select * from tblresale where RsId =3441919";
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

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Connection conn = ConnectDB.getConnection();
        Property p = queryProperty(conn);
        System.out.println(p.toString());
    }
}
