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
		System.out.println("����ֵ���ӳɹ�");
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
			System.out.println("��þ���ֵ��"+express);
			expressValue+=express;
			this.gamer.setExpressValue(expressValue);
			this.gamer.upLevel();
			return true;
		}else{
			System.out.println("����С�ֶ��򲻹��������ǻ���̥����ɣ�����");
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
//		int flag = 0;//0.��ʾ��Ϸû������1.��ʾӢ��ʤ��������2.Ӣ����������
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
//				//����Ҫ���ֲ˵����Ƿ������һ������
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
//			//������Ҫʹ�����л����д浵
//		}
//	}
}
