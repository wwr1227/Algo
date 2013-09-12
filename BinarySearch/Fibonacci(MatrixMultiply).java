class Matrix{
	long a11;
	long a12;
	long a21;
	long a22;
}
public class Fibonacci{
	public long Fibonacci(int n){
	      int result[2] = {0, 1};
	      if(n < 2)
	            return result[n];
	      Matrix ansMatrix = MatrixPower(n - 1);
	      return ansMatrix.a11;
	}
	public Matrix multiplyMatrix(Matrix a, Matrix b){
		Matrix c;  
		c.a11 = a.a11*b.a11+a.a12*b.a21;  
		c.a12 = a.a11*b.a12+a.a12*b.a22;  
		c.a21 = a.a21*b.a11+a.a22*b.a21;  
		c.a22 = a.a21*b.a12+a.a22*b.a22;	  
		return c;  
	}
	public Matrix MatrixPower(int int n){
	      if(n <= 0) return null;
	
	      Matrix matrix;
	      if(n == 1){
	            matrix = Matrix(1, 1, 1, 0);
	      }
	      else if(n % 2 == 0){
	            matrix = MatrixPower(n / 2);
	            matrix = multiplyMatrix(matrix, matrix);
	      }
	      else if(n % 2 == 1){
	            matrix = MatrixPower((n - 1) / 2);
	            matrix = multiplyMatrix(matrix, matrix);
	            matrix = multiplyMatrix(matrix, new Matrix(1, 1, 1, 0));
	      }
	      return matrix;
	}
}
