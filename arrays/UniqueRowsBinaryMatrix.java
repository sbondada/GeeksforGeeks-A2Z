package arrays;

import java.util.HashMap;

public class UniqueRowsBinaryMatrix 
{
	//this function converts an 2d matrix to a 1d array of numbers when all the numbers are concatenated
	public int[] convert2integerarray(int[][] matrix)
	{
		int i=0;
		int[] newArray=new int[matrix.length];
		//looping in the 2d array
		while( i<matrix.length)
		{
			int j=0;
			int tempno=0;
			while(j<matrix[0].length)
			{
				//creating the row to a concatenated integer
				tempno=10*tempno+matrix[i][j];
				j++;
			}
			newArray[i]=tempno;
			i++;
		}
		return newArray;
	}
	//the function which converts the concatenated integer to individual row elements
	public int[][] convert2Matrix(Integer[] array,int j)
	{
		int[][] Matrix=new int[array.length][j];
		//looping the concatenated integer array
		for(int m=0;m<array.length;m++)
		{
			int n=j-1;
			// dividing the integer so that we get the row by dividing the number and keeping the remainder in the 
			//last and looping it till we put our value into each uniquerow matrix
			while(n>=0)
			{
				int rem=array[m]%10;
				array[m]/=10;
				Matrix[m][n]=rem;
				n--;
			}
		}
		return Matrix;
	}
	public int[][] getUniqueRows(int[][] matrix)
	{
		int[] rowArray=convert2integerarray(matrix);
		//mapping the rowintegers to  a set and get unique row integers so that it can again form the 
		//Uniquerow matrix
		HashMap<Integer,Integer> rowMap=new HashMap<>();
		for(int i=0;i<rowArray.length;i++)
		{
			rowMap.put(rowArray[i],1);
		}
		Integer[] row=rowMap.keySet().toArray(new Integer[rowMap.size()]);
		int[][] uniqueArray=convert2Matrix(row,matrix[0].length);
		return uniqueArray;
	}
	public static void main(String[] args)
	{
		int[][] matrix={{0,1,0,0,1},{1,0,1,1,0},{0,1,0,0,1},{1,1,1,0,0}};
		UniqueRowsBinaryMatrix urbm= new UniqueRowsBinaryMatrix();
		int[][] uniqueRowArray=urbm.getUniqueRows(matrix);
		for(int i=0;i<uniqueRowArray.length;i++)
		{
			for(int j=0;j<uniqueRowArray[0].length;j++)
			{
				System.out.print(uniqueRowArray[i][j]+" ");
			}
			System.out.println();
		}
	}
}
