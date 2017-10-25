
public class Actor extends Thread{
	
	public void run(){
		System.out.println(getName()+"开始表演");
		int count=0;
		boolean currentTime=true;
		while(currentTime){
			System.out.println(getName()+"正在表演"+(++count)); 
			if (count==100) currentTime=false;
			
			//sleep
			if(count%10==0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println(getName()+"表演完了");
	}

	public static void main(String[] args) {
		Thread actor=new Actor();
		Thread actress= new Thread(new Actress(),"Ms.runable");
		actor.setName("Thread");
		actor.start();
		actress.start();
	}

}

//另写一个类
class Actress	implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"开始表演");
		int count=0;
		boolean currentTime=true;
		while(currentTime){
			System.out.println(Thread.currentThread().getName()+"正在表演"+(++count)); 
			if (count==100) currentTime=false;
			
			//sleep
			if(count%10==0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println(Thread.currentThread().getName()+"表演完了");
	}
	
}