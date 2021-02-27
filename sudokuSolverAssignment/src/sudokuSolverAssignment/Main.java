package sudokuSolverAssignment;

public class Main {

	public static void main(String[] args) {

		Sudoku testcase = new Sudoku();
		int[][] truex = { { 3, 1, 6, 5, 7, 8, 4, 9, 2 },
		         	   { 5, 2, 9, 1, 3, 4, 7, 6, 8 },
		         	   { 4, 8, 7, 6, 2, 9, 5, 3, 1 },
		         	   { 2, 6, 3, 4, 1, 5, 9, 8, 7 },
		         	   { 9, 7, 4, 8, 6, 3, 1, 2, 5 },
		         	   { 8, 5, 1, 7, 9, 2, 6, 4, 3 },
		         	   { 1, 3, 8, 9, 4, 7, 2, 5, 6 },
		         	   { 6, 9, 2, 3, 5, 1, 8, 7, 4 },
		         	   { 7, 4, 5, 2, 8, 6, 3, 1, 9 } };
		
		testcase.setMatrix(truex);
		
		Sudoku test2 = new Sudoku();
		int[][] partial = { { 3, 1, 6, 5, 7, 8, 4, 0, 2 },
		         	   { 5, 2, 9, 1, 3, 4, 7, 6, 8 },
		         	   { 4, 0, 7, 0, 2, 9, 5, 3, 1 },
		         	   { 2, 6, 3, 4, 1, 0, 9, 8, 7 },
		         	   { 9, 7, 4, 8, 6, 3, 1, 2, 0 },
		         	   { 8, 5, 1, 7, 9, 2, 6, 4, 3 },
		         	   { 1, 3, 0, 9, 4, 7, 2, 5, 6 },
		         	   { 6, 9, 2, 3, 5, 1, 8, 0, 4 },
		         	   { 0, 4, 5, 2, 8, 6, 3, 1, 9 } };
		
		int[][] unsolvable = { { 1, 0, 0, 0, 0, 0, 1, 0, 0 },
	         	   { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         	   { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         	   { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         	   { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         	   { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         	   { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         	   { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	         	   { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		
		test2.setMatrix(partial);
		int[][] test3 = new int[9][9];
		test3[0][0]=1;
		System.out.println(test3[1][1]);
		testcase.setMatrix(unsolvable);
		
		
		
		System.out.println(testcase.solve());
		System.out.println(testcase.isAllValid());
		//for (int i=0; i<9; i++) {
		//	for (int j=0; j<9; j++) {
		//		System.out.println(test2.getNumber(i, j)==truex[i][j]);
		//	}
		//}
		int[][] matin = { { 0, 0, 8, 0, 0, 9, 0, 6, 2 },
		      	   { 0, 0, 0, 0, 0, 0, 0, 0, 5 },
		      	   { 1, 0, 2, 5, 0, 0, 0, 0, 0 },
		      	   { 0, 0, 0, 2, 1, 0, 0, 9, 0 },
		      	   { 0, 5, 0, 0, 0, 0, 6, 0, 0 },
		      	   { 6, 0, 0, 0, 0, 0, 0, 2, 8 },
		      	   { 4, 1, 0, 6, 0, 8, 0, 0, 0 },
		      	   { 8, 6, 0, 0, 3, 0, 1, 0, 0 },
		      	   { 0, 0, 0, 0, 0, 0, 4, 0, 0 } };
		
		int[][] matout = { { 5, 4, 8, 1, 7, 9, 3, 6, 2 },
		      	   { 3, 7, 6, 8, 2, 4, 9, 1, 5 },
		      	   { 1, 9, 2, 5, 6, 3, 8, 7, 4 },
		      	   { 7, 8, 4, 2, 1, 6, 5, 9, 3 },
		      	   { 2, 5, 9, 3, 8, 7, 6, 4, 1 },
		      	   { 6, 3, 1, 9, 4, 5, 7, 2, 8 },
		      	   { 4, 1, 5, 6, 9, 8, 2, 3, 7 },
		      	   { 8, 6, 7, 4, 3, 2, 1, 5, 9 },
		      	   { 9, 2, 3, 7, 5, 1, 4, 8, 6 } };
		testcase.setMatrix(matin);
		testcase.solve();
		int[][] solvd = testcase.getMatrix();
		System.out.println("asd "+solvd.equals(matout));
		for (int i=0;i<9;i++) {
			for (int k=0; k<9;k++) {
				System.out.println(solvd[0][0]==matout[0][0]);
			}
		}
		System.out.println(solvd[0][0]+"  "+matout[0][0]);
		
		GUI testgui = new GUI();
		
	}

}
