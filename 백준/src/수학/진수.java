//package 수학;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
////8진수 2진수로 변환
//public class 진수 {
//	//static ArrayList list = new ArrayList();
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String num_eight = sc.next();
//		
//		//0이 들어오면 0을 출력하고 종료
//		if(num_eight == 0) {
//			System.out.println("0");
//			return;
//		}
//		
//		//각자리수 8^n해서 10진수로 변환
//		int tmp = num_eight;
//		int num_ten = 0;
//		int idx = 1;
//		while(tmp > 0) {
//			num_ten += (tmp%10)*idx;
//			tmp /= 10;
//			idx *= 8;
//		}
//
//		//10진수를 다시 2진수로 변환 
//		StringBuilder sb = new StringBuilder();
//		while(num_ten > 0) {
//			sb.append(num_ten%2);
//			num_ten /= 2;
//		}
//		
//		
//		//출력
//		
//		System.out.println(sb.reverse());
//	}
//}
