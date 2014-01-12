package arrays;

public class SplitPositivesNegatives 
{
	public void swap(int[] array,int pos1,int pos2)
	{
		System.out.println("entry to swap");
		int temp;
		temp=array[pos1];
		array[pos1]=array[pos2];
		array[pos2]=temp;
	}
	public int[] splitsigns(int[] array)
	{
		int i =0;
		int j=-1;
		while(i<array.length)
		{
			if(array[i]<0)
			{
				if( j==-1)
				{
				    j=0;
				    swap(array, j, i);
				    j++;
				}
				else
				{
					swap(array,j,i);
					j++;
				}
			}
			i++;
		}
		return array;
	}
	public static void main(String args[])
	{
		int[] array={1,-2,-3,4,-5,3,4,5};
		SplitPositivesNegatives spn= new SplitPositivesNegatives();
		int[] shiftedArray=spn.splitsigns(array);
		for(int i=0;i<shiftedArray.length;i++)
		{
             System.out.println(shiftedArray[i]+" ");
		}
	System.out.println();	
	}
}
