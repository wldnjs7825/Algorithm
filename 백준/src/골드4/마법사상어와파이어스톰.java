package 골드4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 마법사상어와파이어스톰 {

	static int N, Q;
	static int[][] map, resultMap;
	static int[] level;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		Q = sc.nextInt();
		N = calN(N);

		map = new int[N + 1][N + 1];
		level = new int[Q];

		for (int r = 1; r < N + 1; r++) {
			for (int c = 1; c < N + 1; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		for (int i = 0; i < Q; i++) {
			level[i] = sc.nextInt();
		}

		for (int q = 0; q < Q; q++) {
			// 얼음 이동
			if (level[q] != 0)
				div_map(q);

			// 얼음 녹이기
			melt_map();

		}

		int sum = 0;
		for (int r = 1; r < N + 1; r++) {
			for (int c = 1; c < N + 1; c++) {
				sum += map[r][c];
			}
		}

		int max = find_big();

		System.out.println(sum);
		System.out.println(max);
	}

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	private static int find_big() {
		boolean visited[][] = new boolean[N + 1][N + 1];
		int max = 0;
		for (int r = 1; r < N + 1; r++) {
			for (int c = 1; c < N + 1; c++) {
				if (!visited[r][c] && map[r][c] > 0) {
					int tmp = 1;

					Queue<Node> que = new LinkedList<>();
					que.add(new Node(r, c));
					visited[r][c] = true;

					while (!que.isEmpty()) {
						int size = que.size();

						for (int i = 0; i < size; i++) {
							Node node = que.poll();

							for (int d = 0; d < 4; d++) {
								int nr = node.r + dr[d];
								int nc = node.c + dc[d];

								if (nr >= 1 && nc >= 1 && nr < N + 1 && nc < N + 1 && !visited[nr][nc]
										&& map[nr][nc] > 0) {
									visited[nr][nc] = true;
									tmp++;

									que.add(new Node(nr, nc));
								}
							}
						}
					}

					max = Math.max(max, tmp);
				}
			}
		}
		return max;
	}

	private static void melt_map() {
		resultMap = new int[N + 1][N + 1];

		for (int nr = 1; nr < N + 1; nr++) {
			for (int nc = 1; nc < N + 1; nc++) {
				resultMap[nr][nc] = map[nr][nc];
			}
		}

		for (int r = 1; r < N + 1; r++) {
			for (int c = 1; c < N + 1; c++) {
				int cnt = 0;

				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (nr >= 1 && nc >= 1 && nr < N + 1 && nc < N + 1 && map[nr][nc] > 0) {
						cnt++;
					}
				}

				if (cnt < 3) {
					if (map[r][c] > 0)
						resultMap[r][c]--;
				}
			}
		}

		for (int nr = 1; nr < N + 1; nr++) {
			for (int nc = 1; nc < N + 1; nc++) {
				map[nr][nc] = resultMap[nr][nc];
			}
		}

	}

	private static void div_map(int q) {
		int lv = calN(level[q]);

		resultMap = new int[N + 1][N + 1];

		for (int r = 1; r < N + 1; r = r + lv) {
			for (int c = 1; c < N + 1; c = c + lv) {
				rot_map(r, c, lv);
			}
		}

		for (int nr = 1; nr < N + 1; nr++) {
			for (int nc = 1; nc < N + 1; nc++) {
				map[nr][nc] = resultMap[nr][nc];
			}
		}

	}

	private static void rot_map(int sr, int sc, int lv) {

		for (int r = 0; r < lv; r++) {
			for (int c = 0; c < lv; c++) {
				resultMap[sr + c][sc + lv - 1 - r] = map[sr + r][sc + c];

			}

		}
	}

	// 거듭제곱 구하기
	private static int calN(int num) {
		int n = 1;
		for (int i = 0; i < num; i++) {
			n *= 2;
		}
		return n;
	}
}
