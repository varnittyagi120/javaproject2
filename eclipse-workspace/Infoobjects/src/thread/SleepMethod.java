package thread;

public class SleepMethod extends Thread{
    public void run(){
    	for(int i=0;i<5;i++) {
    		try {
    		   Thread.sleep(500);
    		}catch(InterruptedException exception) {
    			exception.printStackTrace();
    		}
    		System.out.println(i);
    	}
    }
	public static void main(String[] args) throws InterruptedException {
		 SleepMethod sleepMethod1=new SleepMethod();
		 SleepMethod sleepMethod2=new SleepMethod();
		
			sleepMethod1.start();
			sleepMethod2.start();
	}

}