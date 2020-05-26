package Control_API_V4_4;

import java.sql.*;

public class ConnectDB {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String url ="jdbc:mysql://feature-602.git.env1.resales-online.com:3306/resalesonline_feature_602";
        String user="feature_602";
        String password= "AaYK7Hqu9ghHNLNrWUQr";
        Connection con = DriverManager.getConnection(url,user,password);
        return con;
    }
    public static void main(String[] args) {
        String url ="jdbc:mysql://feature-602.git.env1.resales-online.com:3306/resalesonline_feature_602";
        String user="feature_602";
        String password= "AaYK7Hqu9ghHNLNrWUQr";
        try {
            Connection con = DriverManager.getConnection(url,user,password);
            Statement sta = con.createStatement();
            String sql="select * from tblresale where RsId =3441919";
            ResultSet rs= sta.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

