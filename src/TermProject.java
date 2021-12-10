import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;


public class TermProject
{
	static Double alertRatio = null;
    public static void main(String args[]) throws IOException, JSONException
    {
    	
        UserGUI usrGui = new UserGUI();
        while(true) {
        	alertRatio = usrGui.getRatio();
        	if(alertRatio != null) {
        		break;
        	}
        }
  
        ExecutorService executor = Executors.newFixedThreadPool(2);
		CryptoPrice cryptoManager = new CryptoPrice(alertRatio);
		
		Updater updater = new Updater(cryptoManager, usrGui.getInterval());
		Watcher watcher = new Watcher(cryptoManager);
	
		
		executor.execute(updater);
		executor.execute(watcher);

		
		executor.shutdown();
    	
    }
    
    
    
}