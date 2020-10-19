package 기출;

import java.util.Scanner;

public class 청소년상어 {
	//한칸 물고기 한마라
	//물고기(번호, 방향)
	//번호1이상 16이하
	//번호 중복x
	//8방
	//0,0 시작
	//물고기 먹고 이동
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
		//상어는 map에 -1로 표시
		shark = new Fish(-1,0,0,fishList[map[0][0]].d, true);
		//먹힌 물고기는 false로 변환
		fishList[map[0][0]].st = false;
		map[0][0] = -1;
		
		//물고기이동
	
		map = moveFish(map);
		
		//상어이동
		moveShark(0,0,shark.d,map,max);
		
		System.out.println("max"+max);
	}
	
	//1 상어가 움직인다
	//2 물고기가 이동한다
	
	private static int[][] moveFish(int[][] fmap) {
		for(int i=1; i<=16; i++) {
			//물고기.st == true이면 이동
			if(fishList[i].st) {
				int nr = fishList[i].r + dr[fishList[i].d];
				int nc = fishList[i].c + dc[fishList[i].d];
				
				if(nr>=0 && nc>=0 && nr<4 && nc<4 && fmap[nr][nc] != -1) {
			
					if(fmap[nr][nc] == 0) {
						//이동한 곳이0인경우
						fmap[fishList[i].r][fishList[i].c] = 0;
						fmap[nr][nc] = fishList[i].n;
						fishList[i].r = nr;
						fishList[i].c = nc;
					} else {
						//이동한 곳의 물고기가 있는 경우
						int tmpN = fmap[nr][nc];
						int preC = fishList[i].r;
						int preR = fishList[i].c;
						//지금 물고기 이동
						fmap[nr][nc] = fishList[i].n;
						
						//이동한 곳의 물고기 이동
						fmap[preC][preR] = tmpN;
						fishList[tmpN].r = preC;
						fishList[tmpN].c = preR;
						
					}
				
					
					//물고기 위치정보 수정
					fishList[i].r = nr;
					fishList[i].c = nc;
				}
			}

		}
		
		return fmap;
	}

	private static void moveShark(int sr, int sc,int sd, int[][] smap, int sum) {
		//상어가 먹을 물고기가있는지 없는치 체크할 변수
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
				
				//상어가 이동
				//System.out.println("tmpFish:"+tmpFish);
				fishList[tmpFish].st = false;

				smap[sr][sc] = 0;
				smap[nr][nc] = -1;
				shark.r = nr;
				shark.c = nc;
				shark.d = fishList[tmpFish].d;
			
				//물고기 이동
				smap = moveFish(smap);
				
//				System.out.println("-------------------------------");
				//다시 상어 이동
				//moveShark(shark.r,shark.c,shark.d,smap, sum);
				fishList[tmpFish].st = true;
				smap = originMap;
			}
		}
		
		//상어가 먹을 물고기가 없다면 먹은 물고기의 합 저장
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
