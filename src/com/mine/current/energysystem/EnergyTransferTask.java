package com.mine.current.energysystem;

import java.util.Random;

public class EnergyTransferTask implements Runnable {
	// 建立私有的能量盒子
	private EnergySystem energySystem;
	// 能量转移的能量源盒子下标
	private int fromBox;
	// 单次能转移的最大能量数
	private double maxAmount = 50;
	// 最大休眠时间（毫秒）
	private int DELAY = 10;

	/**
	 * 构造函数 创建转移任务
	 * 
	 * @param energySystem
	 * @param from
	 * @param amount
	 */
	public EnergyTransferTask(EnergySystem energySystem, int from, double amount) {
		this.energySystem = energySystem;
		this.fromBox = from;
		this.maxAmount = amount;
	}

	@Override
	public void run() {

		try {
			while (true) {
				int toBox = (int) (energySystem.getTotalLength() * Math.random());
				double amount = maxAmount * Math.random();
				energySystem.transfer(fromBox, toBox, amount);
				Thread.sleep((int) (DELAY * Math.random()));
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
