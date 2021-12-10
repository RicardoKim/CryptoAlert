import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList; 
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.json.JSONException; 


public class CryptoPrice {
	LinkedList<Double> priceLinkedList = new LinkedList<Double>();
	SendingKakaoMessage sendingMessage = new SendingKakaoMessage();
	
	private static Lock lock = new ReentrantLock();
	Integer linkedListMaxSize = 10;
	Double alertRatio = 0.0;
	String currentTime = "";
	public CryptoPrice(Double ratio) {
		alertRatio = ratio;
	}
	
	public void updatePrice(Integer UserInterval) throws IOException, JSONException, InterruptedException {

		GetCurrentPrice getPrice = new GetCurrentPrice();
		
        HashMap<String, Double> coinInfo = getPrice.getCoinPrice();
        Object Time = coinInfo.keySet().toArray()[0];
        Double coinPrice = coinInfo.get(Time);
        currentTime = Time.toString();
        lock.lock();
        if(priceLinkedList.size() == linkedListMaxSize) {
        	priceLinkedList.removeLast();
        	priceLinkedList.add(coinPrice);
        	Thread.sleep(1000*UserInterval);
        }
        else {
  
        	priceLinkedList.add(coinPrice);
        }
        lock.unlock();
	}
	
	public void conditionDetect() throws IOException {
		
	
		Double currentRatio = 0.0;
		if(priceLinkedList.size() > 2) {

			lock.lock();
			Double firstValue = priceLinkedList.get(0);
			Double lastValue =  priceLinkedList.get(priceLinkedList.size()-1);
			lock.unlock();
			currentRatio = (firstValue - lastValue)/lastValue * 100;
			
			
			if(currentRatio > alertRatio) {
				sendingMessage.sendingMessage(currentTime, firstValue);
				priceLinkedList.clear();
			}
		}

		
	}
	
	
}
