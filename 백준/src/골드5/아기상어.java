package ���5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//ó�� �Ʊ��� ũ�� = 2
//4��Ž��
//�Ʊ���� �ڱ⺸�� ū ������ִ� ĭ ������ x
//������ ĭ�� ��� ����
//�ڱ⺸�� ���� ����⸸ �Ա� ����
//ũ�Ⱑ ������ ������ �������� �������� x
//�Ÿ��� ĭ�� ����
//�»�� �켱
//��� ũ�⸸ŭ �Ծ�� ����(+1)
//9: �Ʊ� ����� ��ġ
//1~6 ������� ũ��
public class �Ʊ��� {
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
		boolean st; //���� �� �ִ� ����⸦ ǥ���ϱ� ���� ���º���
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
				
				//�������
				if(map[r][c] == 9) {
					shark = new Shark(r,c,2,0);
				}
			}
		}
		
		time =0;
		//map���� ���� ���� ����Ⱑ ������ ����⸦ ã�� �Լ��� �����Ѵ�.
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
		// bfs�� ���� ���� ����� �Ÿ��� ���� �� �ִ� ����⸦ ã�´�. �̰����� �ݺ�
		Queue<Node> que = new LinkedList<>();
		visited = new boolean[N][N];

		que.add(new Node(shark.r, shark.c, false));
		visited[shark.r][shark.c] = true;
		boolean st = false; // ���� �� �ִ� ����⸦ ã���� while ���������� ���� ���º���
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

						// �Ա� �������� �Ǵ�
						if (map[nr][nc] != 0 && map[nr][nc] < shark.size) {
							st = true;
							que.add(new Node(nr, nc, true));
						} else {
							// ���� ���� ��� �̵����� ���� �Ǵ�
							if (map[nr][nc] == 0 || map[nr][nc] == shark.size)
								que.add(new Node(nr, nc, false));
						}
					}
				}
			} // for(d);

			// ���� ����Ⱑ �ִٸ� while ����
			if (st)
				break;
		}
		if (st) {
			time += tmpTime;
			// ������ ������ �����ϴ� ����� ã��
			int fishR = -1;
			int fishC = -1;

			// 1.���� ���� ��ǥ ����� ã��
			int size = que.size();
			int minR = Integer.MAX_VALUE;
			for (int i = 0; i < size; i++) {
				Node tmpNode = que.poll();
				if (tmpNode.st && tmpNode.r < minR) {
					minR = tmpNode.r;
					que.add(new Node(tmpNode.r, tmpNode.c, true));
				}
			}

			// 2.���� ���� ����� ã��
			size = que.size();
			int minC = Integer.MAX_VALUE;
			for (int i = 0; i < size; i++) {
				Node tmpNode = que.poll();
				if (tmpNode.st && tmpNode.c < minC) {
					fishR = tmpNode.r;
					fishC = tmpNode.c;
				}
			}
			// ����⸦ �԰� ����� ���� ������ �Ǵ��Ѵ�
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
