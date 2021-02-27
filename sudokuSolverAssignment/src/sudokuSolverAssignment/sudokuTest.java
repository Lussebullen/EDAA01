package sudokuSolverAssignment;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import 	static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class sudokuTest {
	private Sudoku sud;
		
	
	@BeforeEach
	void setUp() throws Exception {
		sud= new Sudoku();
	}
	
	@AfterEach
	void tearDown() throws Exception {
		sud = null;

	}
	
	@Test
	void testEmpty() { // tests an empty
		int[][] matin= { { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		      	   { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		      	   { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		      	   { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		      	   { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		      	   { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		      	   { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		      	   { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		      	   { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		sud.setMatrix(matin);
		for (int i=0;i<9;i++) {
			for (int k=0; k<9;k++) {
				assertTrue(sud.getMatrix()[i][k]==0,"Solved matrix is not correct");
			}
		}
		assertTrue(sud.solve(),"Empty matrix not solvable");
		for (int i=0;i<9;i++) {
			for (int k=0; k<9;k++) {
				assertTrue(sud.getMatrix()[i][k]!=0,"Solved matrix is not correct");
			}
		}
		
	}
	@Test
	void testSodukInFile() { //tests the given example in figure 1 
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
		
		
		sud.setMatrix(matin);
		
		assertTrue(sud.solve(), "Solve does not solve the given sudoku");
		sud.solve();
		for (int i=0;i<9;i++) {
			for (int k=0; k<9;k++) {
				assertTrue(sud.getMatrix()[i][k]==matout[i][k],"Solved matrix is not correct");
			}
		}		
	}
	@Test
	void testInvalidRow() { //Tests with same value on the same row
		int[][] matin = { { 0, 0, 8, 0, 0, 9, 0, 6, 2 },
		      	   { 0, 0, 0, 0, 0, 0, 0, 0, 5 },
		      	   { 1, 2, 0, 5, 0, 0, 2, 0, 0 },
		      	   { 0, 0, 0, 2, 1, 0, 0, 9, 0 },
		      	   { 0, 5, 0, 0, 0, 0, 6, 0, 0 },
		      	   { 6, 0, 0, 0, 0, 0, 0, 2, 8 },
		      	   { 4, 1, 0, 6, 0, 8, 0, 0, 0 },
		      	   { 8, 6, 0, 0, 3, 0, 1, 0, 0 },
		      	   { 0, 0, 0, 0, 0, 0, 4, 0, 0 } };
		sud.setMatrix(matin);
		assertFalse(sud.solve(), "Solve still tries solving an invalid soduku");
		
	}
	@Test
	void testInvalidQuadrant() { //Tests with value in the same 3x3 square
		int[][] matin = { { 0, 0, 8, 0, 0, 9, 0, 6, 2 },
		      	   { 0, 0, 0, 0, 0, 0, 0, 0, 5 },
		      	   { 1, 2, 0, 5, 0, 0, 0, 0, 0 },
		      	   { 0, 0, 0, 2, 1, 0, 0, 9, 0 },
		      	   { 0, 5, 0, 0, 0, 0, 6, 0, 0 },
		      	   { 6, 0, 0, 0, 0, 0, 0, 2, 8 },
		      	   { 4, 1, 0, 6, 0, 8, 0, 0, 0 },
		      	   { 8, 6, 0, 0, 3, 0, 1, 0, 0 },   //here
		      	   { 0, 8, 0, 0, 0, 0, 4, 0, 0 } }; //here
		sud.setMatrix(matin);
		assertFalse(sud.solve(), "Solve still tries solving an invalid soduku");
		
	}
	@Test
	void testInvalidCol() { ///tests with same value in the same column
		int[][] matin = { { 0, 0, 8, 0, 0, 9, 0, 6, 2 },
		      	   { 0, 0, 0, 0, 0, 0, 0, 0, 5 },
		      	   { 1, 2, 0, 5, 0, 0, 0, 0, 0 },
		      	   { 0, 0, 0, 2, 1, 0, 0, 9, 0 },
		      	   { 0, 5, 0, 0, 0, 0, 6, 0, 0 },
		      	   { 6, 0, 8, 0, 0, 0, 0, 2, 8 },
		      	   { 4, 1, 0, 6, 0, 8, 0, 0, 0 },
		      	   { 8, 6, 0, 0, 3, 0, 1, 0, 0 },
		      	   { 0, 0, 0, 0, 0, 0, 4, 0, 0 } };
		sud.setMatrix(matin);
		assertFalse(sud.solve(), "Solve still tries solving an invalid soduku");
		
	}
	@Test
	void testWrongDim() { //tests setMatrix with wrong dimension
		int[][] mat1 = new int[10][10];
		int[][] mat2 = new int[2][2];
		assertThrows(IllegalArgumentException.class, () -> {
			sud.setMatrix(mat1);
			},"setMatrix doesnt throw error when matrix too big");
		
		assertThrows(IllegalArgumentException.class, () -> {
			sud.setMatrix(mat2);
			},"setMatrix doesnt throw error when matrix too small");
	}
	@Test
	void testWrongInput() {
		int[][] mat1 = new int[9][9];
		mat1[0][0]=-1;
		assertThrows(IllegalArgumentException.class, () -> {
			sud.setMatrix(mat1);
			},"setMatrix doesnt throw error when matrix element negative");
		int[][] mat2 = new int[9][9];
		mat2[0][0]=15;
		assertThrows(IllegalArgumentException.class, () -> {
			sud.setMatrix(mat2);
			},"setMatrix doesnt throw error when matrix element too large");
		int[][] mat3 = new int[9][9];
		mat3[0][0]=1/2;
		assertThrows(IllegalArgumentException.class, () -> {
			sud.setMatrix(mat2);
			},"setMatrix doesnt throw error when matrix element not integer");
		
	}
	@Test
	void testClear() {
		int[][] matin = { { 0, 0, 8, 0, 0, 9, 0, 6, 2 },
		      	   { 0, 0, 0, 0, 0, 0, 0, 0, 5 },
		      	   { 1, 2, 0, 5, 0, 0, 0, 0, 0 },
		      	   { 0, 0, 0, 2, 1, 0, 0, 9, 0 },
		      	   { 0, 5, 0, 0, 0, 0, 6, 0, 0 },
		      	   { 6, 0, 8, 0, 0, 0, 0, 2, 8 },
		      	   { 4, 1, 0, 6, 0, 8, 0, 0, 0 },
		      	   { 8, 6, 0, 0, 3, 0, 1, 0, 0 },
		      	   { 0, 0, 0, 0, 0, 0, 4, 0, 0 } };
		sud.setMatrix(matin);
		sud.clear();
		for (int i=0;i<9;i++) {
			for (int k=0; k<9;k++) {
				assertTrue(sud.getMatrix()[i][k]==0,"Solved matrix is not correct");
			}
		}
	}
	@Test
	void testIsValid() {
		int[][] mat = new int[9][9];
		mat[0][0]=1;
		sud.setMatrix(mat);
		assertTrue(sud.isValid(1, 0, 2), "isValid yields false when it should be true");
		assertFalse(sud.isValid(1,0,1), "isValid yields true when it should be false");
	}
	@Test
	void testIsAllValid() {
		int[][] mat = { { 5, 4, 8, 1, 7, 9, 3, 6, 2 },
		      	   { 3, 7, 6, 8, 2, 4, 9, 1, 5 },
		      	   { 1, 9, 2, 5, 6, 3, 8, 7, 4 },
		      	   { 7, 8, 4, 2, 1, 6, 5, 9, 3 },
		      	   { 2, 5, 9, 3, 8, 7, 6, 4, 1 },
		      	   { 6, 3, 1, 9, 4, 5, 7, 2, 8 },
		      	   { 4, 1, 5, 6, 9, 8, 2, 3, 7 },
		      	   { 8, 6, 7, 4, 3, 2, 1, 5, 9 },
		      	   { 9, 2, 3, 7, 5, 1, 4, 8, 6 } };
		sud.setMatrix(mat);
		assertTrue(sud.isAllValid(), "isAllValid yields false when it should be true");
		mat[0][0]=1;
		sud.setMatrix(mat);
		assertFalse(sud.isAllValid(), "isAllValid yields true when it should be false");
	}
	@Test
	void setGetClearNumber() {
		int[][] matin = { { 0, 0, 8, 0, 0, 9, 0, 6, 2 },
		      	   { 0, 0, 0, 0, 0, 0, 0, 0, 5 },
		      	   { 1, 2, 0, 5, 0, 0, 0, 0, 0 },
		      	   { 0, 0, 0, 2, 1, 0, 0, 9, 0 },
		      	   { 0, 5, 0, 0, 0, 0, 6, 0, 0 },
		      	   { 6, 0, 8, 0, 0, 0, 0, 2, 8 },
		      	   { 4, 1, 0, 6, 0, 8, 0, 0, 0 },
		      	   { 8, 6, 0, 0, 3, 0, 1, 0, 0 },
		      	   { 0, 0, 0, 0, 0, 0, 4, 0, 0 } };
		sud.setMatrix(matin);
		assertTrue(sud.getNumber(0, 0)==0,"Getnumber is faulty");
		sud.setNumber(1, 1, 3);
		assertTrue(sud.getNumber(1, 1)==3,"Setnumber is faulty");
		sud.clearNumber(1, 1);
		assertTrue(sud.getNumber(1, 1)==0,"Clearnumber is faulty");
		
	}

}