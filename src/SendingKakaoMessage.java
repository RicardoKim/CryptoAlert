import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;



public class SendingKakaoMessage {
	

	public void sendingMessage(String alertMessage, Double currentPrice) throws IOException {
		OkHttpClient client = new OkHttpClient();
		

		URL url = new URL("https://kapi.kakao.com/v2/api/talk/memo/default/send"); 
		
		
		JSONObject message_header = new JSONObject();
		JSONObject message_content = new JSONObject();
		try {
			message_content.put("web_url" , "https://www.google.co.kr/search?q=bitcoin&source=lnms");
			message_content.put( "mobile_web_url" , "https://www.google.co.kr/search?q=bitcoin&source=lnms");
			message_header.put("object_type", "text");
			message_header.put("text" , alertMessage + " 가격 변동폭 발생 \n\n" +  "현재 가격 : " + currentPrice.toString());
			message_header.put("link", message_content);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		FormBody formBody = new FormBody.Builder().add("template_object", message_header.toString()).build();
		
		Request request = new Request.Builder() 
				.url(url) 
				.addHeader("Authorization","Bearer {accept code}")
				.post(formBody) 
				.build();

		Response response = client.newCall(request).execute();
	}
	

}
