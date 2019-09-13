package com.xmx.domain;

import java.io.Serializable;

public class Monster extends Base implements Serializable{
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4895344860087170554L;
	private int express;
	
	public Monster(String name){
		super(name);
	}
	
	public int getExpress() {
		return express;
	}
	public void setExpress(int express) {
		this.express = express;
	}
	
	@Override
	public String toString(){
		return "����ʣ��Ѫ����"+super.getLifeValue()+",���﹥������"+super.getAttackPower();
	}
	
}
