package 실버3;

import java.util.*;

public class N과M1 {
	static int N,M;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		result = new int[M];
		visited = new boolean[N+1];
		
		sb = new StringBuilder();
		Permu(0);
		System.out.println(sb);
	}
	
	public static void Permu(int idx) {
		//종료조건
		if(idx >= M) {
			//result배열에 있는 값 출력
			for(int i=0; i<M; i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");				
			return;
		}
		
		//순열이므로 모든 경우의 수를 다 체크 해야함
		for(int i=1; i<= N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[idx] = i;				
				Permu(idx+1);
				visited[i] = false;
			}
		}
		
	}
}
