import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class Fibo extends SwingWorker<Long, Integer>{
	private int n; //for storing the row number
	private long totalSum; //for storing the total sum of fibonacci series
	private int tempNum; //for storing the temp number of each fibonacci series
	private FiboGUI frame; //for storing the gui frame
	
	public Fibo(int intRow, FiboGUI frame) {
		this.n = intRow;
		this.frame = frame;
	}
	
	/*function for calculating the fibonacci series using recursion*/
	private int fibonacci(int temp) {
		if (temp <= 1) {
			return temp; //if the temp is less than 2, it returns own self
		}
		return fibonacci(temp-1) + fibonacci(temp-2); //otherwise, it returns recursive function
	}
	
	/*function for calculating according to row number*/
	@Override
	protected Long doInBackground() throws Exception {
		frame.setCancelBtn(true); //enabling cancel button
		
		/*iteration if the temp is less than 'n', and the cancel button status if off*/
		for (int temp = 0; temp < this.n && (!frame.isCanceled()); temp++) { 
			tempNum = fibonacci(temp);
			frame.setPercentage(temp);
			publish(tempNum);
			Thread.sleep(100);
		}
		
		return totalSum;
	}
	
	/*function for processing the total sum*/
	@Override
	protected void process(List<Integer> chunks) {
	    for (Integer chunk : chunks) {
	        totalSum += chunk;
	        frame.setScreen(chunk); //printing the each fibonacci number
	    }	
	}
	
	/*function for completed thread*/
	@Override
	protected void done() {
		try {
			long result = get(); //storing the result of thread
			frame.setSum(result); //printing the total sum
			frame.setCancelBtn(false); //after the thread, the cancel button is not enabled
			
			/*condition whether cancel button status is false*/
			if (!frame.isCanceled()) { 
				frame.writeText();
			}

	   } catch (InterruptedException e) {
			e.printStackTrace();
		
       } catch (ExecutionException e) {
			e.printStackTrace();
		} 
	}
}
