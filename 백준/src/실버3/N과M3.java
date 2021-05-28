package ½Ç¹ö3;

import java.util.*;

public class N°úM3 {
	static int N,M;
	static StringBuilder sb;
	static int[] result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M=  sc.nextInt();
		sb = new StringBuilder();
		result = new int[M];
		
		Perm(0);
		
		System.out.println(sb);
	}
	
	private static void Perm(int idx) {
		if(idx == M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			result[idx] = i;
			Perm(idx+1);
		}
	}
}
