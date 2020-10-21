package ºê·ÐÁî3;

import java.util.Scanner;

public class ±âÂïN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=n; i>=1; i--) {
			sb.append(i+"\n");
		}
		System.out.println(sb);
	}

}
