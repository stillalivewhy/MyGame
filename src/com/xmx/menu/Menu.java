package com.xmx.menu;

import java.util.Scanner;

import com.xmx.domain.Monster;
import com.xmx.game.Game;
import com.xmx.util.Util;

public class Menu{
	
	private Game game;
	public void menuMain(int chance){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		switch(chance){
		
			case 1:
				System.out.println("������Ӣ�����ƣ�");
				String name = scanner.nextLine();
				this.game = new Game(name);
				while(true){
					this.menuHeroPrint(game.getGamer().getName());
					int hchoose = scanner.nextInt();
					this.menuHero(hchoose);
					if(hchoose==5){
						System.out.println("�Ƿ��˳�?(y/n)");
						String cchoose = scanner.next();
						if("y".equals(cchoose)||"yes".equals(cchoose)){
							//�浵
							break;
						}
					}
				}
				break;
			case 2:
				this.game = (Game)Util.read("game");
				while(true){
					this.menuHeroPrint(this.game.getGamer().getName());
					int hchoose = scanner.nextInt();
					this.menuHero(hchoose);
					if(hchoose==5){
						System.out.println("�Ƿ��˳�?(y/n)");
						String cchoose = scanner.next();
						if("y".equals(cchoose)||"yes".equals(cchoose)){
							//�˳�
							break;
						}
					}
				}
				break;
			case 3:
				System.out.println("�������˳����Ƿ����(y/n)");
				String choose = scanner.nextLine();
				if("y".equals(choose)||"yes".equals(choose)){
					System.out.println("��ӭ�´ι���");
					System.exit(0);
				}else{
					
				}
				break;
		}
	}
	
	public void menuMainPrint(){
		System.out.println("=========================");
		System.out.println("1.����Ϸ");
		System.out.println("2.��ȡ�浵");
		System.out.println("3.�˳���Ϸ");
		System.out.println("=========================");
		
	}
	
	public void menuHero(Integer chance){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		switch(chance){
			case 1:
				System.out.println();
				System.out.println(game.getGamer());
				System.out.println("������˳�");
				scanner.next();
				
				break;
			case 2:
				while(true){
					this.menuNaturePrint();
					String nchoose = scanner.nextLine();
					this.menuNature(nchoose);
					if("4".equals(nchoose)){
						break;
					}
				}
				break;
			case 3:
				System.out.println("�Ƿ�浵?(y/n)");
				String cchoose = scanner.next();
				if("y".equals(cchoose)||"yes".equals(cchoose)){
					//�浵
					Util.file(this.game, "game");
				}
				break;
			case 4:
				while(true){
					System.out.println("��ѡ����︱����");
					this.chanceMonsterPrint();
					String choose = scanner.nextLine();
					if(!this.chanceMonster(choose)){
						choose = "4";
					}
					if("4".equals(choose)){
						break;
					}
				}
				break;
		}
	}
	
	public void menuHeroPrint(String name){
		System.out.println("=========================");
		System.out.println(name+"����ӭ����Ӣ����Ϸ");
		System.out.println("1.��������");
		System.out.println("2.����̵�");
		System.out.println("3.�浵");
		System.out.println("4.���븱��");
		System.out.println("5.�˳���Ϸ");
		System.out.println("=========================");
		
	}
	
	public boolean chanceMonster(String chance){
		boolean flag = true;
		Monster monster;
		int level = this.game.getStage();
		switch(chance){
			case "1":
				monster = this.game.initMonster("��", level);
				flag = this.game.attackGame(monster);
				break;
			case "2":
				monster = this.game.initMonster("��", level);
				flag = this.game.attackGame(monster);
				break;
			case "3":
				monster = this.game.initMonster("��", level);
				flag = this.game.attackGame(monster);
				break;
			case "5":
				System.out.println("5.��һ��");
				this.game.setStage(++level);
				break;
		}
		return flag;
	}
	
	public void chanceMonsterPrint(){
		
		System.out.println("=========================");
		System.out.println("1.��");
		System.out.println("2.��");
		System.out.println("3.��");
		System.out.println("4.����");
		System.out.println("5.��һ��");
		System.out.println("=========================");
	}
	
	public void menuNature(String chance){
		switch(chance){
			case "1":
				double lifeValue = this.game.getGamer().getLifeValue();
				lifeValue+=50;
				this.game.setGamerValue(lifeValue);
				break;
			case "2":
				double attackValue = this.game.getGamer().getAttackPower();
				attackValue+=10;
				this.game.setGamerAttack(attackValue);
				break;
			case "3":
				int expressValue = this.game.getGamer().getExpressValue();
				expressValue+=20;
				this.game.setGamerExpress(expressValue);
				break;
		}
	}
	
	public void menuNaturePrint(){
		System.out.println("=========================");
		System.out.println("��ӭ����Ӣ���̵꣡����");
		System.out.println("1.Ѫ�� +50������10");
		System.out.println("2.������+10������10");
		System.out.println("3.����ֵ+20������10");
		System.out.println("4.����");
		System.out.println("=========================");
	}
}
