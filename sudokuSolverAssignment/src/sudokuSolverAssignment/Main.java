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
		
		test2.setMatrix(partial);
		
		System.out.println(test2.solve());
		System.out.println(test2.isAllValid());
		//for (int i=0; i<9; i++) {
		//	for (int j=0; j<9; j++) {
		//		System.out.println(test2.getNumber(i, j)==truex[i][j]);
		//	}
		//}
		
		
	}

}
