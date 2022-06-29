package vocation;

import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int userNumber = sc.nextInt();
		char[][] stars = new char[userNumber][];

		for(int i= 0; i < stars.length; i++) {

			stars[i] = new char[userNumber + i];
			int startPoint = userNumber - i - 1;
			for(int j = startPoint; j < stars[i].length; j++) {
				stars[i][j] = '*';
			}

		}
		int start=1;
		for(int i=start;i>0;i++) {
			stars[userNumber][start]=' ';
			stars[userNumber+i][start]=' ';
			stars[userNumber-i][start]=' ';
			start++;
		}
		for(int i = 0; i < stars.length; i++) {
			for(int j = 0; j < stars[i].length;j++) {
				System.out.print(stars[i][j]);
			}
			System.out.println();
		}
	}
}