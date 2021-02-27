package sudokuSolverAssignment;

public class Sudoku implements SudokuSolver {
	private int[][] grid;

	public Sudoku() {
		grid = new int[9][9];
	}
	
	@Override
	public void setNumber(int r, int c, int nbr) {
		if (r<0 || c<0 || nbr <1 || r>8 || c>8 || nbr>9) {
			throw new IllegalArgumentException();
		} else {
			grid[r][c] = nbr;
		}
	}

	@Override
	public int getNumber(int r, int c) {
		if (r<0 || c<0 || r>8 || c>8 ) {
			throw new IllegalArgumentException();
		} else {
			return grid[r][c];
		}
	}

	@Override
	public void clearNumber(int r, int c) {
		if (r<0 || c<0 || r>8 || c>8 ) {
			throw new IllegalArgumentException();
		} else {
			grid[r][c]=0;
		}
		
	}

	@Override
	public boolean isValid(int r, int c, int nbr) {
		if (r<0 || c<0 || nbr <1 || r>8 || c>8 || nbr>9) {
			throw new IllegalArgumentException();
		} else {
			for (int i=1; i<9; i++) {
				if (grid[r][(c+i)%9]==nbr || grid[(r+i)%9][c]==nbr) { //checks all other values in row+col
					return false;
				}
			}
			int quadr = r/3;
			int quadc = c/3;
			for (int i=0;i<3;i++) {					//Checks all values in local 3x3 grid.
				for (int j=0;j<3;j++) {
					if (3*quadc+i==c && 3*quadr+j==r) {  //do nothing if we compare to value itself
					} else if (grid[3*quadr+j][3*quadc+i]==nbr) {
						return false;
					}
				}
			}
			return true;
		}
	}

	@Override
	public boolean isAllValid() {
		boolean val = true;
		for (int i=0;i<9;i++) {
			for (int k=0; k<9; k++) {
				if (grid[i][k]==0) {
					return false;      //hasnt been filled out fully.
				} else if (this.isValid(i,k,grid[i][k])==false) {
					val=false;
				}
			}
		}
		return val;
	}

	@Override
	public boolean solve() {
		// TODO Auto-generated method stub
		return solve(0,0);
	}
	private boolean solve(int r, int c) {
		//preliminary check for invalid inputs
		for (int row=0; row<9; row++) {
			for (int col=0; col<9; col++) {
				if(grid[row][col]!=0 && !this.isValid(row, col, grid[row][col])) {
					return false;
				}
			}
		}
		//
		
		for (int row=0; row<9; row++) {
			for (int col=0; col<9; col++) {
				if (grid[row][col]==0) {  //only do something if empty.
					for (int val=1; val<10; val++) {
						if (this.isValid(row, col, val)) {
							grid[row][col]=val;
							if (this.solve()) {
								return true;
							} else {
								grid[row][col]=0;
							}
						} 
					}
					return false;
				}
			}
		}
		
		if (this.isAllValid()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void clear() {
		grid = new int[9][9];
	}

	@Override
	public int[][] getMatrix() {
		return grid;
	}

	@Override
	public void setMatrix(int[][] nbrs) {
		if (nbrs.length==9 && nbrs[1].length==9) {
			for (int i=0;i<9;i++) {
				for (int k=0;k<9;k++) {
					if (nbrs[k][i]<0 || nbrs[k][i]>9) {
						throw new IllegalArgumentException();
					} 
				}
			}
			grid = nbrs;
		} else {
			throw new IllegalArgumentException();
		}
 	}

}
