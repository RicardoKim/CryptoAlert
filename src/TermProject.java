import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;


public class TermProject
{
	static String UserID = null;
    public static void main(String args[]) throws IOException, JSONException
    {
    	
//        UserGUI usrGui = new UserGUI();
//        while(true) {
//        	UserID = usrGui.getUserID();
//        	if(UserID != null) {
//        		break;
//        	}
//        }
//  
//        ExecutorService executor = Executors.newFixedThreadPool(2);
//
//		CryptoPrice cryptoManager = new CryptoPrice(usrGui.getRatio());
//		
//		Updater updater = new Updater(cryptoManager, usrGui.getInterval());
//
//		Watcher watcher = new Watcher(cryptoManager);
//	
//		
//		executor.execute(updater);
//		executor.execute(watcher);
//
//		
//		executor.shutdown();
//    	SendingKakaoMessage sendingMessage = new SendingKakaoMessage();
//    	sendingMessage.sendingMessage();
    	GetToken tokenMaker = new GetToken();
    	tokenMaker.RecieveToken();
    }
    
    
    
}