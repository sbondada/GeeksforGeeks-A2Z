package bits;

public class FindSetBitPos 
{
	public int getSetBitPos(int x)
	{
		int bitlen=Integer.toBinaryString(x).length();
		int tempx=1;
		int pos=1;
		while(bitlen!=0)
		{
			if((int)(x^tempx)==0)
			{
				return pos;
			}
			pos++;
			tempx<<=1;
			bitlen--;
		}
		return -1;
	}
	public static void main(String args[])
	{
		int x=0b000000100;
		FindSetBitPos fsbp=new FindSetBitPos();
		int pos=fsbp.getSetBitPos(x);
		if(pos!=-1)
		{
		System.out.println("position of the set bit "+pos);
		}
		else
		{
			System.out.println("No set bit in the number");
		}
	}
}
