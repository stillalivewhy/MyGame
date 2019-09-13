package com.xmx.game;

import java.io.Serializable;

import com.xmx.domain.Gamer;
import com.xmx.domain.Monster;
import com.xmx.menu.Menu;
import com.xmx.util.Util;

public class Game implements Serializable {
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1546391988921996980L;
	private Gamer gamer;
//	private List<Monster> mList = new ArrayList<Monster>();
	private int stage;
	private Menu menu;
	public Gamer getGamer() {
		return gamer;
	}
	public void setGamer(Gamer gamer) {
		this.gamer = gamer;
	}
//	public List<Monster> getmList() {
//		return mList;
//	}
//	public void setmList(List<Monster> mList) {
//		this.mList = mList;
//	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	
	public Game(String name){
		this.setStage(1);
		
		gamer = new Gamer(name);
	}
	public Monster initMonster(String name,int level){
		Monster monster = new Monster(name);
		monster.setAttackPower(level*2+1);
		monster.setExpress(level*2+2);
		monster.setLifeValue(10+2*2);
		monster.setMoney(level*2+1);
		return monster;
	}
	
	public void setGamerValue(double lifeValue){
		System.out.println("生命值增加成功");
		this.gamer.setLifeValue(lifeValue);
	}
	
	public void setGamerAttack(double attackPower){
		this.gamer.setAttackPower(attackPower);
	}
	
	public void setGamerExpress(int expressValue){
		this.gamer.setExpressValue(expressValue);
	}
	
	
	public boolean attackGame(Monster monster){
		int express = monster.getExpress();
		int expressValue = this.gamer.getExpressValue();
		if(Util.attack(gamer, monster,this.getStage())!=0){
			System.out.println("获得经验值："+express);
			expressValue+=express;
			this.gamer.setExpressValue(expressValue);
			this.gamer.upLevel();
			return true;
		}else{
			System.out.println("连个小怪都打不过，您还是回娘胎深造吧！！！");
			return false;
		}
	}
	public int getStage() {
		return stage;
	}
	public void setStage(int stage) {
		this.stage = stage;
	}
	
//	public void attackGame(){
//		int flag = 0;//0.表示游戏没结束，1.表示英雄胜利结束，2.英雄死亡结束
//		int express;
//		int expressValue;
//		Iterator<Monster> iter = mList.iterator();
//		while(iter.hasNext()){
//			Monster monster = (Monster)iter.next();
//			if(util.attack(gamer, monster)!=0){
//				express = monster.getExpress();
//				expressValue = gamer.getExpressValue();
//				expressValue+=express;
//				gamer.setExpressValue(expressValue);
//				//这里要出现菜单，是否继续下一个攻击
//				
//			}else{
//				flag = 2;
//				break;
//			}
//		}
//		
//		if(flag==2){
//			System.out.println("GAME OVER");
//		}
//		if(flag ==0){
//			//这里需要使用序列化进行存档
//		}
//	}
}
