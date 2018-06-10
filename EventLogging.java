import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class EventLogging{
	
	public void TimerLogging(String threadName) {
		String fileName = "src/" + threadName + ".txt";
		
			try {
				PrintWriter pw = new PrintWriter(fileName);
				for(int i = 0; i < 10; i++)
				{
					Thread.sleep(0);
					pw.write("The current time is thread " + threadName + " printing at "+ System.currentTimeMillis() + "\n");
					System.out.println("The current time is thread " + threadName + " printing at "+ System.currentTimeMillis());
				}
				pw.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
	}
}