package sudokuSolverAssignment;

public class Main {

	public static void main(String[] args) {
		Sudoku sd = new Sudoku();
		sd.setNumber(0, 0, 1);
		sd.setNumber(0, 1, 2);
		sd.setNumber(0, 2, 3);
		sd.setNumber(0, 3, 4);
		sd.setNumber(0, 4, 5);
		sd.setNumber(0, 5, 6);
		sd.setNumber(0, 6, 7);
		sd.setNumber(0, 7, 8);
		sd.setNumber(0, 8, 9);
		
		System.out.println(sd.isAllValid());
	}

}
