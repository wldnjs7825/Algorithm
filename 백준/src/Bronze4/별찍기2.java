package Bronze4;

import java.util.*;

public class º°Âï±â2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=N; i++) {
			for(int j=N-i; j>0; j--) {
				sb.append(" ");
			}
			
			for(int j=0; j<i; j++) {
				sb.append("*");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
