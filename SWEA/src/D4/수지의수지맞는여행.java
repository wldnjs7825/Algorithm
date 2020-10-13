package D4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//1,1 ~ R,C
public class 수지의수지맞는여행 {
	static int R,C,maxCnt;
	static char[][] map;
	static boolean[][] visited;
	static ArrayList visitedSpot;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<= T; tc++) {
			R = sc.nextInt();
			C = sc.nextInt();
			
			map = new char[R+1][C+1];
			
			for(int r=1;r<=R ;r++) {
				String line = sc.next();
				for(int c=1; c<=C; c++) {
					map[r][c] = line.charAt(c-1);
				}
			}
			
			visitedSpot = new ArrayList<>();
			visited = new boolean[R+1][C+1];
		
		
			visited[1][1] = true;
			visitedSpot.add(map[1][1]);
			maxCnt = 1;
			dfs(1,1,1);
			
			System.out.println("#"+tc+" "+maxCnt);
			
		}

	}
	private static void dfs(int r, int c, int cnt) {
		maxCnt = Math.max(maxCnt,cnt);
		
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(nr>=1 && nc>=1 && nr<=R && nc<=C && check(map[nr][nc])) {
				visited[nr][nc] = true;
				visitedSpot.add(map[nr][nc]);
				dfs(nr,nc,cnt+1);
				visited[nr][nc] = false;
				visitedSpot.remove(visitedSpot.size()-1);
			}
		}
		
	}
	//방문한 곳이 있는 여행지이면 false를 return
	private static boolean check(char nSpot) {
		boolean st = true;
		for(int i=0; i<visitedSpot.size(); i++) {
			if(visitedSpot.get(i).equals(nSpot)) {
				st = false;
				break;
			}
		}
		return st;
	}

}
