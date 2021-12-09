import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONException;
import org.json.JSONObject;



public class SendingKakaoMessage {
	
	public void sendingMessage() throws IOException {
		
		URL url = new URL("https://kapi.kakao.com/v2/api/talk/memo/default/send"); 
		HttpURLConnection messageAPI = (HttpURLConnection)url.openConnection();
		
		messageAPI.setRequestMethod("POST");
		messageAPI.setRequestProperty("Authorization", "Bearer " +  "{}");
		messageAPI.setDoOutput(true);
		messageAPI.setDoInput(true);
		messageAPI.connect();
		
		
		JSONObject message_header = new JSONObject();
		JSONObject message_content = new JSONObject();
		try {
			message_content.put("web_url" , "https://www.google.co.kr/search?q=drone&source=lnms&tbm=nws");
			message_content.put( "mobile_web_url" , "https://www.google.co.kr/search?q=drone&source=lnms&tbm=nws");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			message_header.put("object_type", "text");
			message_header.put("text" , "news");
			message_header.put("link", message_content);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String message = "template_object = {" + message_header.toString() + "}";
		
		
		OutputStream os = messageAPI.getOutputStream();
		os.write(("xml=" + URLEncoder.encode(message.toString(), "UTF-8")).getBytes("utf-8"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(messageAPI.getInputStream()));
		String returnMsg = in.readLine();
		System.out.println(returnMsg);
		System.out.println(messageAPI.getResponseMessage());
	}

}
