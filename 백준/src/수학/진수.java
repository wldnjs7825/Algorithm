//package ����;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
////8���� 2������ ��ȯ
//public class ���� {
//	//static ArrayList list = new ArrayList();
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String num_eight = sc.next();
//		
//		//0�� ������ 0�� ����ϰ� ����
//		if(num_eight == 0) {
//			System.out.println("0");
//			return;
//		}
//		
//		//���ڸ��� 8^n�ؼ� 10������ ��ȯ
//		int tmp = num_eight;
//		int num_ten = 0;
//		int idx = 1;
//		while(tmp > 0) {
//			num_ten += (tmp%10)*idx;
//			tmp /= 10;
//			idx *= 8;
//		}
//
//		//10������ �ٽ� 2������ ��ȯ 
//		StringBuilder sb = new StringBuilder();
//		while(num_ten > 0) {
//			sb.append(num_ten%2);
//			num_ten /= 2;
//		}
//		
//		
//		//���
//		
//		System.out.println(sb.reverse());
//	}
//}
