package com.mine.current.base;

public class SpecialPerson extends Thread {
	@Override
	public void run() {
		String name=Thread.currentThread().getName();
		System.out.println(name+"出现了");
		System.out.println(name+"梦想就是恢复世界美好河山");
		for (int i = 0; i < 10; i++) {
			System.out.println(name+"攻击了["+i+"]次");
		}
		
		System.out.println(name+"梦想实现了");
	}

}
