package com.mine.current.energysystem;


/**
 * 模仿宇宙的能量守恒系统
 * 遵循能量守恒定律
 * 能量不能凭空产生或者消失，只能从一处到另外一处
 * @author ZengYu
 *
 */
public class EnergySystem {
	//能量盒子，存储能量
	private double[] energyBoxes;
	
	/**
	 * 进行能量盒子的初始化
	 * @param n   能量盒子 的数量
	 * @param initalEnergy  每个能量盒子含有的初始能量
	 */
	public EnergySystem(int n,double initalEnergy){
		energyBoxes= new double[n];
		for (int i = 0; i < energyBoxes.length; i++) {
			energyBoxes[i]=initalEnergy;
		}
	}
	
	/**
	 * 能量的转移，从一个盒子中转到另外一个盒子里面
	 * @param from  能量源
	 * @param to	能量终点
	 * @param amount 转移能量数
	 */
	public void transfer(int from ,int to,double amount){
		//能量源能量小于转移能量数，不进行转移
		if(energyBoxes[from]<amount) {
			return ;
		}
		
		System.out.println(Thread.currentThread().getName());
		energyBoxes[from] -= amount;
		//%d 表示对应位置的数值 ，%10.2f表示获取到的数值转换为浮点型数值，保留两位小数，整数为则为10位数
		System.out.printf("从%d中转移%10.2f单位能量到%d",from,amount,to);
		energyBoxes[to] +=amount;
		
		System.out.printf("能量总和：%10.2f%n",getTotalEnergies());
	}
	
	/**
	 * 获取总能量
	 * @return  总能量
	 */
	public double getTotalEnergies() {
		double sum=0;
		for (double energybox : energyBoxes) {
			sum += energybox;
		}
		return sum;
	}

	/**
	 * 返回能量盒子的长度
	 * @return  长度
	 */
	public int getTotalLength(){
		return energyBoxes.length;
	}

	
	
	
	
	
	
	
	
	
	
	
	

}
