package �����3;

import java.util.Scanner;

public class N��� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++)
			sb.append(i+"\n");
		System.out.println(sb);
	}

}
