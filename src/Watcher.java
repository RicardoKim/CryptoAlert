
public class Watcher implements Runnable{
	public CryptoPrice cryptoPrice = null;
	
	public Watcher(CryptoPrice cp) {
		cryptoPrice = cp;
	}
	
	@Override
	public void run() {
		
		while(true) {
			cryptoPrice.conditionDetect();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			
				continue;
			}
		}
	}
}
