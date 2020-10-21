package ���5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//1��, 2���̷���
//4��Ž��
//��3�� �ʼ� ��ġ
//�������� ũ�� �ִ�
public class ������ {
	static int R,C,max;
	static int[][] map;
	static ArrayList<Node> vList,saveList;
	static boolean[] visited;
	static int[] result;
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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new int[R][C];
		vList = new ArrayList<>();
		saveList = new ArrayList<>();
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				map[r][c] = sc.nextInt();
				
				if(map[r][c] == 2) {
					vList.add(new Node(r,c));
				}else if(map[r][c] == 0) {
					saveList.add(new Node(r,c));
				}
			}
		}
		
		result = new int[3];
		visited = new boolean[saveList.size()];
		max = Integer.MIN_VALUE;
		comb(0,0);
		System.out.println(max);
	}

	//�������� 3���� ��ǥ ã�Ƽ� result �迭�� ����
	private static void comb(int idx, int depth) {
		if(idx == 3) {			
			//�ش� ��ǥ�� �� 3���� ��ġ
			int[][] copyMap = copy();
			
			for(int i=0; i<3; i++) {
				int listIdx= result[i];
				int tmpR = saveList.get(listIdx).r;
				int tmpC = saveList.get(listIdx).c;
				copyMap[tmpR][tmpC] = 1;
//				System.out.print(listIdx+"("+tmpR+","+tmpC+") ");
			}

			//bfs�� ���̷��� �۶߸���
			Queue<Node> que = new LinkedList<>();
			boolean[][] visited = new boolean[R][C];
			
			for(int i=0; i<vList.size(); i++) {
				int tmpR = vList.get(i).r;
				int tmpC = vList.get(i).c;
				que.add(new Node(tmpR,tmpC));
				visited[tmpR][tmpC] = true;
			}
			
			while(!que.isEmpty()) {
				int size = que.size();
				
				for(int i=0; i<size; i++) {
					Node nNode = que.poll();
					
					for(int d=0; d<4; d++) {
						int nr = nNode.r +dr[d];
						int nc = nNode.c +dc[d];
						
						if(nr>=0 && nc>=0 && nr<R && nc<C && !visited[nr][nc] && copyMap[nr][nc] == 0) {
							visited[nr][nc] = true;
							copyMap[nr][nc] = 2;
							que.add(new Node(nr,nc));
						}
					}
				}
			}
			
			//���� ���������� ������ ī��Ʈ ���� max�� ��
			int cnt = 0;
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					if(copyMap[r][c] == 0)
						cnt++;
				}
			}

			max = Math.max(max, cnt);
			
			return;
		}		
		
		if(depth == saveList.size()) 
			return;
		
		result[idx] = depth;
		visited[depth] = true;
		comb(idx+1, depth+1);
		
		visited[depth] = false;
		comb(idx,depth+1);
		
		
	}

	private static void print(int[][] tmpMap) {
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				System.out.print(tmpMap[r][c]+" ");
			}
			System.out.println();
		}
		System.out.println("-----------------");
		
	}

	private static int[][] copy() {
		int[][] tmpMap = new int[R][C];
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				tmpMap[r][c] = map[r][c];
			}
		}
		return tmpMap;
	}
}
