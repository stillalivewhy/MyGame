package com.xmx.main;

import java.util.Scanner;

import com.xmx.menu.Menu;

public class Test {

	public static void main(String[] args) {
		Menu menu = new Menu();
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while(true){
			menu.menuMainPrint();
			int chance = scanner.nextInt();
			menu.menuMain(chance);
		}
	}

}
