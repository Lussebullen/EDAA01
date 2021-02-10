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
			grid[c][r] = nbr;
		}
	}

	@Override
	public int getNumber(int r, int c) {
		if (r<0 || c<0 || r>8 || c>8 ) {
			throw new IllegalArgumentException();
		//} else if (grid[r][c] == null) {   //if empty
		//	return 0;
		} else {
			return grid[c][r];
		}
	}

	@Override
	public void clearNumber(int r, int c) {
		if (r<0 || c<0 || r>8 || c>8 ) {
			throw new IllegalArgumentException();
		} else {
			grid[c][r]=0;
		}
		
	}

	@Override
	public boolean isValid(int r, int c, int nbr) {
		if (r<0 || c<0 || nbr <1 || r>8 || c>8 || nbr>9) {
			throw new IllegalArgumentException();
		} else {
			for (int i=1; i<9; i++) {
				if (grid[c][(r+i)%9]==nbr || grid[(c+i)%9][r]==nbr) { //checks all other values in row+col
					return false;
				}
			}
			int quadr = r%3;
			int quadc = c%3;
			for (int i=0;i<3;i++) {					//Checks all values in local 3x3 grid.
				for (int j=0;j<3;j++) {
					if (quadr+i==c && quadc+j==r) {  //do nothing if we compare to value itself
					} else if (grid[quadr+i][quadc+j]==nbr) {
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
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[][] getMatrix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMatrix(int[][] nbrs) {
		// TODO Auto-generated method stub
		
	}

}
