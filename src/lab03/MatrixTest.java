package lab03;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {

	@Test
	public void test() {
		int[][] test = new int[3][3];
		for(int rows=0; rows<3; rows++){
			for(int col=0; col<3;col++){
				test[rows][col]= rows+col;
			}
		}
		Matrix testMatrix = new Matrix(test);
		assertEquals("001/n001/n001", testMatrix.toString() );
	}
	
	@Test
	public void test2() {
		int[][] test = new int[3][3];
		for(int rows=0; rows<3; rows++){
			for(int col=0; col<3;col++){
				test[rows][col]= rows+col;
			}
		}
		Matrix testMatrix = new Matrix(test);
		testMatrix.plus(testMatrix);
		assertEquals("", testMatrix.toString() );
	}

}
