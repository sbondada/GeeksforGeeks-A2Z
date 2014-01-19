package arrays;

public class MergeSort 
{
	public void printArray(int[] sortedArray )
	{
		System.out.print("array at that time ");
		for(int i=0;i<sortedArray.length;i++)
		{
			System.out.print(sortedArray[i]+" ");
		}
		System.out.println();
	}
	public int[] merge(int[] leftArray,int[] rightArray)
	{
		printArray(leftArray);
		printArray(rightArray);
		int i=0,j=0,inc=0;
		int[] mergedArray=new int[leftArray.length+rightArray.length];
		//merge the array untill either the first counter or the second counter hits the end
		while(i<leftArray.length && j<rightArray.length)
		{
			if(leftArray[i]<=rightArray[j])
			{
				mergedArray[inc]=leftArray[i];
				inc++;
				i++;
			}
			else
			{
			    mergedArray[inc]=rightArray[j];
				inc++;
				j++;
			}
		}
		//then based which one ends the other array is copied completely into a new merged array
		if(i==leftArray.length)
		{
			while(j<rightArray.length)
			{
				mergedArray[inc]=rightArray[j];
				j++;
				inc++;
			}
			return mergedArray;
		}
		else
		{
			while(i<leftArray.length)
			{
				mergedArray[inc]=leftArray[i];
				i++;
				inc++;
			}
			return mergedArray;
		}
	}
	public int[] sort(int[] array,int start,int end)
	{
		if(start!=end)
		{
                int n = (start+end)/2;
                System.out.println("start "+start+" end "+end+" n "+n);
                int[] leftSubArray=sort(array, start, n);
                int[] rightSubArray=sort(array,n+1,end);
                int[] mergedArray=merge(leftSubArray,rightSubArray);
                System.out.println("merged length "+mergedArray.length);
                return mergedArray;
		}
		//if there exist a single element return that element as an array
		else
		{
			int[] mergedArray={array[start]};
			System.out.println("print eement "+mergedArray[0]);
			return mergedArray;
		}
	}
	public static void main(String args[])
	{
		int[] array={1,3,5,4,2,1,2,7,8};
		MergeSort ms = new MergeSort();
		int[] sortedArray=ms.sort(array, 0, array.length-1);
		ms.printArray(sortedArray);
	}
}
