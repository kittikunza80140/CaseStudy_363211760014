import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ExchangeAPI {
    //class attributes
    private String result;
    private String time_last_update_utc;
    private String time_next_update_utc;
    private String base_code;
    private JSONObject conversion_rates;

    private static String url_API =
            "https://v6.exchangerate-api.com/v6/c5ea5aa9fdb2c26fce08e984/latest/";
    private static JSONObject jsonObject

    //connect server
    public boolean getConnection(String base_code){
        String json = "";
        URL url = null;
        HttpURLConnection requrat = null;

        try {
            url = new URL(url_API + base_code);
            requrat = (HttpURLConnection) url.openConnection();

            //resd data From server
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();

            if (line.length() > 0){
                json += line;

            }
            //json to jsonObject
            jsonObject = new JSONObject(json);
            if (jsonObject == null){
                return false;
            }
            this.result = jsonObject.getString("result");
            this.time_last_update_utc = jsonObject.getString("time_last_update_utc");
            this.time_next_update_utc = jsonObject.getString("time_next_update_utc");
            this.base_code = jsonObject.getString("base_code");
            this.conversion_rates = jsonObject.getJSONObject("conversion_rates");







        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }//getConnection
}