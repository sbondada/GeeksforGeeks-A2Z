package arrays;

public class MoveZeros2ArrayEnd 
{
	public int[] move2End(int[] array1)
	{
		int inc=0;	
		int incz,incnz;
		int zeroCount=0;
		// looping the whole list
		while(inc<array1.length)
		{
//			System.out.println("loop entry "+zeroCount);
			//finding the first zero value
			if (array1[inc]==0)
			{
				incz=inc;
				zeroCount+=1;
				incnz=inc+1;
				//searching for the first non zero value
				while(incnz<array1.length)
				{
					//shifting the values from non zero position to zero position until reach the zero position
					if(array1[incnz]!=0)
					{
						array1[incz-(zeroCount-1)]=array1[incnz];
						//incz-(zeroCount-1) this over covers the zero positions so that after replacing no extra 0 is in between
						incnz+=1;
						incz+=1;
						inc=incnz;
					}
					else
					{
						System.out.println("inc value "+inc);
						break;
					}
				}
			}
			else
			{
				inc+=1;
			}
		}
		//adding the zeros to the last of the array
		for (int i=1;i<=zeroCount;i++)
		{
			array1[array1.length-i]=0;
		}
		return array1;
	}
	public static void main(String args[])
	{
		MoveZeros2ArrayEnd moveObj=new MoveZeros2ArrayEnd();
		int[] array1={1,0,2,4,0,4,3,0,2,6,7,0,3,0,3};
        for (int j=0;j<array1.length;j++)
		{
			System.out.print(array1[j]+" ");
		}
		array1=moveObj.move2End(array1);
		System.out.println("\n");
		for (int j=0;j<array1.length;j++)
		{
			System.out.print(array1[j]+" ");
		}
	}
}
