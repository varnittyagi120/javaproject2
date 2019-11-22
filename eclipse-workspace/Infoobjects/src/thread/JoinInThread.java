package thread;

public class JoinInThread extends Thread{
    public void run()
    {
    	for(int i=1;i<5;i++) {
		    	try {
		    		  Thread.sleep(500);
		    	}catch(InterruptedException exception) {
		    		exception.printStackTrace();
		    	}
		    	System.out.println(i);
    	}
    }
	public static void main(String[] args) {
		JoinInThread joinInThread1=new JoinInThread();
		JoinInThread joinInThread2=new JoinInThread();
		JoinInThread joinInThread3=new JoinInThread();
		joinInThread1.start();
		try {
			joinInThread1.join();
		}catch(Exception exception)
		{
			exception.printStackTrace();
		}
		joinInThread2.start();
		joinInThread3.start();
	}

}
