package arrays;

public class FindMinInRotatedArray 
{
	public int getMinElement(int[] array,int start,int stop)
	{
		int mid=((start+stop)/2);
//		System.out.println("mid value "+mid);
		int min;
		//min element condition is if the element to the left and right are small in the rotated sorted array 
		//it is the min element
		if(array[mid]<=array[mid+1] && array[mid]<=array[mid-1])
		{
			return array[mid];
		}
		//most important and only needed condition to check if the last element in the 
		//subarray is smaller than the mid element.if true then it is supposed to be in the right half
		else if(array[mid]>array[stop])
		{
			min=getMinElement(array, mid+1, stop);
		}
		//moving to left half
		else
		{
			min=getMinElement(array, start, mid-1);
		}
		return min;
		
	}
	public static void main (String Args[])
	{
		int[] array=new int[]{56,67,1,5,45,47,52,53,55};
		for(int i=0;i<array.length;i++)
		{
			System.out.print(array[i]+" ");
		}
		System.out.println();
		//returning directly the min if the array is not rotated at all
		if(array[0]<array[array.length-1])
		{
			System.out.println("the min elements is "+array[0]);
		}
		FindMinInRotatedArray fmra=new FindMinInRotatedArray();
		int minElement=fmra.getMinElement(array,0,array.length-1);
		System.out.println("min elements is "+minElement);
	}
}
