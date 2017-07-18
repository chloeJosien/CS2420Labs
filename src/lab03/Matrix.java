package lab03;
/**
 * I agree not to talk about this lab until Tuesday, Jan 31 2017.
 * @author Chloe Josien
 * 
 */
public class Matrix {
	int numRows;
	int numColumns;
	int data[][];
	
	// Constructor with data for new matrix (automatically determines dimensions)
	public Matrix(int[][] data) {
		numRows = data.length; // d.length is the number of 1D arrays in the 2D array
		if(numRows == 0) {
			numColumns = 0;
		} else {
			numColumns = data[0].length; // d[0] is the first 1D array
		}
		this.data = new int[numRows][numColumns]; // create a new matrix to hold the data

		//TODO: Copy the values from the parameter to the this.data field
		for(int rows=0; rows<numRows; rows++){
			for(int col=0; col<numColumns;col++){
				this.data = data;
			}
		}
		
	}
	
	public Matrix plus(Matrix matrix) {
		
		/*
		 * TODO: replace the below return statement with the correct code, 
		 *  This function must check if the two matrices are compatible for addition, if not, return null.
		 *  If they are compatible, create a new matrix and fill it in with
		 *  the correct values for matrix addition
		 */
		
		if( matrix.numColumns == numColumns && matrix.numRows == numRows){
			Matrix addMatrix = new Matrix(data);
			for(int rows=0; rows<numRows; rows++){
				for(int col=0; col<numColumns;col++){
					matrix.data[rows][col] = addMatrix.data[rows][col]+ matrix.data[rows][col];
				}
			}
			
			return matrix;
		}
		else{
	
		return null; // placeholder
		}
	}
	
	
	@Override
	public String toString() {
		/*
		 * TODO: replace the below return statement with the correct code, you must return a String that represents this 
		 * 			matrix, as specified on the quiz question.
		 */
		String matrix = "";
		Matrix matrixString = new Matrix(data);
		for(int rows=0; rows<numRows; rows++){
			for(int col=0; col<numColumns;col++){
				if(col%3==0){
					matrix += "/n" + matrixString.data[rows][col];
				}
				matrix += matrixString.data[rows][col];
			}
		}
		return matrix; // placeholder
	}
	


	/** 
	 * ********************
	 * BONUS ROUND! ONLY CONTINUE BELOW IF YOU ARE SATISFIED WITH YOUR SOLUTION FOR 
	 * THE ABOVE CODE:
	 * {@link #Matrix(int[][])}, {@link #plus(Matrix)}, AND {@link #toString()}
	 * *********************
	 * */

	@Override
	public boolean equals(Object other) {
		if(!(other instanceof Matrix)) { // make sure the Object we're comparing to is a Matrix
			return false;
		}
		
		/*
		 * TODO: replace the below return statement with the correct code, you must return the correct value
		 * 			after determining if this matrix is equal to the input matrix
		 */
		return false; // placeholder
	}
}
