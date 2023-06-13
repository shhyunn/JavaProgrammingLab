import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;



public class Fibonacci extends SwingWorker<Long, Void> {
    private int n;
    private int total;
    private FibonacciGui gui;


	public Fibonacci(int n, int intRow, FibonacciGui frame) {
		// TODO Auto-generated constructor stub
   	 	this.n = n;
        this.gui = frame;
        this.total = intRow;
    
	}


	@Override
    protected Long doInBackground() throws Exception {
		
		//Thread.sleep(1000);
        return fibonacci(n);
    }

    private long fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    
    @Override
    protected void done() {
        try {
            long result = get();
            gui.updateScreen(result);
            int totalPercentage = (int)(((n+1) /total) * 100);
            gui.setPercentage(totalPercentage);
            try {
            	Thread.sleep(100);
            } catch (InterruptedException ex) {}
            
            if (gui.areAllThreadsDone()== true) {
            	gui.setSum();
            }
            	
        } catch (InterruptedException e) {
            // 작업이 중단된 경우 예외 처리
        } catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
}