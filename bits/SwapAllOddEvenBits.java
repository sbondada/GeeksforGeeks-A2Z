package bits;

public class SwapAllOddEvenBits 
{
	public int getswappedBits(int x) 
	{
		int tempEven=0xAAAAAAAA; 
//		System.out.println(Integer.toBinaryString(tempEven));
		int tempOdd=0x55555555;
//		System.out.println(Integer.toBinaryString(tempOdd));
		int evenbits=x&tempEven;
//		System.out.println(Integer.toBinaryString(evenbits));
		int oddbits=x&tempOdd;
//		System.out.println(Integer.toBinaryString(oddbits));
		evenbits>>=1;
//		System.out.println(Integer.toBinaryString(evenbits));
		oddbits<<=1;
//		System.out.println(Integer.toBinaryString(oddbits));
		return evenbits^oddbits;
	}
	public static void main(String args[])
	{
		int x = 0b10011010111011;
		SwapAllOddEvenBits saoeb = new SwapAllOddEvenBits();
		int swapedNo=saoeb.getswappedBits(x);
		System.out.println("swapped binary  no is "+Integer.toBinaryString(swapedNo));
	}
}
