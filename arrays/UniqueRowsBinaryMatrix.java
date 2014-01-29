package arrays;

public class UniqueRowsBinaryMatrix 
{
	public static void main(String[] args)
	{
		int[][] array={{0,1,0,0,1},{1,0,1,1,0},{0,1,0,0,1},{1,1,1,0,0}};
		UniqueRowsBinaryMatrix urbm= new UniqueRowsBinaryMatrix();
		int[][] uniqueRowArray=array;
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
