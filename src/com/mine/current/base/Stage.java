package com.mine.current.base;

/**
 * 隋唐演义的大舞台
 * @author ZengYu
 *
 */
public class Stage extends Thread {
	@Override
	public void run() {
		System.out.println("话说隋朝末年，上下纷乱，农民纷纷叛乱");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("此时隋朝军队也和农民起义军也展开了大战");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
			e.printStackTrace();
		}
		
		//设置属性为flase，达到可以结束的效果
		armyTaskSuiDynasty.keepattack=false;
		armyTaskOfRevolt.keepattack=false;
		
		try {
			armyOfRevolt.join() ;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		//英雄开始上场
		System.out.println("双方正打的猛烈，此时秦叔宝上场了");
		
		Thread mrQin= new SpecialPerson();
		mrQin.setName("秦琼");
		
		System.out.println("秦琼的理想就是让世界更美好");
		
		armyTaskSuiDynasty.keepattack=false;
		armyTaskOfRevolt.keepattack=false;
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mrQin.start();
		
		try {
			mrQin.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("战争结束了，秦琼也死了");
	}

	public static void main(String[] args) {
		new Stage().start();
	}

}
