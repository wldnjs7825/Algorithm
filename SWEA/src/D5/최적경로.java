package D5;

import java.util.Scanner;

public class 최적경로 {
	//회사 출발 집으로 돌아가는 최단경로
	//완전탐색
	//회사 집 + n명의 고객좌표 
	static int N,min;
	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static Node home,work;
	static Node[] list;
	static boolean[] visited;
	static int[] result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			N = sc.nextInt();
			work = new Node(sc.nextInt(), sc.nextInt());
			home = new Node(sc.nextInt(), sc.nextInt());
			
			list = new Node[N];
			for(int i=0; i<N; i++) {
				Node tmp = new Node(sc.nextInt(), sc.nextInt());
				list[i] = tmp;
			}
			
			visited = new boolean[N];
			result = new int[N];
			min = Integer.MAX_VALUE;
			dfs(0);	
			System.out.println("#"+tc+" "+min);
		}

	}
	
	

	private static void dfs(int idx) {
		if(idx == N) {
			int preX = work.x;
			int preY = work.y;
			int distSum = 0;
			for(int i=0; i<N; i++) {
				int visitIdx = result[i];
				distSum += Math.abs(preX - list[visitIdx].x) + Math.abs(preY - list[visitIdx].y);
				preX = list[visitIdx].x;
				preY = list[visitIdx].y;	
			}
			//마지막 자표와 회사 거리 더해주기
			distSum += Math.abs(list[result[N-1]].x - home.x) + Math.abs(list[result[N-1]].y - home.y);

			min = Math.min(distSum, min);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				result[idx] = i;
				visited[i] = true;
				dfs(idx+1);
				visited[i] = false;
			}
		}
		
	}

}
