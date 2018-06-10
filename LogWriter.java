public class LogWriter implements Runnable
{
	
	private Thread t;
	private String threadName;
	public static int threadCount;
	
	public void run() {
		EventLogging game = new EventLogging();
		System.out.println("Running Thread " + LogWriter.threadCount);
		game.TimerLogging(threadName);		
	}
	
	public void play(){
	          System.out.println("Starting LogWriter" +  LogWriter.threadCount );
	          if (t == null){
	        	 threadName = "Game-" + LogWriter.threadCount++;
	    		 Thread t = new Thread (this, threadName);
	    		 t.setPriority(Thread.MAX_PRIORITY);
	    		 t.start ();
	    	 }
	}
	
}