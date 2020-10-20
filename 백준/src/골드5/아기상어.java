package 골드5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//처음 아기상어 크기 = 2
//4방탐색
//아기상어는 자기보다 큰 물고기있는 칸 지나감 x
//나머지 칸은 모두 가능
//자기보다 작은 물고기만 먹기 가능
//크기가 같으면 먹지는 못하지만 지나갈수 x
//거리는 칸의 개수
//좌상단 우선
//상어 크기만큼 먹어야 성장(+1)
//9: 아기 상어의 위치
//1~6 물고기의 크기
public class 아기상어 {
	static int N,time;
	static int[][] map;
	static boolean[][] visited;
	static class Shark{
		int r;
		int c;
		int size;
		int eatCnt;
		public Shark(int r, int c, int size,int eatCnt) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.eatCnt = eatCnt;
		}
	}
	static class Node{
		int r;
		int c;
		boolean st; //먹을 수 있는 물고기를 표시하기 위한 상태변수
		public Node(int r, int c, boolean st) {
			this.r = r;
			this.c = c;
			this.st = st;
		}
	}
	static Shark shark;
	static int[] dr= {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] = sc.nextInt();
				
				//상어저장
				if(map[r][c] == 9) {
					shark = new Shark(r,c,2,0);
				}
			}
		}
		
		time =0;
		//map에서 상어보다 작은 물고기가 있으면 물고기를 찾는 함수를 실행한다.
		if(find()) {
			eat();
		}

		System.out.println(time);
	}

	private static boolean find() {
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] !=0 && map[r][c] != 9 && map[r][c] < shark.size) {
					return true;
				}			
			}
		}	
		
		return false;
	}

	private static void eat() {
		// bfs를 통해 가장 가까운 거리의 먹을 수 있는 물고기를 찾는다. 이과정을 반복
		Queue<Node> que = new LinkedList<>();
		visited = new boolean[N][N];

		que.add(new Node(shark.r, shark.c, false));
		visited[shark.r][shark.c] = true;
		boolean st = false; // 먹을 수 있는 물고기를 찾으면 while 빠져나오기 위한 상태변수
		int tmpTime =0 ;
		while (!que.isEmpty()) {
			int size = que.size();
			tmpTime++;

			for (int i = 0; i < size; i++) {
				Node nNode = que.poll();
	
				for (int d = 0; d < 4; d++) {
					int nr = nNode.r + dr[d];
					int nc = nNode.c + dc[d];
					if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc]) {
	
						visited[nr][nc] = true;

						// 먹기 가능한지 판단
						if (map[nr][nc] != 0 && map[nr][nc] < shark.size) {
							st = true;
							que.add(new Node(nr, nc, true));
						} else {
							// 먹지 못할 경우 이동가능 한지 판단
							if (map[nr][nc] == 0 || map[nr][nc] == shark.size)
								que.add(new Node(nr, nc, false));
						}
					}
				}
			} // for(d);

			// 먹을 물고기가 있다면 while 종료
			if (st)
				break;
		}
		if (st) {
			time += tmpTime;
			// 최적의 조건을 만족하는 물고기 찾기
			int fishR = -1;
			int fishC = -1;

			// 1.가장 위의 좌표 물고기 찾기
			int size = que.size();
			int minR = Integer.MAX_VALUE;
			for (int i = 0; i < size; i++) {
				Node tmpNode = que.poll();
				if (tmpNode.st && tmpNode.r < minR) {
					minR = tmpNode.r;
					que.add(new Node(tmpNode.r, tmpNode.c, true));
				}
			}

			// 2.가장 왼쪽 물고기 찾기
			size = que.size();
			int minC = Integer.MAX_VALUE;
			for (int i = 0; i < size; i++) {
				Node tmpNode = que.poll();
				if (tmpNode.st && tmpNode.c < minC) {
					fishR = tmpNode.r;
					fishC = tmpNode.c;
				}
			}
			// 물고기를 먹고 상어의 성장 유무를 판단한다
			if (fishR != -1 && fishC != -1) {
				int fishSize = map[fishR][fishC];
				map[shark.r][shark.c] = 0;
				map[fishR][fishC] = 9;
				shark.r = fishR;
				shark.c = fishC;
				shark.eatCnt++;
				if (shark.eatCnt == shark.size) {
					shark.eatCnt = 0;
					shark.size++;
				}
			}

			if (find())
				eat();
		}
		return;
	}

	private static void print() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				System.out.print(map[r][c]);
			}
			System.out.println();
		}
		System.out.println("------------------------------------");
	}
}
