package arrays;

public class MaxSortedMatrixRow 
{
	//function serches for the position of seperation or the postion of the starting one
	public int search(int[] array,int start,int end)
	{
//		System.out.println(" start and end "+start+" "+end);
		int mid=(start+end)/2;
		int pos=-1;
		//checking if the array has all ones then its 0 to return
		if(array[0]==1)
		{
			return 0;
		}
		//checking if the array has any one then it is the length of array to return
		if(array[array.length-1]==0)
		{
			return array.length;
		}
		//checking the break condition neglecting the recursion if the recursion array has a single element
		if(start<end)
		{
			//below two conditions are to find the seperation points
			if(array[mid]==1 && array[mid-1]==0)
			{
				return mid;
			}
			if(array[mid]==0 && array[mid+1]==1)
			{
				return mid+1;
			}
			//recursing to the 1st part
			if(array[mid]==1)
			{
				pos=search(array, start, mid-1);
			}
			//recursing to the second part
			else
			{
				pos=search(array, mid+1, end);
			}
		}
		return pos;
	}
	//finding the seperation point and using that to find no of ones in each row of the matrix
	public int[] convert2oneCountArray(int[][] matrix)
	{
		int[] countArray=new int[matrix.length];
		for (int i=0;i<matrix.length;i++)
		{
			int temppos=search(matrix[i],0,matrix[i].length);
			int tempcount=matrix[i].length-temppos;
			countArray[i]=tempcount;
		}
		return countArray;
	}
	//this function has to just find the row with max no of ones 
	public int findRowWithMaxNoOfOnes(int[][] matrix)
	{
		//calculating no of ones for each row in the matrix
		int[] countArray=convert2oneCountArray(matrix);
		int max=0,pos=-1;
		//finding the row with maximum no of ones from the list of ones in each row
		for(int i=0;i<countArray.length;i++)
		{
			if(countArray[i]>max)
			{
				max=countArray[i];
				pos=i;
			}
		}
		return pos;
	}
	public static void main(String args[])
	{
		int[][] matrix={{0,1,1,1,1},{0,0,1,1,1},{0,0,0,0,1},{1,1,1,1,1}};
		MaxSortedMatrixRow msmr= new MaxSortedMatrixRow();
		int pos=msmr.findRowWithMaxNoOfOnes(matrix);
		System.out.println(pos);
	}
}
