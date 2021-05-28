package ½Ç¹ö3;

import java.util.*;

public class N°úM4 {
	static int N,M;
	static StringBuilder sb;
	static int[] result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sb = new StringBuilder();
		
		result = new int[M];
		BackT(0,1);
		
		System.out.println(sb);		
	}
	
	private static void BackT(int idx, int preNum) {
		if(idx == M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=preNum; i<=N; i++) {
			result[idx] = i;
			BackT(idx+1, i);
		}
	}
}
