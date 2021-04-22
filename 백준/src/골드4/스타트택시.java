package ∞ÒµÂ4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ω∫≈∏∆Æ≈√Ω√ {

	static int N, M, oil,tr,tc;
	static int[][] map;
	static People[] people_list;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static class Node{ 
		int r;
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	static class People{ //Ω¬∞¥¡§∫∏ ¿˙¿Â«“ ≥ÎµÂ
		int r; 
		int c;
		int targetR;
		int targetC;
		
		public People(int r, int c, int targetR, int targetC){
			this.r = r;
			this.c = c;
			this.targetR = targetR;
			this.targetC = targetC;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		oil = sc.nextInt(); 
		map = new int[N+1][N+1];
		people_list = new People[M];
		
		for(int r=1; r<N+1; r++) {
			for(int c=1; c<N+1; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		tr = sc.nextInt();
		tc = sc.nextInt();
		
		for(int i=0; i<M; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int targetR = sc.nextInt();
			int targetC = sc.nextInt();
			people_list[i] = new People(r, c, targetR, targetC);		
			map[r][c] = 10 + i;
		}
	
		boolean st = true;
		
		for(int i=0; i<M; i++) {
			//√÷¥‹∞≈∏Æ Ω¬∞¥ √£±‚
			st = find_people();	
			if(!st)
				break;
		}
		
		if(!st) {
			System.out.println(-1);
		}else {
			System.out.println(oil);
		}

	}

	private static boolean find_people() {
		// ≈√Ω√ ¿ßƒ°∂˚ Ω¬∞¥ ¿ßƒ°∞° ∞„ƒ•∂ß
		if (map[tr][tc] > 1) {	
			return move_taxi(tr, tc);
		}
		
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(tr, tc));
		boolean[][] visited = new boolean[N+1][N+1];
		visited[tr][tc] = true;
		ArrayList<Node> list = null; //µø¿œ ∞≈∏Æ º’¥‘ ¿˙¿Â«“ πËø≠
		
		boolean find_st = false;
		int dist = 0;
				
		while(!que.isEmpty()) {
			int size = que.size();
			dist++;
			list = new ArrayList<>();
			
			for(int i=0; i<size; i++) {
				Node node = que.poll();
				
				for(int d=0; d<4; d++) {
					int nr = node.r + dr[d];
					int nc = node.c + dc[d];
			
					if(nr >= 1 && nc >= 1 && nr < N+1 && nc < N+1 && !visited[nr][nc] && map[nr][nc] != 1) {
						visited[nr][nc] = true;
						
						if(map[nr][nc] == 0) {
							que.add(new Node(nr,nc));
						}else {
							find_st = true;
							list.add(new Node(nr,nc));
						}
					}
				}
			}
			
			if(find_st) {		
				oil -= dist; //Ω¬∞¥ ≈¬øÏ¥¬µ• ø¨∑· º“∫Ò
				break;
			}
		}
		
		if(oil <= 0 || !find_st) {
			return false;
		}
		
		//move_taxi
		if(list.size() == 1) {
			return move_taxi(list.get(0).r, list.get(0).c);
		}else if(list.size() > 1) {

			int tmpR = list.get(0).r;
			int tmpC = list.get(0).c;
			
			for(int i=1; i<list.size(); i++) {
				if(list.get(i).r < tmpR) {
					tmpR = list.get(i).r;
					tmpC = list.get(i).c;
				}else if(list.get(i).r == tmpR && list.get(i).c <tmpC) {
					tmpR = list.get(i).r;
					tmpC = list.get(i).c;
				}
			}
			return move_taxi(tmpR, tmpC);
		}	
		
		return false;
	}

	private static boolean move_taxi(int r, int c) {

		int idx = map[r][c] - 10;
		People peo = people_list[idx]; 
		
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(r, c));
		boolean[][] visited = new boolean[N+1][N+1];
		visited[r][c] = true;
		
		int dist = 0;
		boolean st = false;
	
		while(!que.isEmpty()) {
			int size = que.size();
			dist++;
				
			for(int i=0; i<size; i++) {
				Node node = que.poll();
				if(node.r == peo.targetR && node.c == peo.targetC) {
					dist--;
					st = true;
					break;
				}		
				for(int d=0; d<4; d++) {
					int nr = node.r + dr[d];
					int nc = node.c + dc[d];
					if(nr >= 1 && nc >= 1 && nr < N+1 && nc < N+1 && !visited[nr][nc] && map[nr][nc] != 1) {
						visited[nr][nc] = true;
						que.add(new Node(nr,nc));
					}
				}
			}
			
			if(st) {
				break;
			}
		}
		
		if(st) {
			map[peo.r][peo.c] = 0;
			oil -= dist;
		
			if(oil < 0) {
				return false;
			}else {
				tr = peo.targetR;
				tc = peo.targetC;
				oil += dist*2;
				return true;
			}
			
		}else {
			return false;
		}
	}

	private static void print(int[][] map2) {
		for(int r=1; r<N+1; r++) {
			for(int c=1; c<N+1; c++) {
				System.out.print(map[r][c]+"\t");
			}
			System.out.println();
		}
		
	}

}
