package com.xmx.domain;

import java.io.Serializable;

public class Base implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3326695371300085027L;
	private String name;
	private int level;
	private double attackPower;
	private double lifeValue;
	private double money;
	
	public Base(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public double getAttackPower() {
		return attackPower;
	}
	public void setAttackPower(double attackPower) {
		this.attackPower = attackPower;
	}
	public double getLifeValue() {
		return lifeValue;
	}
	public void setLifeValue(double lifeValue) {
		this.lifeValue = lifeValue;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
}
