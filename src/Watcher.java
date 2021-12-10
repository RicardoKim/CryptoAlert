import java.io.IOException;

public class Watcher implements Runnable{
	public CryptoPrice cryptoPrice = null;
	
	public Watcher(CryptoPrice cp) {
		cryptoPrice = cp;
	}
	
	@Override
	public void run() {
		
		while(true) {
			try {
				cryptoPrice.conditionDetect();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			
				continue;
			}
		}
	}
}
