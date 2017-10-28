package com.mine.current.energysystem;

public class EnergySystemTest {

	//将要创建的能量世界的盒子数目
	public static final int BOX_AMOUNT=100;
	//将要创建的每个盒子的能量数目		
	public static final int INITAL_AMOUNT=1000;
	
	public static void main(String[] args) {
		EnergySystem energySystem = new EnergySystem(BOX_AMOUNT, INITAL_AMOUNT);
		for (int i = 0; i < BOX_AMOUNT; i++) {
			EnergyTransferTask energyTransferTask = new EnergyTransferTask(energySystem, i, INITAL_AMOUNT);
			Thread thr=new Thread(energyTransferTask, "TransferThread_"+i);
			thr.start();
		}
		
	}

}
