package Control;

import Model.Property;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.SQLException;

public class CallApiV2 {
    public static void main(String[] args) throws InterruptedException, IOException, SQLException, ClassNotFoundException, JSONException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://feature-602.git.env1.resales-online.com/WebApi/V5-3/PropertyDetails.php?p1=1000610&p2=879dab3e2ed47c64e1c76f4d6f364e53b9432a3d&p_apiid=3598&p_refid=3441919"))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        //System.out.println(response.body());
        String js= response.body();
        JSONObject object = new JSONObject(response.body());
        double p = object.getJSONObject("Property").getDouble("OriginalPrice");
        System.out.println(p);
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

