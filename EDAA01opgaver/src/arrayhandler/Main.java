package arrayhandler;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] nbrs1 = {1, 2, 3, 4, 5}; 
		int[] nbrs2 = {1, 2, 3, 4, 5}; 
		ArrayHandler.r1(nbrs1); 
		ArrayHandler.r2(nbrs2);
		System.out.println(Arrays.toString(nbrs1));
		System.out.println(Arrays.toString(nbrs2));
	}

}
