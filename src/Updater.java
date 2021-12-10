import java.io.IOException;

import org.json.JSONException;

public class Updater implements Runnable{
	public CryptoPrice cryptoPrice = null;
	Integer interval = 0;
	public Updater(CryptoPrice cp, Integer userInterval) {
		cryptoPrice = cp;
		interval = userInterval;
	}
	
	@Override
	public void run() {
		
		while(true) {
			try {
				cryptoPrice.updatePrice(interval);
				try {
					Thread.sleep(interval * 1000);
				} catch (InterruptedException e) {
					continue;
				}
			} catch (IOException e) {
				continue;
			} catch (JSONException e) {
				continue;
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
}
