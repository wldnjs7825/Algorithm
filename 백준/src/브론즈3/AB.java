package ∫Í∑–¡Ó3;

import java.util.Scanner;

public class AB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			sb.append(a+b+"\n");
		}
		
		System.out.println(sb);
	}

}
