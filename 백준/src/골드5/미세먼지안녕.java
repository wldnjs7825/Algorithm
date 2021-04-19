package ���5;

import java.util.Scanner;

public class �̼������ȳ� {
	// ���� û����� �׻� 1�� ��, ������ ����
	// ���� û���� ���� ĭ���� �̼����� ����

	// �̼����� Ȯ��
	// �̼����� 4�� Ȯ��, Ȯ��Ǵ� ���� �̼�����ĭ/5, �Ҽ����� ������.
	// �̼������� ����û���⳪ �����δ� Ȯ�� �ȵ�
	// ���� �̼����� ���� x - (x/5*Ȯ��� ���� ��)

	// ����û���� �۵�
	// ���ʹٶ��� �ݽð�������� �۵� , �Ʒ��� �ٶ��� �ð����
	// �ٶ��� �Ҹ� �̼������� �ٶ� ������ ��ĭ�� �̵�
	// ����û����� �� �̼������� ��� ��ȭ�ȴ�.

	// T�� �� �̼����� �� ���
	// R,C,T
	// ����û���Ⱑ ��ġ�� ���� -1
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
			// �̼����� Ȯ��
			// �̼������� �����̰� ���ο� �迭�� ����
			resultMap = new int[R][C];
			resultMap[air1_x][air1_y] = -1;
			resultMap[air2_x][air2_y] = -1;
			// ���� Ȯ��
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

						// ���� dust�� ���̱�
						resultMap[r][c] += dust - (spread_dust * spread_cnt);
					}
				}
			}

			// ���� û�� ����
			moveAir1();
			moveAir2();

			// �迭 ���� ����
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
