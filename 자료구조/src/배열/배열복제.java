package �迭;

import java.util.*;

public class �迭���� {
	public static void main(String[] args) {
		
		int[] a = new int[] {1,2,3,4,5};
		int[] b = a.clone();
		
		b[0]  = -1;
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}
}
