import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.text.SimpleDateFormat;


import org.json.JSONException;
import org.json.JSONObject;


public class GetCurrentPrice {
	
	 private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }
	
	public HashMap<String, Double> getCoinPrice() throws IOException, JSONException{
		String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
		InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      JSONObject outputJson = new JSONObject(jsonText);
	      
	      Double price = (Double) outputJson.getJSONObject("bpi").getJSONObject("USD").get("rate_float");
	      
	      Date currentRawTime = new Date(System.currentTimeMillis());
	      SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy년 MM월 dd일  HH시  mm분 ss초"); 
	      String timeNow = timeFormat.format(currentRawTime);
	      
	      HashMap<String, Double> output = new HashMap<String, Double>();
	      output.put(timeNow, price);
	      return output;
	      
	    } finally {
	      is.close();
	    }
		
	}
	
}

