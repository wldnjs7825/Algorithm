package �ǹ�3;

import java.util.*;

public class N��M1 {
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
		//��������
		if(idx >= M) {
			//result�迭�� �ִ� �� ���
			for(int i=0; i<M; i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");				
			return;
		}
		
		//�����̹Ƿ� ��� ����� ���� �� üũ �ؾ���
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
