package bits;

public class CountSetBitsInArray 
{
	// supercool algorithm
	public int countSetBits(int num)
	{
		int setbit=0;;
		while(num!=0)
		{
			num=num&(num-1);//this statement unsets the last set bit
			setbit++;
		}
		return setbit;
	}
	public static void main(String args[])
	{	
		CountSetBitsInArray csbia = new CountSetBitsInArray();
		int[] array={1,2,3,4,5,6,74,3,2,3,5};
		int i=0;
		int totalsetbit=0;
		while(i<array.length)
		{
			System.out.print(Integer.toBinaryString(array[i]));
			int setbit=csbia.countSetBits(array[i]);
			System.out.println(" "+setbit);
			totalsetbit+=setbit;
			i++;
		}
		System.out.println("total bit count "+totalsetbit);
	}
}
