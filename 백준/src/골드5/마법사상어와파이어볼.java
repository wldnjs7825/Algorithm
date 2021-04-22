package ���5;

import java.util.Scanner;

public class ������������̾ {
	static int N, M, K; 
	static Ball[][] map,tmpMap;
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	
	static class Ball{
		int r;
		int c;
		int m; //����
		int s; //�ӷ�
		int d; //����
		int st; //st=0 �� 1��, st=1 0,2,4,6, st=2 1,3,5,7
		int cnt; //������ ���� ��
		
		public Ball(int r, int c, int m,int s, int d, int st,int cnt) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
			this.st = st;
			this.cnt = cnt;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt(); //���̾ ����
		K = sc.nextInt(); //�̵� ��
		
		map = new Ball[N+1][N+1];
	
		for(int i=0; i<M; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int m = sc.nextInt();
			int s = sc.nextInt();
			int d = sc.nextInt();
			map[r][c] = new Ball(r,c,m,s,d,0,1);	
		}

		for(int k=0; k<K; k++) {
			move(); 
		}
		
		//�����ִº� ������ �� ���ϱ�
		int sum = 0;
		for(int r=1; r<N+1; r++) {
			for(int c=1; c<N+1; c++) {
				if(map[r][c] == null) continue;
				
				if(map[r][c].st == 0) {		
					sum += map[r][c].m;
				}else {
					sum += map[r][c].m*4;
				}
			}
		}
		System.out.println(sum);
	}

	private static void move() {
		
		tmpMap = new Ball[N+1][N+1];
		
		for(int r=1; r<N+1; r++) {
			for(int c=1; c<N+1; c++) {
				if(map[r][c] == null) 
					continue;
				if(map[r][c].st == 0) {
					move_ball(map[r][c]);				
				}else if(map[r][c].st == 1) {
					//4�������� �̵� 0,2,4,6
					Ball tmpBall = map[r][c];				
					for(int d=0; d<8; d=d+2) {
						tmpBall.st = 0;
						tmpBall.d = d;
						move_ball(tmpBall);
					}
					
				}else {
					//4�������� �̵� 1,3,5,7
					Ball tmpBall = map[r][c];
					for(int d=1; d<8; d=d+2) {
						tmpBall.st = 0;
						tmpBall.d = d;
						move_ball(tmpBall);
					}
				}
				
				
			}
		}
		
		//�̵� �� ���̾ ������
		for(int r=1; r<N+1; r++) {
			for(int c=1; c<N+1; c++) {
				if(tmpMap[r][c] != null && tmpMap[r][c].st >= 1) {
					Ball tmpBall = tmpMap[r][c];
					tmpBall.m /= 5;
					tmpBall.s /= tmpBall.cnt;
					tmpBall.cnt = 1;
					if(tmpBall.m == 0) {
						tmpMap[r][c] = null;
					}else {
						tmpMap[r][c] = tmpBall;
					}
				}
			}
		}
				
		//�̵��� ���� �����ʿ� �ű��
		for(int r=1; r<N+1; r++) {
			for(int c=1; c<N+1; c++) {
				map[r][c] = tmpMap[r][c];
			}
		}
	
	}

	private static void move_ball(Ball ball) {
		int nr = ball.r;
		int nc = ball.c;
		nr = (nr + dr[ball.d] * ball.s - 1) % N + 1;
		if (nr <= 0)
			nr = N + nr;
		nc = (nc + dc[ball.d] * ball.s - 1) % N + 1;
		if (nc <= 0)
			nc = N + nc;



		if (tmpMap[nr][nc] == null) {

			tmpMap[nr][nc] = new Ball(nr, nc, ball.m, ball.s, ball.d, 0, 1);
		} else {
			Ball nBall = tmpMap[nr][nc];
			nBall.m += ball.m;
			nBall.s += ball.s;
			nBall.cnt++;
			
			if (nBall.st == 1 || nBall.st == 0) {
				if (nBall.d % 2 == ball.d % 2) {
					nBall.st = 1;
				} else {
					nBall.st = 2;
				}
			}
		}
	}
}
