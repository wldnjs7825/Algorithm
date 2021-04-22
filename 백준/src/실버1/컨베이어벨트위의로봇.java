package 실버1;

import java.util.Scanner;

public class 컨베이어벨트위의로봇 {

	static int N, K, stage;
	static Node[] belt;
	static boolean check;
	
	static class Node{
		int p; //현재 위치
		boolean st; //로봇의 유무
		int life; //내구도
		
		public Node(int p, boolean st, int life) {
			this.p = p;
			this.st = st;
			this.life = life;
		}	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		belt = new Node[N*2+1];
		stage = 0;
		
		for(int i=1; i<N*2+1; i++) {
			belt[i] = new Node(i,false,sc.nextInt());
		}
		check = true;
		
		while(check) {
			stage++;
			move_belt(); //belt이동	
			move_bot(); //로봇이동		
			up_bot();//로봇 올리기		
			check_life();		
		}
		
		System.out.println(stage);
	}
	
	private static void check_life() {
		
		int cnt = 0;
		for(int i=1; i<N*2+1; i++) {
			if(belt[i].life <= 0) {
				cnt++;
			}
		}
		
		if(cnt >= K)
			check = false;
			
	}

	private static void up_bot() {
		
		if(!belt[1].st && belt[1].life > 0) {
			belt[1].st = true;
			belt[1].life--;
		}

	}

	private static void move_bot() {
		
		for(int i=N; i>= 0; i--) {
			
			if(belt[i].st) {				
				if(i == N) {
					belt[i].st = false;				
				}else if(!belt[i+1].st && belt[i+1].life > 0){				
					belt[i].st = false;
			
					belt[i+1].st = true;
					belt[i+1].life--;					
				}
			}
		}

	}
	
	private static void move_belt() {
	
		belt[0] = belt[N*2];
		
		Node pre = belt[0];;
		
		for(int i=1; i<N*2+1; i++) {

			Node tmp = belt[i];
			//로봇 내리기
			if(i == N && belt[i].st) {
				belt[i].st = false;			
			}

			belt[i] = pre;
			pre = tmp;
			
		}

		belt[0] = belt[N*2];
		
	}

}
