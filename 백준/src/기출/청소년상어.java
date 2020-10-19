package ����;

import java.util.Scanner;

public class û�ҳ��� {
	//��ĭ ����� �Ѹ���
	//�����(��ȣ, ����)
	//��ȣ1�̻� 16����
	//��ȣ �ߺ�x
	//8��
	//0,0 ����
	//����� �԰� �̵�
	static int[] dr = {0,-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,0,-1,-1,-1,0,1,1,1};
	static int[][] map;
	static Fish[] fishList;
	static Fish shark;
	static int max;
	static class Fish{
		int n;
		int r;
		int c;
		int d;
		boolean st;
		
		public Fish(int n, int r, int c, int d, boolean st) {
			this.n = n;
			this.r = r;
			this.c = c;
			this.d = d;
			this.st = st;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[4][4];
		fishList = new Fish[17];
		for(int r=0; r<4; r++) {
			for(int c=0; c<4; c++) {
				int tmpN = sc.nextInt();
				int tmpD = sc.nextInt();
				
				Fish fish = new Fish(tmpN,r,c,tmpD, true);
				fishList[fish.n] = fish;
				map[r][c] = fish.n;
			}
		}
		max = map[0][0];
		//���� map�� -1�� ǥ��
		shark = new Fish(-1,0,0,fishList[map[0][0]].d, true);
		//���� ������ false�� ��ȯ
		fishList[map[0][0]].st = false;
		map[0][0] = -1;
		
		//������̵�
	
		map = moveFish(map);
		
		//����̵�
		moveShark(0,0,shark.d,map,max);
		
		System.out.println("max"+max);
	}
	
	//1 �� �����δ�
	//2 ����Ⱑ �̵��Ѵ�
	
	private static int[][] moveFish(int[][] fmap) {
		for(int i=1; i<=16; i++) {
			//�����.st == true�̸� �̵�
			if(fishList[i].st) {
				int nr = fishList[i].r + dr[fishList[i].d];
				int nc = fishList[i].c + dc[fishList[i].d];
				
				if(nr>=0 && nc>=0 && nr<4 && nc<4 && fmap[nr][nc] != -1) {
			
					if(fmap[nr][nc] == 0) {
						//�̵��� ����0�ΰ��
						fmap[fishList[i].r][fishList[i].c] = 0;
						fmap[nr][nc] = fishList[i].n;
						fishList[i].r = nr;
						fishList[i].c = nc;
					} else {
						//�̵��� ���� ����Ⱑ �ִ� ���
						int tmpN = fmap[nr][nc];
						int preC = fishList[i].r;
						int preR = fishList[i].c;
						//���� ����� �̵�
						fmap[nr][nc] = fishList[i].n;
						
						//�̵��� ���� ����� �̵�
						fmap[preC][preR] = tmpN;
						fishList[tmpN].r = preC;
						fishList[tmpN].c = preR;
						
					}
				
					
					//����� ��ġ���� ����
					fishList[i].r = nr;
					fishList[i].c = nc;
				}
			}

		}
		
		return fmap;
	}

	private static void moveShark(int sr, int sc,int sd, int[][] smap, int sum) {
		//�� ���� ����Ⱑ�ִ��� ����ġ üũ�� ����
		boolean moveSt = false;
		int[][] originMap = smap;
		System.out.println("---------------------");
		print(originMap);
		System.out.println("---------------------");
		for(int dist=1; dist<=3; dist++) {
			int nr = sr+dr[sd]*dist;
			int nc = sc+dc[sd]*dist;
//			System.out.println("*"+sr+" "+sc);
//			System.out.println(nr+" "+nc+" "+dist);
//			print(smap);
			System.out.println("dist:"+dist);
			print(smap);
			if(nr>=0 && nc>=0 && nr<4 && nc<4 && smap[nr][nc] != 0) {
				int tmpFish = smap[nr][nc];
				moveSt = true;
				sum += tmpFish;
				
				//�� �̵�
				//System.out.println("tmpFish:"+tmpFish);
				fishList[tmpFish].st = false;

				smap[sr][sc] = 0;
				smap[nr][nc] = -1;
				shark.r = nr;
				shark.c = nc;
				shark.d = fishList[tmpFish].d;
			
				//����� �̵�
				smap = moveFish(smap);
				
//				System.out.println("-------------------------------");
				//�ٽ� ��� �̵�
				//moveShark(shark.r,shark.c,shark.d,smap, sum);
				fishList[tmpFish].st = true;
				smap = originMap;
			}
		}
		
		//�� ���� ����Ⱑ ���ٸ� ���� ������� �� ����
		if(!moveSt) {
			max = Math.max(max, sum);
		}
	}

	private static void print(int[][] nmap) {
		System.out.println("############");
		for(int r=0; r<4; r++) {
			for(int c=0; c<4; c++) {
				System.out.print(nmap[r][c]+" ");
			}
			System.out.println();
		}
		
	}

}
