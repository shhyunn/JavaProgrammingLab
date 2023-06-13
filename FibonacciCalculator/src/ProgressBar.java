import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

public class ProgressBar extends SwingWorker<Integer, Void>{
	private FiboGUI frame;
	private int sequence;

	public ProgressBar(int sequence2, FiboGUI frame) {
		this.sequence = sequence;
		this.frame = frame;
	}

	@Override
	protected Integer doInBackground() throws Exception {
		this.frame.setPercentage(this.sequence);
		return 0;
	}
	
	@Override
	protected void done() {
		try {
			long result = get(); //storing the result of thread

	   } catch (InterruptedException e) {
			e.printStackTrace();
		
       } catch (ExecutionException e) {
			e.printStackTrace();
		} 
	}

}
