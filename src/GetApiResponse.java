import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetApiResponse {
    private static HttpURLConnection connection;
    public static void main(String[] args) {
//        BufferedReader reader;
//        String line;
//        StringBuffer reponseContent = new StringBuffer();
//        try {
//            URL url = new URL(  "feature-602.git.env1.resales-online.com/WebApi/V5-3/PropertyDetails.php?p1=1000610&p2=879dab3e2ed47c64e1c76f4d6f364e53b9432a3d&p_apiid=3598&p_refid=3441919");
//            connection = (HttpURLConnection) url.openConnection();
//
////            request setup
//            connection.setRequestMethod("GET");
//            connection.setReadTimeout(5000);
//            connection.setReadTimeout(5000);
//
//            int status = connection.getResponseCode();
////            System.out.println(status);
//            if (status>299){
//                reader= new BufferedReader( new InputStreamReader(connection.getErrorStream()));
//                while ((line=reader.readLine() )!=null){
//                    reponseContent.append(line);
//                }
//                reader.close();
//            }else{
//                reader= new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                while ((line=reader.readLine() )!=null){
//                    reponseContent.append(line);
//                }
//                reader.close();
//            }
//            System.out.println(reponseContent.toString());
//        }
//        catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }




        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("feature-602.git.env1.resales-online.com/WebApi/V5-3/PropertyDetails.php?p1=1000610&p2=879dab3e2ed47c64e1c76f4d6f364e53b9432a3d&p_apiid=3598&p_refid=3441919"
        )).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).thenAccept(System.out::println).join();
    }
    public static String parse(String responseBody) throws JSONException {
            JSONArray arr = new JSONArray(responseBody);
            for (int i =0;i<arr.length();i++){
                JSONObject pr = arr.getJSONObject(i);
                String id= arr.getString(Integer.parseInt("Reference"));
                System.out.println(id);
            }
            return null;
    }
}
