package arrays;

public class PancakeSorting 
{
	//all the functions are like the name suggests
	public void swap(int[] array,int i,int j)
	{
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
	public void flip(int[] array,int i,int j)
	{
		int mid=((i+j)/2);
		int k=0;
		while(i+k<=mid)
		{
			swap(array,k+i,j-k);
			k++;
		}
	}
	public int max(int[] array,int i,int j)
	{
		int max=0;
		int pos=i;
		for(int k=i;k<=j;k++)
		{
			if(array[k]>max)
			{
				max=array[k];
				pos=k;
			}
		}
		return pos;
	}
	public void sort(int[] array)
	{
		int i=0;
		while(i<array.length-1)
		{
			//every time the last element is the last element
			int j=array.length-1;
			// finding the max position so that i can flip that part of array from the starting of the end of the sorted array
			j=max(array,i,j);
			flip(array, i, j);
			//each max element is chosen and flipped to form the sorted array
			i++;
		}
	}
	public static void main(String args[])
	{
		int[] array={1,3,4,2,6,4,3,6,7};
		PancakeSorting ps=new PancakeSorting();
		ps.sort(array);
		for(int i=0;i<array.length;i++)
		{
			System.out.print(array[i]+" ");
		}
	}
}
