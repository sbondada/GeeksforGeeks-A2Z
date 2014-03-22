package arrays;

public class MergeSort 
{
	public int[] merge(int[] left,int[] right)
	{
		int i=0,j=0;
		int[] mergearray= new int[left.length+right.length];
		int inc=0;
		while(i<left.length && j<right.length)
		{
			mergearray[inc]=Math.min(left[i],right[j]);
			if(left[i]<right[j])
			{
				i++;
				inc++;
			}
			else
			{
				j++;
				inc++;
			}
		}
		if(i==left.length)
		{
			while(j<right.length)
			{
				mergearray[inc]=right[j];
				j++;inc++;
			}
		}
		if(j==right.length)
		{
			while(i<left.length)
			{
				mergearray[inc]=left[i];
				i++;inc++;
			}
		}
		return mergearray;
	}
	public int[] sort(int array[],int start,int end)
	{
		if(start<end)
		{
			int mid=(start+end)/2;
			int[] left=sort(array,start,mid);
			int[] right=sort(array,mid+1,end);
			return merge(left,right);
		}
		else
		{
			int[] temp=new int[1];
			temp[0]=array[start];
			return temp;
		}
	}
	public static void main(String args[])
	{
		MergeSort me = new MergeSort();
		int[] array = {9,2,3,1,22,21,43,11,23,5,4,7};
		int[] mergesort=me.sort(array, 0, array.length-1);
		for(int p : mergesort)
		{
			System.out.print(p+" ");
		}
		System.out.println();
	}
}
