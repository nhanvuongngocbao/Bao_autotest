import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ParseJson {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, JSONException {
        BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Admin/Desktop/json.txt"));
        String json = "";
        try {
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = reader.readLine();
            }
            json = sb.toString();
        } finally {
            reader.close();
        }
        //System.out.println(json);
        JSONObject object = new JSONObject(json);
        double p = object.getJSONObject("Property").getDouble("OriginalPrice");
        System.out.println(p);
    //
        Connection conn = ConnectDB.getConnection();
        Property property = loadData.queryProperty(conn);

        if (p == property.getPrice()){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }

}
