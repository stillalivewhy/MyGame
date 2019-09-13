package com.xmx.domain;

import java.io.Serializable;

public class Gamer extends Base implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6767224721830669133L;
	/**
	 * 
	 */
	
	private static final double attackPowerInit = 5.0;
	private static final double lifeValueInit = 100.0;
	private static final int levelInit = 1;
	
	
	
	private double lifeValueMax;
	private int expressValue;
	private int expressValueMax;
	public Gamer(String name){
		super(name); 
		super.setMoney(0);
		super.setAttackPower(attackPowerInit); 
		
		this.lifeValueMax = lifeValueInit;
		super.setLifeValue(lifeValueMax);
		super.setLevel(levelInit);
		this.expressValueMax = super.getLevel()*10+10;
	}
	
	public int getExpressValue() {
		return expressValue;
	}

	public void setExpressValue(int expressValue) {
		this.expressValue = expressValue;
		this.upLevel();
	}
	
	public boolean isLevelUp(){
		if(this.expressValue>=this.expressValueMax){
			return true;
		}
		return false;
	}
	
	public void upLevel(){
		int level = super.getLevel();
		double attackPower = super.getAttackPower();
		if(this.isLevelUp()){
			super.setLevel(++level);
			super.setAttackPower(attackPower*level);
			this.lifeValueMax = this.lifeValueMax+level*100;
			super.setLifeValue(this.lifeValueMax);
			this.expressValue = 0;
			this.expressValueMax = this.expressValueMax*2;
			System.out.println("恭喜英雄升级！！！");
		}
	}
	
	@Override
	public String toString(){
		return "英雄姓名："+super.getName()+"\n英雄等级："+super.getLevel()+"\n英雄生命值："+super.getLifeValue()+"\n英雄现有金币："+super.getMoney()+"\n英雄攻击力："+super.getAttackPower()+"\n英雄目前经验值："+this.expressValue;
	}
	
	public String lifeAttack(){
		return "英雄血量："+super.getLifeValue()+"，英雄攻击力："+super.getAttackPower();
	}

	public double getLifeValueMax() {
		return lifeValueMax;
	}

	public void setLifeValueMax(double lifeValueMax) {
		this.lifeValueMax = lifeValueMax;
	}

	public int getExpressValueMax() {
		return expressValueMax;
	}

	public void setExpressValueMax(int expressValueMax) {
		this.expressValueMax = expressValueMax;
	}
	
}
