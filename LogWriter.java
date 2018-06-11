/******45J lab***********
//yungchc1 Yung-Chu Chuang 50926235
//tzulingw Tzu-Ling Wang   77721457
//
//
************************/
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