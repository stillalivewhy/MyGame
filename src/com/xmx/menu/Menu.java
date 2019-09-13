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
				System.out.println("请输入英雄名称：");
				String name = scanner.nextLine();
				this.game = new Game(name);
				while(true){
					this.menuHeroPrint(game.getGamer().getName());
					int hchoose = scanner.nextInt();
					this.menuHero(hchoose);
					if(hchoose==5){
						System.out.println("是否退出?(y/n)");
						String cchoose = scanner.next();
						if("y".equals(cchoose)||"yes".equals(cchoose)){
							//存档
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
						System.out.println("是否退出?(y/n)");
						String cchoose = scanner.next();
						if("y".equals(cchoose)||"yes".equals(cchoose)){
							//退出
							break;
						}
					}
				}
				break;
			case 3:
				System.out.println("您即将退出，是否继续(y/n)");
				String choose = scanner.nextLine();
				if("y".equals(choose)||"yes".equals(choose)){
					System.out.println("欢迎下次光临");
					System.exit(0);
				}else{
					
				}
				break;
		}
	}
	
	public void menuMainPrint(){
		System.out.println("=========================");
		System.out.println("1.新游戏");
		System.out.println("2.读取存档");
		System.out.println("3.退出游戏");
		System.out.println("=========================");
		
	}
	
	public void menuHero(Integer chance){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		switch(chance){
			case 1:
				System.out.println();
				System.out.println(game.getGamer());
				System.out.println("任意键退出");
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
				System.out.println("是否存档?(y/n)");
				String cchoose = scanner.next();
				if("y".equals(cchoose)||"yes".equals(cchoose)){
					//存档
					Util.file(this.game, "game");
				}
				break;
			case 4:
				while(true){
					System.out.println("请选择怪物副本：");
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
		System.out.println(name+"，欢迎来到英雄游戏");
		System.out.println("1.人物属性");
		System.out.println("2.金币商店");
		System.out.println("3.存档");
		System.out.println("4.进入副本");
		System.out.println("5.退出游戏");
		System.out.println("=========================");
		
	}
	
	public boolean chanceMonster(String chance){
		boolean flag = true;
		Monster monster;
		int level = this.game.getStage();
		switch(chance){
			case "1":
				monster = this.game.initMonster("鸡", level);
				flag = this.game.attackGame(monster);
				break;
			case "2":
				monster = this.game.initMonster("蛇", level);
				flag = this.game.attackGame(monster);
				break;
			case "3":
				monster = this.game.initMonster("熊", level);
				flag = this.game.attackGame(monster);
				break;
			case "5":
				System.out.println("5.下一层");
				this.game.setStage(++level);
				break;
		}
		return flag;
	}
	
	public void chanceMonsterPrint(){
		
		System.out.println("=========================");
		System.out.println("1.鸡");
		System.out.println("2.蛇");
		System.out.println("3.熊");
		System.out.println("4.返回");
		System.out.println("5.下一层");
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
		System.out.println("欢迎来到英雄商店！！！");
		System.out.println("1.血量 +50，需金币10");
		System.out.println("2.攻击力+10，需金币10");
		System.out.println("3.经验值+20，需金币10");
		System.out.println("4.返回");
		System.out.println("=========================");
	}
}
