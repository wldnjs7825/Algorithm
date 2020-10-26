package 브론즈3;

import java.util.Scanner;

public class X보다작은수 {
	static int N, target;
	static int[] data;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		target = sc.nextInt();
		data = new int[N];
		
		for(int i=0; i<N; i++) {
			data[i] = sc.nextInt();
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			if(data[i] < target)
				sb.append(data[i]+" ");
		}
		System.out.println(sb);
	}

}
