package com.xmx.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.xmx.domain.Gamer;
import com.xmx.domain.Monster;
import com.xmx.game.Game;

public class Util {
	public static int attack(Gamer gamer,Monster monster,int stage){
		int i=1;
		double gamerLife = gamer.getLifeValue();
		double monsterLife = monster.getLifeValue();
		double gamerAttack = gamer.getAttackPower();
		double monsterAttack = monster.getAttackPower();
		System.out.println("第"+stage+"关");
		while(true){
			System.out.println("第"+(i++)+"回合");
			if(gamerLife<=0){
				return 0;
			}
			if(monsterLife<=0){
				System.out.println("怪物被击杀！");
				return monster.getExpress();
			}
			
			gamerLife = gamerLife - monsterAttack;
			gamer.setLifeValue(gamerLife);
			System.out.println(gamer.lifeAttack());
			monsterLife = monsterLife - gamerAttack;
			monster.setLifeValue(monsterLife);
			System.out.println(monster);
		}
	}
	
	public static void file(Object object,String fileName){
		try{
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("F:/eclipse/MyGame/ioFile/"+fileName+".txt"));
			objectOutputStream.writeObject(object);
			objectOutputStream.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public static Object read(String fileName){
		Object object = null;
		try{
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("F:/eclipse/MyGame/ioFile/"+fileName+".txt"));
			object = objectInputStream.readObject();
			objectInputStream.close();
		}catch(IOException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return object;
	}
	
	public static void main(String[] args){
		Game game = (Game)read("game");
		System.out.println(game.getGamer());
	}
	
	
}
