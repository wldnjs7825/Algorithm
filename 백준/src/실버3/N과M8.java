package ½Ç¹ö3;

import java.util.*;

public class N°úM8 {
	static int N,M;
	static int[] num, result;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		num = new int[N];
		result = new int[M];
		sb= new StringBuilder();
		
		for(int i=0; i<N; i++) {
			num[i] = sc.nextInt();
		}
		
		Arrays.sort(num);
		
		BackT(0,0);
		
		System.out.println(sb);
	}
	
	private static void BackT(int idx,int preNum) {
		if(idx == M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i]+" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i=preNum; i<N; i++) {
			result[idx] = num[i];
			BackT(idx+1, i);
		}
	}
}
