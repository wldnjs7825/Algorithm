package 브론즈3;

import java.util.Scanner;

public class 별찍기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n-i; j++) {
				sb.append(" ");
			}
			for(int j=1; j<=i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
