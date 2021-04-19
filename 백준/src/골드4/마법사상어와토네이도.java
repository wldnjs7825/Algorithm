package 골드4;

import java.util.Scanner;

public class 마법사상어와토네이도 {
	static int N, sandSum;
	static int[][] map;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { -1, 0, 1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N + 1][N + 1];
		sandSum = 0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		// 탐색
		int nr = N / 2;
		int nc = N / 2;
		int dist = 0;
		int d = 0; // 0 1 2 3, 좌 하 우 상

		while (true) {
			if (nr <= 0 && nc <= 0) {
				break;
			}
			// 좌 우 에서 1증가
			if (d == 0 || d == 2) {
				dist++;
			}

			// 거리만큼 이동
			for (int i = 0; i < dist; i++) {
				nr += dr[d];
				nc += dc[d];

				// 모래 이동
				if (nr >= 0 && nc >= 0 && nr < N && nc < N) {

					moveSand(nr - dr[d], nc - dc[d], map[nr][nc], d);
					map[nr][nc] = 0;
				
				}
			}

			// 방향 바꾸기
			d++;
			if (d == 4) {
				d = 0;
			}
		}
		int sum = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				sum += map[r][c];
			}
		}
		
		System.out.println(sandSum);
	}

	// x좌표가 매개변수
	private static void moveSand(int r, int c, int sand, int d) {
		int sum = 0;
		int outSum = 0;
		int dir1 = 0;
		int dir2 = 0;
		if(d == 0 || d== 2) {
			dir1 = 3; //상
			dir2 = 1; //하
		}else {
			dir1 = 0; //좌
			dir2 = 2; //우
		}
		
		// 1.상
		int nr = r + dr[dir1];
		int nc = c + dc[dir1];
		if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
			map[nr][nc] += sand / 100;
			sum += sand / 100;
		}else{
			outSum += sand / 100;
		}

		// 1.하
		nr = r + dr[dir2];
		nc = c + dc[dir2];
		if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
			map[nr][nc] += sand / 100;
			sum += sand / 100;
		}else{
			outSum += sand / 100;
		} 

		// 2.상
		nr = r + dr[d] + dr[dir1];
		nc = c + dc[d] + dc[dir1];
		if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
			map[nr][nc] += sand * 7 / 100;
			sum += sand * 7 / 100;
		}else{
			outSum += sand * 7 / 100;
		} 
		// 2.상 상
		nr += dr[dir1];
		nc += dc[dir1];
		if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
			map[nr][nc] += sand * 2 / 100;
			sum += sand * 2 / 100;
		} else {
			outSum += sand * 2 / 100;
		}

		// 2.하
		nr = r + dr[d] + dr[dir2];
		nc = c + dc[d] + dc[dir2];
		if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
			map[nr][nc] += sand * 7 / 100;
			sum += sand * 7 / 100;
		}else{
			outSum += sand * 7 / 100;
		}  
		
		// 2.하 하
		nr += dr[dir2];
		nc += dc[dir2];
		if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
			map[nr][nc] += sand * 2 / 100;
			sum += sand * 2 / 100;
		} else {
			outSum += sand * 2 / 100;
		}

		// 3.상
		nr = r + dr[d] * 2 + dr[dir1];
		nc = c + dc[d] * 2 + dc[dir1];
		if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
			map[nr][nc] += sand / 10;
			sum += sand / 10;
		}else{
			outSum += sand / 10;
		}  

		// 3.하
		nr = r + dr[d] * 2 + dr[dir2];
		nc = c + dc[d] * 2 + dc[dir2];
		if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
			map[nr][nc] += sand / 10;
			sum += sand / 10;
		}else{
			outSum += sand / 10;
		}   

		// 4.
		nr = r + dr[d] * 3;
		nc = c + dc[d] * 3;
		if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
			map[nr][nc] += sand * 5 / 100;
			sum += sand * 5 / 100;
		}else{
			outSum += sand * 5 / 100;
		}   
				
		//남은 모래 저장
		nr = r + dr[d] * 2;
		nc = c + dc[d] * 2;
		if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
			map[nr][nc] += sand-(outSum+sum);
		}
		else {
			outSum += sand-(outSum+sum);
		}
		sandSum += outSum;
	}

}
