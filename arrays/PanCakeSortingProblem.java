package arrays;

public class PanCakeSortingProblem 
{
	public int BinarySearch(int[] array,int elepos,int start,int end)
	{
		int pos;
		if(start!=end)
		{
			int mid=(start+end)/2;
			//most important condition to check to find an element just greater than a element 
			//is to find the value at the position and just before it and check if the value is less and the 
			// next value is greater than the next value is the element

			//this makes the calculation process simple
			if(array[mid]<array[elepos] && array[mid+1]>=array[elepos])
			{
				return mid+1;
			}
			//the most important thing to know is start+end/2 will always end up lower than end if start>end
			if(array[mid]<array[elepos])
			{
				pos=BinarySearch(array, elepos, mid+1, end);
			}
			// i am including the mid element also in this search because i haven't checked the possibility of mid
			//being the just greater element
			else
			{
				pos=BinarySearch(array, elepos, start, mid);
			}

		}
		//this condition means their is only a single element in the list
		else
		{
			if(array[start]>=array[elepos])
			{
				return start;
			}
			else
			{
				return -1;
			}
		}
	return pos;	
	}
	public void flip(int[] array, int pos)
	{
		int mid=pos/2;
		for(int i=0;i<=mid;i++)
		{
			int temp;
			temp=array[i];
			array[i]=array[pos-i];
			array[pos-i]=temp;
		}
	}
	public void sort(int[] array)
	{
		for(int i=1;i<array.length;i++)
		{
			//looping the array to find the position of each element in the array and placing it at that position
			//it is supposed to be in a sorting list
			int pos=BinarySearch(array, i,0,i-1);
			//the output -1 specifies that we need not place the element at i position anywhere else as it itself is in 
			//correct position
			if (pos!=-1)
			{
				flip(array, pos-1);
				flip(array, i-1);
				flip(array, i);
				flip(array, pos);
			}
		}
	}
	public static void main(String args[])
	{
		int[] array={1,4,5,7,2,8,9,6};
		PanCakeSortingProblem pcsp = new PanCakeSortingProblem();
		pcsp.sort(array);
		for(int i =0;i<array.length;i++)
		{
			System.out.print(array[i]+" ");
		}
	}
}