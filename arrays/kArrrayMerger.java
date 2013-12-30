package arrays;

public class kArrrayMerger 
{
	//function counts the total elements in the array of arrays so that a array of total elements length can be created
	public int linearLengthOfArray(int[][] kArray)
	{
		int inc=0,sum=0;
		while(inc<kArray.length)
		{
			sum+=kArray[inc].length;
			inc+=1;
		}
		return sum;
	}
	public int[] performKArrayMerger(int[][] kArray)
	{
		boolean empty=false;
		//array which would have the k array sorted in to a single array
		int[] sortedArray=new int[linearLengthOfArray(kArray)];
		//this array keeps the track of position in each array in array of arrays
		int[] posArray=new int[kArray.length];
		//this keeps the track of pos where the min elements have to be inserted into the array
		int sortedArrayPos=0;
		//this loops untill the empty gets true.and it gets true only when there are any elements
		//are left in any array of the array of arrays
		while(!empty)
		{
			empty=true;
			int min=Integer.MAX_VALUE,pos=-1;
			for(int i=0;i<kArray.length;i++)
			{
				//checking if the array of the array of arrays has any more elements.and empty would
				//break if all the arrays for array of arrays have no more elements
                if(posArray[i]>=kArray[i].length)
                {
                        empty&=true;
//                        System.out.println("break condition"+empty);
                }
                else
                {
                        empty&=false;
                        if(kArray[i][posArray[i]]<min)
                        {
                        	min=kArray[i][posArray[i]];
                            pos=i;
                        }
				}
			}
			//adding into the sorted array only if the min is found from the top search
			if(pos!=-1)
			{
                sortedArray[sortedArrayPos]=min;
                sortedArrayPos+=1;
                posArray[pos]+=1;
                System.out.println("print pos array of "+pos+" is  "+posArray[0]);
			}
		}
		return sortedArray; 
	}
	public static void main(String args[])
	{
		int k=3;
		int[][] array1=new int[k][];
		array1[0]=new int[]{1,3,5,12,23,35,46};
		array1[1]=new int[]{34,56,455,665,765};
		array1[2]=new int[]{1,2,3,4,5,6,34,56};
		kArrrayMerger kam=new kArrrayMerger();
		int[] sortedArray=kam.performKArrayMerger(array1);
		System.out.println("\n");
		for(int i=0;i<sortedArray.length;i++)
		{
			System.out.print(sortedArray[i]+" ");
		}
	}
}
