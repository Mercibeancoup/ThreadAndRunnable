package com.mine.current.base;

/**
 * 隋唐演义的大舞台
 * @author ZengYu
 *
 */
public class Stage extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ArmyRunnable armyTaskSuiDynasty=new ArmyRunnable();
		ArmyRunnable armyTaskOfRevolt= new ArmyRunnable();
		
		//使用Runnable接口创建线程
		Thread armyOfSuiDynasty=new Thread(armyTaskSuiDynasty,"隋朝军队");
		Thread armyOfRevolt=new Thread(armyTaskOfRevolt,"农名起义军");
		
		//启动线程,让军队开始作战
		armyOfSuiDynasty.start();
		armyOfRevolt.start();
		
		//调用休眠
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//设置属性为flase，达到可以结束的效果
		armyTaskSuiDynasty.keepattack=false;
		armyTaskOfRevolt.keepattack=false;
		
		try {
			armyOfRevolt.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Stage().start();
	}

}
