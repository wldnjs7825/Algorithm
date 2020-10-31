package D5;

import java.util.Scanner;

public class ´«¹ë·ù_Æò±Õ {

	public static void main(String[] args) {
		int sum =0;
		Scanner sc = new Scanner(System.in);
		for(int i=1; i<=200; i++) {
			String input = sc.nextLine();
			char c = input.charAt(0);
			System.out.println(i+" "+c);
			if(c == 'O')
				sum++;
		}
		double result = sum/200.0;
		System.out.println(result*100+"%");

	}

}
