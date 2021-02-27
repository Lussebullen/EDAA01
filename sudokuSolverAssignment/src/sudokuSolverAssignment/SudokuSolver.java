package sudokuSolverAssignment;

public interface SudokuSolver {
	/**
	 * Sets the number nbr in box r, c.
	 * 
	 * @param r
	 *            The row
	 * @param c
	 *            The column
	 * @param nbr
	 *            The number to insert in box r, c
	 * @throws IllegalArgumentException        
	 *             if r or c is outside [0..getDimension()-1] or
	 *             number is outside [1..9] 		
	 */
	public void setNumber(int r, int c, int nbr);
	
	/**
	 * Returns the number in box r,c. If the box is empty 0 is returned.
	 * 
	 * @param r
	 *            The row
	 * @param c
	 *            The column
	 * @return the number in box r,c or 0 if the box is empty
	 * @throws IllegalArgumentException
	 *             if r or c is outside [0..getDimension()-1] 
	 */
	public int getNumber(int r, int c);
	
	/** 
	 * Clears the number in box r,c i.e makes it 0.
	 * 
	 * @param r
	 *            The row
	 * @param c
	 *            The column
	 * 
	 * @throws IllegalArgumentException        
	 *             if r or c is outside [0..getDimension()-1]
	 * 
	 */
	public void clearNumber(int r, int c);
	
	/**
	 *  Checks that there is no element with the same integer value
	 *  on the row, column or quadrant of input.
	 *  
	 * @param r
	 *            The row
	 * @param c
	 *            The column
	 * @param nbr
	 *            The number to insert in box r, c
	 *            
	 * @throws IllegalArgumentException        
	 *             if r or c is outside [0..getDimension()-1] or
	 *             number is outside [1..9] 	            
	 *            
	 *            
	 * @return true 
	 * 				if nbr was valid.
	 */
	public boolean isValid(int r, int c, int nbr);

	/** 
	 * Examines all of the entries in our Sudoku are legitimate entries.
	 * 
	 * @return false 
	 * 				if an entry has the number 0 or if the isValid functions returns false
	 *  
	 * 
	 * @return true 
	 * 				if all entries were valid
	 * 
	 */
	public boolean isAllValid();
		
	/** 
	 * Recursively attempts to solve the soduku using backtracking.
	 * If there exists a solution the grid will take on the values of one possible solution.
	 * 
	 * @return false 
	 * 				if it could not be solved
	 *  
	 * 
	 * @return true 
	 * 				if it solved the Sudoku
	 * 
	 * 
	 * 
	 */
	public boolean solve();
		
	/** 
	 * 
	 * Resets the grid making all entries 0.
	 * 
	 */
	public void clear();
		
	/**
	 * Returns the numbers in the grid. An empty box is represented
	 * by the value 0.
	 * 
	 * @return
	 * 			 the matrix
	 */
	public int[][] getMatrix();

	/**
	 * Fills the grid with the numbers in nbrs.
	 * 
	 * @param nbrs the matrix with the numbers to insert
	 * @throws IllegalArgumentException
	 *             if nbrs have wrong dimension or containing values not in [0..9] 
	 */
	public void setMatrix(int[][] nbrs);
		
	
	/**
	 * Returns the dimension of the grid
	 * 
	 * @return the dimension of the grid
	 */
	public default int getDimension() {
		return 9;
	}

}