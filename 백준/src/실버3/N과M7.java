package ½Ç¹ö3;

import java.util.*;

public class N°úM7 {
	static int N,M;
	static int[] num,result;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		num = new int[N];
		result = new int[M];
		sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			num[i] = sc.nextInt();
		}
		
		Arrays.sort(num);
		
		Back(0);	
		System.out.println(sb);
	}
	
	private static void Back(int idx) {
		if(idx == M) {
			for(int i=0; i<result.length; i++) {
				sb.append(result[i]+" ");
			}
			sb.append('\n');
			
			return;
		}
		
		for(int i=0; i<N; i++) {
			result[idx] = num[i];
			Back(idx+1);
		}
	}
}
