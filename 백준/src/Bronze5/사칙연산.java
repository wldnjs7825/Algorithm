package Bronze5;

import java.util.Scanner;

public class 사칙연산 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 =sc.nextInt();
		int n2 =sc.nextInt();
		int plus = n1+n2;
		int min = n1-n2;
		int mul = n1*n2;
		int div = n1/n2;
		int mod = n1%n2;

		System.out.println(plus);
		System.out.println(min);
		System.out.println(mul);
		System.out.println(div);
		System.out.println(mod);
	}

}