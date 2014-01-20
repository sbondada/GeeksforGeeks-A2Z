package arrays;

public class CountingInvertion 
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
	public int[] countInversion(int[] leftArray,int[] rightArray,int[] count)  
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
				count[0]=count[0]+(leftArray.length-i);
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
	public int[] countsort(int[] array,int start,int end,int[] count)
	{
		if(start!=end)
		{
                int n = (start+end)/2;
                System.out.println("start "+start+" end "+end+" n "+n);
                int[] leftSubArray=countsort(array, start, n,count);
                int[] rightSubArray=countsort(array,n+1,end,count);
                int[] mergedArray=countInversion(leftSubArray,rightSubArray,count);
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
		int[] array={1,3,5,4,2};
		CountingInvertion ci=new CountingInvertion();
		int[] count={0};
		int[] sortedArray=ci.countsort(array, 0, array.length-1,count);
		ci.printArray(sortedArray);
		System.out.println("the inversions are "+count[0]);
	}
}
