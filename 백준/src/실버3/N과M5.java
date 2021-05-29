package ½Ç¹ö3;

import java.util.*;

public class N°úM5 {
	static int N,M;
	static int[] num,result;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		num = new int[N];
		result = new int[M];
		visited = new boolean[N];
		sb = new StringBuilder();
		
			
		for(int i=0; i<N; i++) {
			num[i] = sc.nextInt();			
		}
		
		Arrays.sort(num);
		
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
		
		for(int i=0; i<N; i++) {		
			if(!visited[i]) {
				visited[i] = true;
				result[idx] = num[i];
				Perm(idx+1);
				visited[i] = false;
			}
		}
	}
}
