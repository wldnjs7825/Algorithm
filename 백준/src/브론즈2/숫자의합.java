package �����2;

import java.util.Scanner;

public class �������� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String num = sc.next();
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			int c = num.charAt(i)-'0';
			sum += c;
		}
		System.out.println(sum);
	}
}
