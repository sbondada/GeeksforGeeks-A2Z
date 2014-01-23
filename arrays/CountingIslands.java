package arrays;

public class CountingIslands 
{
	public void traverse(int[][] array,int[][] visitedArray,int i, int j)
	{
		int	rowlen=array[0].length;
		int collen=array[1].length;
		if(i-1>=0 && j+1<collen && array[i-1][j+1]==1 && visitedArray[i-1][j+1]==0) 
		{
			visitedArray[i-1][j+1]=1;
			traverse(array, visitedArray, i-1, j+1);
		}
		if(j+1<collen && array[i][j+1]==1 && visitedArray[i][j+1]==0)
		{

			visitedArray[i][j+1]=1;
			traverse(array, visitedArray, i, j+1);
		}
		if(i+1<rowlen && j+1 < collen && array[i+1][j+1]==1 && visitedArray[i+1][j+1]==0 )
		{
			visitedArray[i+1][j+1]=1;
			traverse(array, visitedArray, i+1, j+1);
		}
		if( i-1>=0 && array[i-1][j]==1 && visitedArray[i-1][j]==0 )
		{
			visitedArray[i-1][j]=1;
			traverse(array, visitedArray, i-1, j);
		}
		if(i+1<rowlen && array[i+1][j]==1 && visitedArray[i+1][j]==0)
		{
			visitedArray[i+1][j]=1;
			traverse(array, visitedArray, i+1, j);
		}
		if(i-1>=0 && j-1>=0 && array[i-1][j-1]==1 && visitedArray[i-1][j-1]==0)
		{
			visitedArray[i-1][j-1]=1;
			traverse(array, visitedArray, i-1, j-1);
		}
		if(j-1>=0 && array[i][j-1]==1 && visitedArray[i][j-1]==0)
		{
			visitedArray[i][j-1]=1;
			traverse(array, visitedArray, i, j-1);
		}
		if(i+1<rowlen && j-1>=0 && array[i+1][j-1]==1 && visitedArray[i+1][j-1]==0)
		{
			visitedArray[i+1][j-1]=1;
			traverse(array, visitedArray, i+1, j-1);
		}
			
	}
	public int countIslands(int[][] array)
	{
		int[][] visitedArray = new int[array.length][array[1].length];
		int count=0;
		for(int i=0;i<array[0].length;i++)
		{
			for(int j=0;j<array.length;j++)
			{
				if(visitedArray[i][j]==0 && array[i][j]==1)
				{
					count++;
					visitedArray[i][j]=1;
					traverse(array,visitedArray,i,j);
				}
			}
		}
		return count;
	}
	public static void main(String args[])
	{
		int[][] array={ {1, 1, 0, 0, 0},
		                {0, 1, 0, 0, 1},
		                {1, 0, 0, 1, 1},
		                {0, 0, 0, 0, 0},
		                {1, 0, 1, 0, 1} };
		CountingIslands ci = new CountingIslands();
		int count=ci.countIslands(array);
		System.out.println(count);
	}
}
