package com.mine.current.base;

/**
 * 作战任务线程
 * @author ZengYu
 *
 */
public class ArmyRunnable implements Runnable {

	//volatile保证了线程可以正确的读取其他线程写入的值
	volatile boolean keepattack=true;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(keepattack){
			//五连击
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()+"攻击了对方["+i+"]");
				//让当前线程释放当前资源。即让出了处理器时间，下次谁进攻还不一定
				Thread.yield();
			}
			System.out.println(Thread.currentThread().getName()+"结束了战斗");
		}
	}

}
	