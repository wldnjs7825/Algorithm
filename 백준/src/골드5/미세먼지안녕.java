package 골드5;

import java.util.Scanner;

public class 미세먼지안녕 {
	// 공기 청정기는 항상 1번 열, 두행을 차지
	// 공기 청정기 없는 칸에는 미세먼지 존재

	// 미세먼지 확산
	// 미세먼지 4방 확산, 확산되는 양은 미세먼지칸/5, 소수점은 버린다.
	// 미세먼지는 공기청정기나 벽으로는 확산 안됨
	// 남은 미세먼지 양은 x - (x/5*확산된 방향 수)

	// 공기청정기 작동
	// 위쪽바람은 반시계방향으로 작동 , 아래쪽 바람은 시계방향
	// 바람이 불면 미세먼지가 바람 방향대로 한칸씩 이동
	// 공기청정기로 들어간 미세먼지는 모두 정화된다.

	// T초 후 미세먼지 양 출력
	// R,C,T
	// 공기청정기가 설치된 곳은 -1
	static int R, C, T, air1_x, air1_y, air2_x, air2_y;
	static int[][] map, resultMap;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();

		map = new int[R][C];

		int tmp = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				map[r][c] = sc.nextInt();
				if (map[r][c] == -1) {
					if (tmp == 0) {
						air1_x = r;
						air1_y = c;
						tmp++;
					} else {
						air2_x = r;
						air2_y = c;
					}
				}
			}
		}

		for (int i = 0; i < T; i++) {
			// 미세먼지 확산
			// 미세먼지를 움직이고 새로운 배열에 저장
			resultMap = new int[R][C];
			resultMap[air1_x][air1_y] = -1;
			resultMap[air2_x][air2_y] = -1;
			// 먼지 확산
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (map[r][c] != 0 && map[r][c] != -1) {
						int dust = map[r][c];
						int spread_dust = dust / 5;

						int spread_cnt = 0;

						for (int d = 0; d < 4; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];

							if (check(nr, nc) && map[nr][nc] != -1) {
								spread_cnt++;
								resultMap[nr][nc] += spread_dust;
							}
						}

						// 원래 dust양 줄이기
						resultMap[r][c] += dust - (spread_dust * spread_cnt);
					}
				}
			}

			// 공기 청정 시작
			moveAir1();
			moveAir2();

			// 배열 깊은 복사
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					map[r][c] = resultMap[r][c];
				}
			}
		
		}

		int sum = 2;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				sum += map[r][c];
			}
		}
		System.out.println(sum);
	}

	private static void moveAir1() {
		int preDust = 0;
		
		// moveR
		for (int c = 1; c < C; c++) {
			int tmp = resultMap[air1_x][c];
			resultMap[air1_x][c] = preDust;
			preDust = tmp;
		}

		// moveUP
		for (int r = air1_x - 1; r >= 0; r--) {
			int tmp = resultMap[r][C - 1];
			resultMap[r][C - 1] = preDust;
			preDust = tmp;
		}

		// moveL
		for (int c = C - 2; c >= 0; c--) {
			int tmp = resultMap[0][c];
			resultMap[0][c] = preDust;
			preDust = tmp;
		}

		// moveDown
		for (int r = 1; r < air1_x; r++) {
			if(resultMap[r][0] == -1)
				break;
			int tmp = resultMap[r][0];
			resultMap[r][0] = preDust;
			preDust = tmp;
		}
	}

	private static void moveAir2() {
		int preDust = 0;

		// moveR
		for (int c = 1; c < C; c++) {
			int tmp = resultMap[air2_x][c];
			resultMap[air2_x][c] = preDust;
			preDust = tmp;
		}

		// moveDown
		for (int r = air2_x + 1; r < R; r++) {
			int tmp = resultMap[r][C - 1];
			resultMap[r][C - 1] = preDust;
			preDust = tmp;
		}

		// moveL
		for (int c = C - 2; c >= 0; c--) {
			int tmp = resultMap[R - 1][c];
			resultMap[R - 1][c] = preDust;
			preDust = tmp;
		}

		// moveUP
		for (int r = R - 2; r > air2_x; r--) {
			if(resultMap[r][0] == -1) break;
			int tmp = resultMap[r][0];
			resultMap[r][0] = preDust;
			preDust = tmp;
		}
	}

	private static boolean check(int nr, int nc) {

		if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
			return true;
		}
		return false;
	}

	private static void print(int[][] tmpMap) {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(tmpMap[r][c] + "  ");
			}
			System.out.println();
		}
		System.out.println("----------------------------");

	}

}
