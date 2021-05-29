package 실버4;

import java.util.*;

public class 문자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		
		//str2에서 str1과 가장 비슷한 문자열 찾고 그차이가 답임
		int min = Integer.MAX_VALUE;
		for(int i=0; i<=str2.length()-str1.length(); i++) {
			
			String subStr2 = str2.substring(i,i+str1.length());
			
			int cnt = 0;
			for(int j=0; j<str1.length(); j++) {
				char c1 = str1.charAt(j);
				char c2 = subStr2.charAt(j);
				if(c1 != c2) {
					cnt++;
				}
			}
			
			min = Math.min(min, cnt);
		}
		
		System.out.println(min);
	}
}
